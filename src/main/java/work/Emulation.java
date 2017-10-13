package work;

import java.util.Random;

class Emulation {

    public static void hourEmulate() {
        Random rnd = new Random();
        int buyersNumber = rnd.nextInt(10) + 1;
        int purchasesNumber;

        System.out.println("\tВремя = " + DateAndTime.getHour() + ":00 " + "количество покупателей = " + buyersNumber);

        for (int i = 0; i < buyersNumber; i++) {

            purchasesNumber = rnd.nextInt(11);
            System.out.println("\t\tПокупатель №" + (i + 1) + " количество покупок = " + purchasesNumber);

            for (int j = 0; j < purchasesNumber; j++) {
                int wantedProduct = Stock.getRandomProductIndex();
                System.out.println("\t\t\tПокупка №" + (j + 1) + ", "
                        + "покупатель хочет купить : " + Stock.getProductInfo(wantedProduct));
                if (Stock.isInStock(wantedProduct)) {
                    CashOperation.purchase(wantedProduct);
                } else {
                    System.out.println("\t\t\t\tУвы, товара нет на складе, приходите завтра.");
                }
            }
            CashOperation.purchasesArrayClear();
        }
    }

    public static void dayEmulate() {
        System.out.println("День = " + DateAndTime.getDay());
        while (DateAndTime.getHour() <= 20) {
            hourEmulate();
            DateAndTime.nextHour();
        }
        Stock.productRenewal();
        DateAndTime.nextDay();

    }

    public static void monthEmulate() {
        while (DateAndTime.getDay() <= 30) {
            dayEmulate();
        }
    }
}

