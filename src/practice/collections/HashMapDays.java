package practice.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HashMapDays implements DaysInterface {
    private static final Map<Integer, Integer> daysMap;

    /*
    *   데이터가 정해져있기 때문에 불변 객체로 생성
    *   - 안정성을 위한 불변성 유지
    *   - 쓰레드 안정성
    * */

    static {
        Map<Integer, Integer> map = new HashMap<>(12, 1);
        map.put(1, 31);
        map.put(3, 31);
        map.put(5, 31);
        map.put(7, 31);
        map.put(8, 31);
        map.put(10, 31);
        map.put(12, 31);

        map.put(4, 30);
        map.put(6, 30);
        map.put(9, 30);
        map.put(11, 30);

        daysMap = Collections.unmodifiableMap(map);

        // jdk9 이후 간단하게 불변 Map을 만들 수 있는 팩토리 메서드

        /* Map.ofEntries Map.ofEntries로 여러 원소 생성 가능
            daysMap = Map.ofEntries(Map.entry(1, 31),
                Map.entry(3, 31),
                Map.entry(5, 31),
                Map.entry(7, 31),
                Map.entry(8, 31),
                Map.entry(10, 31),
                Map.entry(12, 31),
                Map.entry(4, 30),
                Map.entry(6, 30),
                Map.entry(9, 30),
                Map.entry(11, 30));
        */

        /*  Map.of 제일 간단함, but 10개 까지만 생성자 제공
            daysMap = Map.of(1, 31,
                3, 31,
                5, 31,
                7, 31,
                8, 31,
                10, 31,
                12, 31,
                4, 30,
                6, 30,
                9, 30,
                11, 30);
        */
    }


    public int getDays(int year, int month) {
        return month == 2 ? getFebruaryDays(year) : daysMap.get(month);
    }

    private static int getFebruaryDays(int year) {
        if ((year % 4 == 0) && (year % 100 != 0) && (year % 400) == 0) {
            return 29;
        }
        return 28;
    }

}
