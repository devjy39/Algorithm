package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17404 {
    static int MAX_VALUE = 10000;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        int result = Integer.MAX_VALUE;
        result = Math.min(result, dpCase(n, 0, arr[0][0]));
        result = Math.min(result, dpCase(n, 1, arr[0][1]));
        result = Math.min(result, dpCase(n, 2, arr[0][2]));

        System.out.print(result);
    }

    private static int dpCase(int n, int idx, int number) {
        int[][] dp = new int[n][3];
        dp[0][0] = MAX_VALUE;
        dp[0][1] = MAX_VALUE;
        dp[0][2] = MAX_VALUE;
        dp[0][idx] = number;
        dp[1][idx] = MAX_VALUE;

        for (int i = 1; i < n; i++) {
            dp[i][0] = arr[i][0] + Integer.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = arr[i][1] + Integer.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = arr[i][2] + Integer.min(dp[i - 1][0], dp[i - 1][1]);
        }

        dp[n - 1][idx] = Integer.MAX_VALUE;
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }
}