package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No27212 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] comb = new int[c + 1][c + 1];  // 점수 조합표 c^2
        for (int i = 1; i <= c; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= c; j++) {
                comb[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] a = new int[n + 1];
        int[] b = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(getMaxSatisfaction(n, m, comb, a, b));
    }

    private static long getMaxSatisfaction(int n, int m, int[][] comb, int[] a, int[] b) {
        long[][] dp = new long[n + 1][m + 1];
        for (int i = 1; i <= m; i++) {
            dp[1][i] = Math.max(dp[1][i - 1], comb[a[1]][b[i]]);
        }
        for (int i = 2; i <= n; i++) {
            dp[i][1] = Math.max(comb[a[i]][b[1]], dp[i - 1][1]);

            for (int j = 2; j <= m; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], Math.max(comb[a[i]][b[j]] + dp[i - 1][j - 1], dp[i - 1][j]));
            }
        }

        return dp[n][m];
    }


}