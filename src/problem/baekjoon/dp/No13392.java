package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No13392 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String now = br.readLine();
        String target = br.readLine();
        int[] locks = new int[n + 1];
        int[] targets = new int[n + 1];
        for (int i = 0; i < n; i++) {
            locks[i] = now.charAt(i) - '0';
            targets[i] = target.charAt(i) - '0';
        }

        System.out.println(dp(n, locks, targets));
    }

    private static int dp(int n, int[] locks, int[] targets) {
        int[][] dp = new int[n + 1][10];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 10; j++) {
                int plus = (targets[i] + 10 - ((locks[i] + j) % 10)) % 10;
                dp[i][j] = Math.min(dp[i + 1][(plus + j) % 10] + plus, dp[i + 1][j] + 10 - plus);
            }
        }

        return dp[0][0];
    }

}