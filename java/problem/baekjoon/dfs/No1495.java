package problem.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1495 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[m + 1][n + 1];
        System.out.println(dfs(arr, m, s, 0));
    }

    static int[][] dp;

    private static int dfs(int[] arr, int m, int s, int depth) {
        if (dp[s][depth] != 0) {
            return dp[s][depth];
        } else if (depth >= arr.length) {
            return s;
        }

        int sum = -1;
        if (s + arr[depth] <= m) {
            sum = dfs(arr, m, s + arr[depth], depth + 1);
        }

        if (s - arr[depth] >= 0) {
            sum = Math.max(sum, dfs(arr, m, s - arr[depth], depth + 1));
        }

        return dp[s][depth] = sum;
    }

}

