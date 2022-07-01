package problem.Practice.ProblemSolving_01.src;

import java.util.Arrays;

public class Practice2 {
    public static int solution(int n, int[] days, int[] prices) { // tabulation
        int[] dp = new int[n + 2];

        for (int i = n; i > 0; i--) { // 1 for 로 끝내기위해 역순으로 접근
            int day = i + days[i - 1] - 1;

            if (day <= n) {
                dp[i] = Math.max(dp[i + 1], dp[day + 1] + prices[i - 1]);
            } else {
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[1];
    }

    static int[] dp;
    public static int solution2(int n, int[] days, int[] prices) {
        dp = new int[n];
        return dfs(days, prices, n, 0);
    }

    static int dfs(int[] days, int[] prices, int n, int idx) { // memoization
        if (idx >= n) {
            return 0;
        }
        if (dp[idx] != 0) {
            return dp[idx];
        }

        int nextDay = idx + days[idx];

        return dp[idx] = Math.max(dfs(days, prices, n, idx + 1),
                dfs(days, prices, n, nextDay) + (nextDay <= n ? prices[idx] : 0));
    }

    public static void main(String[] args) {
        // Test code
        int[] days = {2, 1, 3, 2, 2};
        int[] prices = {10, 20, 30, 40, 60};
        System.out.println(solution(5, days, prices));
        System.out.println(solution2(5, days, prices));
        System.out.println(Arrays.toString(dp));

        System.out.println();
        days = new int[]{3, 3, 3, 1, 2, 3, 2, 1};
        prices = new int[]{50, 150, 20, 30, 10, 10, 30, 30};
        System.out.println(solution(8, days, prices));
        System.out.println(solution2(8, days, prices));
        System.out.println(Arrays.toString(dp));
    }
}
