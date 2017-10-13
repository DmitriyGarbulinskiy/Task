package work;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


class Stock {
    private static List<String[]> arrProduct;
    private static List<Integer[]> arrSalesRenewal = new ArrayList<>();


    public static void readDB() throws IOException {
        CSVReader reader = new CSVReader(new FileReader("test.csv"), ';');
        arrProduct = reader.readAll();
        reader.close();


        for (int i = 0; i < arrProduct.size(); i++) {
            arrSalesRenewal.add(new Integer[2]);
            arrSalesRenewal.get(i)[0] = 0;
            arrSalesRenewal.get(i)[1] = 0;
        }
    }

    public static void writeDB() throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter("test.csv"), ';');
        writer.writeAll(arrProduct);
        writer.close();
    }

    public static int getRandomProductIndex() {
        Random rnd = new Random();
        return rnd.nextInt(arrProduct.size());
    }

    public static String getProductInfo(int i) {
        return arrProduct.get(i)[0] + ", "
                + arrProduct.get(i)[2] + ", "
                + arrProduct.get(i)[3];
    }

    public static BigDecimal getProductPrice(int i) {
        return new BigDecimal(arrProduct.get(i)[1]);
    }

    public static boolean isInStock(int i) {
        if (Integer.parseInt(arrProduct.get(i)[5]) > 0) {
            return true;
        } else return false;
    }

    public static void productPurchased(int i) {
        int currentNumber = Integer.parseInt(arrProduct.get(i)[5]);
        arrProduct.get(i)[5] = String.valueOf(currentNumber - 1);
        arrSalesRenewal.get(i)[0] += 1;
    }

    public static void productRenewal() {
        for (String[] products : arrProduct) {
            if (Integer.parseInt(products[5]) < 10) {
                products[5] = String.valueOf(Integer.parseInt(products[5]) + 150);
                arrSalesRenewal.get(arrProduct.indexOf(products))[1] += 150;
                CashOperation.renewal(new BigDecimal(Double.toString(150 * Double.parseDouble(products[1]))));
            }
        }
    }

    public static void getSalesInfo() throws IOException {
        FileWriter salesReport = new FileWriter("report.txt");
        for (int i = 0; i < arrProduct.size(); i++) {
            salesReport.write(getProductInfo(i)
                    + " продано = " + arrSalesRenewal.get(i)[0]
                    + ", дозакуплено = " + arrSalesRenewal.get(i)[1] + System.getProperty("line.separator"));

        }
        salesReport.write("Получено денег с продаж = " + CashOperation.getProfit() + System.getProperty("line.separator")
                + "Потраченно денег на дозакупку = " + CashOperation.getLoss() + System.getProperty("line.separator")
                + "Чистая прибыль = " + CashOperation.getResult());

        salesReport.close();
    }
}

