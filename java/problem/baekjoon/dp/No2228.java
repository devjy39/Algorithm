package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2228 {
    static int[] arr;
    static int[][] dp;
    static final int M_INF = -10_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp = new int[M + 1][N];

        System.out.println(dfs(M, N - 1));
    }

    private static int dfs(int m, int idx) {
        if (m == 0) {
            return 0;
        } else if (dp[m][idx] != 0) {
            return dp[m][idx];
        }

        int range = (m - 1) * 2;
        int sum = 0;
        int max = M_INF;
        int result = M_INF;
        for (int j = idx; j >= range; j--) {
            max = Math.max(max, sum += arr[j]);
            sum = Math.max(0, sum);
            result = Math.max(result, dfs(m - 1, j - 2) + max);
        }

        return dp[m][idx] = result;
    }

}