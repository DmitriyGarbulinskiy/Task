package work;

import java.io.IOException;

//*********************************************************************************************************************
// Test task "QA TestLab"
// The program emulates 30 days of work of the store
// DB will be loaded from "test.csv" file. You will find information about products left after work in this file
//
// All information you can find in following classes :
// "Stock" - This class "stores" DB and contains all functions to work with it
// "CashOperation" - This class contains all cash operations
// "DateAndTime" - This class contains all data and time counters and functions to work with it
// "Emulation" - This class contains main functions to emulate work time
//
// All public functions in all classes are static, so you can call them without creating objects
//*********************************************************************************************************************


public class Market {

    public static void main(String[] args) throws IOException {
        Stock.readDB();
        Emulation.monthEmulate();
        Stock.writeDB();
        Stock.getSalesInfo();
    }
}
