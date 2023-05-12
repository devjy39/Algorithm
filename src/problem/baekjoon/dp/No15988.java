package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No15988 {
    static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] arr = new int[t];
        int max = 0;
        for (int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        int[] dp = getDp(max);

        StringBuilder result = new StringBuilder();
        for (int i : arr) {
            result.append(dp[i]).append("\n");
        }
        System.out.print(result);
    }

    private static int[] getDp(int max) {
        int[] dp = new int[max + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= max; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
            dp[i] = (dp[i] + dp[i - 3]) % MOD;
        }

        return dp;
    }

}

