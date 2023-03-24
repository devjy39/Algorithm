package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11057 {
    static int n;
    static int[][] dp;
    static final int MOD = 10_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n][10];

        System.out.println(dfs(1, 0));
    }

    private static int dfs(int idx, int number) {
        if (idx >= n) {
            return 10 - number;
        } else if (dp[idx][number] > 0) {
            return dp[idx][number];
        }

        int sum = 0;
        for (int i = number; i < 10; i++) {
            sum += dfs(idx + 1, i);
            sum %= MOD;
        }

        return dp[idx][number] = sum;
    }

}
