package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1309 {
    static int[][] dp;
    static int n;
    static final int MOD = 9901;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][3];

        System.out.println(dfs(0, 0));
    }

    private static int dfs(int depth, int prev) {
        if (depth == n) {
            return 1;
        } else if (dp[depth][prev] > 0) {
            return dp[depth][prev];
        }

        int count = dfs(depth + 1, 0);

        for (int i = 1; i <= 2; i++) {
            if (prev != i) {
                count += dfs(depth + 1, i);
                count %= MOD;
            }
        }

        return dp[depth][prev] = count;
    }

}

