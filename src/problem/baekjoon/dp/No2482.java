package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2482 {
    static final int MOD = 1_000_000_003;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        if (K > N / 2) {
            System.out.println(0);
            return;
        }

        int[][] dp = new int[N + 1][K + 1];
        dp[2][0] = dp[1][1] = dp[1][0] = 1;
        dp[2][1] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i][0] = 1;

            for (int j = Math.min(i, K); j >= 1; j--) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 2][j - 1]) % MOD;
            }
        }

        System.out.println((dp[N - 1][K] + dp[N - 3][K - 1]) % MOD);
    }

}