package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No10844 {

    static Long[][] dp;
    static final int MOD = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        if (n == 1) {
            System.out.println(9);
            return;
        }

        dp = new Long[10][n];
        long sum = 0;

        for (int i = 1; i <= 9; i++) {
            sum += dfs(n - 1, i);
        }

        System.out.println(sum % MOD);
    }

    private static long dfs(int n, int prevNumber) {
        if (n <= 1) {
            return (prevNumber == 9 || prevNumber == 0) ? 1 : 2;
        }
        if (dp[prevNumber][n] != null) {
            return dp[prevNumber][n];
        }

        return dp[prevNumber][n] = (prevNumber != 0 ? dfs(n - 1, prevNumber - 1) : 0) +
                (prevNumber != 9 ? dfs(n - 1, prevNumber + 1) : 0) % MOD;
    }
}