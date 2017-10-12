package work;

//Класс содежращий информацию о времени и дне
class DateAndTime{
    //    переменные отображающие  день и время (необходимо для определения наценки)
    private static int iDay =1;
    private static int iHour = 8;

    //    Получения дня
    public static int getDay(){
        return iDay;
    }

    //    Получения времени
    public static int getHour(){
        return iHour;
    }

    //    Перевод дня на следующий
    public static void nextDay(){
        iDay++;
        iHour =8;
    }

    //    Перевод времени на час вперед
    public static void nextHour() {
        iHour++;
    }

}

