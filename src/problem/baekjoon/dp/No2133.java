package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2133 {

    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        System.out.println(N % 2 == 0 ? dfs(N) : 0);
    }

    private static int dfs(int n) {
        if (n < 2) {
            return 1;
        } else if (dp[n] > 0) {
            return dp[n];
        }

        int sum = 0;
        for (int i = 4; i <= n; i+=2) {
            sum += 2 * dfs(n - i);
        }

        return dp[n] = 3 * dfs(n - 2) + sum;
    }

}