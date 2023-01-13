package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No23560 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n][3];
        dp[0][0] = 2; // 양쪽 0 - 010
        dp[0][1] = 1; // 왼쪽 1  - 100
        dp[0][2] = 1; // 오른쪽 1  - 001

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] * 2 + dp[i - 1][1] + dp[i - 1][2];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][2];
            dp[i][2] = dp[i - 1][0] + dp[i - 1][1];
        }

        System.out.print(dp[n - 1][0]);
    }

}