package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2011 {
    static final int MOD = 1_000_000, MAX = 26;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[str.length()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.charAt(i) - '0';
        }
        dp = new int[arr.length];

        System.out.println(dfs(arr, 0));
    }

    private static int dfs(int[] arr, int depth) {
        if (depth >= arr.length) {
            return 1;
        } else if (dp[depth] != 0) {
            return Math.max(dp[depth], 0);
        } else if (arr[depth] == 0) {
            return 0;
        }

        int secondCase = (depth + 1 < arr.length && arr[depth] * 10 + arr[depth + 1] <= MAX)
                            ? dfs(arr, depth + 2) : 0;
        int result = (dfs(arr, depth + 1) + secondCase) % MOD;
        dp[depth] = result > 0 ? result : -1;
        return result;
    }

}

