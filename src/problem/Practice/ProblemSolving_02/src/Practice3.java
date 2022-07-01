package problem.Practice.ProblemSolving_02.src;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Practice3 {

    public static long[] solution(long n, long[] rooms) {
        Set<Long> reservation = new HashSet<>();

        long[] result = new long[rooms.length];
        long emptyRoom = 0;

        for (int i = 0; i < result.length; i++) {
            if (reservation.contains(rooms[i])) {
                long cur = rooms[i];
                boolean check = false;
                while (reservation.contains(cur)) {
                    cur++;
                    if (cur >= n) {
                        cur = emptyRoom;
                        check = true;
                    }
                }
                if (check) {
                    emptyRoom = cur + 1;
                }
                result[i] = cur;
                reservation.add(cur);
            } else {
                reservation.add(rooms[i]);
                result[i] = rooms[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test code
        long[] rooms = {0, 2, 3, 3};
        System.out.println(Arrays.toString(solution(3, rooms)));

        rooms = new long[] {1, 5, 7, 9, 9, 9, 1, 2, 2, 2};
        System.out.println(Arrays.toString(solution(10, rooms)));
    }
}
