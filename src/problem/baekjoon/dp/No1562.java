package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1562 {
    static final int MOD = 1_000_000_000;
    static final int ANSWER = (1 << 10) - 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n][1 << 10][10];

        int sum = 0;
        for (int i = 9; i > 0; i--) {
            sum = (sum + dfs(n - 1, 1 << i, i)) % MOD;
        }

        System.out.println(sum);
    }

    static int[][][] dp;

    private static int dfs(int n, int bit, int prev) {
        if (n <= 0) {
            return bit == ANSWER ? 1 : 0;
        } else if (dp[n][bit][prev] != 0) {
            return Math.max(0, dp[n][bit][prev]);
        }

        int sum = 0;
        if (prev > 0) {
            sum = dfs(n - 1, bit | 1 << (prev - 1), prev - 1);
        }

        if (prev < 9) {
            sum += dfs(n - 1, bit | 1 << (prev + 1), prev + 1);
            sum %= MOD;
        }

        dp[n][bit][prev] = sum == 0 ? -1 : sum;
        return sum;
    }

}

