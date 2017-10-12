package work;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class CashOperation{
//    private static double fProfit =0;
    private static BigDecimal fProfit = new BigDecimal("0");
//    private static double fLoss=0;
    private static BigDecimal fLoss = new BigDecimal("0");
    private static List<Integer> purchasedProducts = new ArrayList<Integer>();


    public static void renewal(BigDecimal renewalSumm){
        fLoss =fLoss.add(renewalSumm);

    }
    public static void purchase(int i){

        System.out.print("\t\t\t\tТовар успешно приобретен ");
        fProfit= fProfit.add(finalPriceCalculation(i));

        purchasedProducts.add(i);
        Stock.productPurchased(i);
    }
    private static BigDecimal finalPriceCalculation(int i){

        BigDecimal fPrice = Stock.getProductPrice(i);
        fPrice= fPrice.multiply(finalExtaCharge(i));
        fPrice= fPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println("финальная цена = "+ fPrice +" " );
        return fPrice;
    }

    private static BigDecimal finalExtaCharge(int i){

        if(!(purchasedProducts.isEmpty())){
            int iMatches =0;
            for(int product: purchasedProducts){
                if(product == i)
                    iMatches++;
            }
            if(iMatches>=2){
                System.out.print("наценка при покупке 2+ товаров = 7% ");
                return new BigDecimal("1.07");
            }

        }

        if(DateAndTime.getHour()==18 ||DateAndTime.getHour()==19) {
            System.out.print("наценка при покупке с 18:00 до 20:00 = 8% ");
            return new BigDecimal("1.08");
        }
        if(DateAndTime.getDay()%7==6 || DateAndTime.getDay()%7==0 ) {
            System.out.print("наценка при покупке в выходные дни  = 15% ");
            return new BigDecimal("1.15");
        }
        else {
            System.out.print("стандартная наценка  = 10% ");
            return new BigDecimal("1.1");
        }
    }
    public static BigDecimal getProfit(){
        return fProfit;
    }

    public static BigDecimal  getLoss(){
        return fLoss;
    }
    public static BigDecimal getResult(){
        return fProfit.subtract(fLoss) ;
    }
    public static void purchasesArrayClear(){
        purchasedProducts.clear();
    }


}
