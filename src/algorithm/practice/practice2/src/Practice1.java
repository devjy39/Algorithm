package algorithm.practice.practice2.src;

import java.util.Arrays;

public class Practice1 {

    public static int solution(int[] rocks, int goal, int n) {
        if (rocks == null || rocks.length == 0) {
            return -1;
        }
        Arrays.sort(rocks);

        int left = 0;
        int right = goal;

        while (left <= right) {
            int mid = (left + right) >> 1; // 간격의 최소값

            int removeCount = getRemoveCount(rocks, goal, mid, n);
            if (removeCount < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private static int getRemoveCount(int[] rocks, int goal, int min, int n) {
        int cnt = 0;
        int prev = 0;

        for (int rock : rocks) {
            if (rock - prev < min) {
                cnt++;
            } else {
                prev = rock;
            }
            if (cnt > n) {
                break;
            }
        }

        if (goal - rocks[rocks.length - 1] < min) {
            cnt++;
        }

        return cnt;
    }


    public static void main(String[] args) {
        // Test code
        int[] rocks = {11, 2, 14, 21, 17};
        int goal = 25;
        int n = 2;
        System.out.println(solution(rocks, goal, n));
    }
}
