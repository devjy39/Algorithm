package practice.collections;

import java.time.LocalDate;

public class PracticeCode {
    private static final int[] daysArray;

    static {
        daysArray = new int[13];
        daysArray[1] = daysArray[3] = daysArray[5] = daysArray[7] = daysArray[8] = daysArray[10] = daysArray[12] = 31;
        daysArray[4] = daysArray[6] = daysArray[9] = daysArray[11] = 30;
    }

    public int getDays() {
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int month = now.getMonthValue();

        return month == 2 ? getFebruaryDays(year) : daysArray[month];
    }

    private static int getFebruaryDays(int year) {
        if ((year % 4 == 0) && (year % 100 != 0) && (year % 400) == 0) {
            return 29;
        } else {
            return 28;
        }
    }

}
