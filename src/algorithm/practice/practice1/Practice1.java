package algorithm.practice.practice1;

import java.util.Arrays;

public class Practice1 {
    public static int solution(int n, int[] times) {
        if (times == null || times.length == 0) {
            return -1;
        }

        Arrays.sort(times); //최적화

        int left = (times[0] * n) / times.length;
        int right = (times[times.length - 1] * n) / times.length;

        while (left <= right) {
            int mid = (left + right) >> 1;

            int sum = 0;
            for (int time : times) {
                sum += mid / time;
                if (sum >= n) { //최적화
                    break;
                }
            }

            if (sum >= n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        // Test code
        int n = 6;
        int[] times = {7, 10};
        System.out.println(solution(n, times));
    }
}
