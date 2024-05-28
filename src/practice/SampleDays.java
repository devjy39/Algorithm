package practice;

import java.time.LocalDate;

public class SampleDays implements DaysInterface {

    // ssafy 기본 제공 코드

    public int getDays(int year, int month) {
        int days = 0;

        switch (month) { // 단순 비교 기반 로직
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:     // 위 case 모두 거쳐서 도달
                days = 31;
                break;

            case 4:
            case 6:
            case 9:
            case 11:     // 위 case 모두 거쳐서 도달
                days = 30;
                break;

            case 2:
                if ((year % 4 == 0) && (year % 100 != 0) && (year % 400) == 0) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;
        }

        return days;
    }
}
