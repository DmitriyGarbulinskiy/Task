package work;

import java.io.IOException;




public class Market {

    public static void main(String[] args) throws IOException {
        Stock.readDB();
        Emulation.monthEmulate();
        Stock.writeDB();
        Stock.getSalesInfo();
    }
}
