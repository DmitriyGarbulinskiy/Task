package work;


class DateAndTime {
    private static int iDay = 1;
    private static int iHour = 8;

    public static int getDay() {
        return iDay;
    }

    public static int getHour() {
        return iHour;
    }

    public static void nextDay() {
        iDay++;
        iHour = 8;
    }
    public static void nextHour() {
        iHour++;
    }
}

