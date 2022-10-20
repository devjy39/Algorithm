package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2156 {

    static Integer[] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new Integer[n + 1];
        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        System.out.println(dfs(n));
    }

    private static int dfs(int idx) {
        if (idx <= 0) {
            return 0;
        }
        if (dp[idx] != null) {
            return dp[idx];
        }

        return dp[idx] = Math.max(Math.max(dfs(idx - 2), dfs(idx - 3) + arr[idx - 1]) + arr[idx],
                dfs(idx - 1));
    }
}