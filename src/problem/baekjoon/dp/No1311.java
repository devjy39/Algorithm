package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1311 {
    static int[][] w;
    static int[] bits, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        w = new int[N][N];
        bits = new int[N];
        int sum = bits[0] = 1;
        for (int i = 1; i < N; i++) {
            sum += bits[i] = bits[i - 1] * 2;
        }
        dp = new int[sum + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(0, 0));
    }

    private static int dfs(int depth, int bit) {
        if (depth == w.length) {
            return 0;
        } else if (dp[bit] > 0) {
            return dp[bit];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < w.length; i++) {
            if ((bits[i] & bit) == 0) { // 겹치는 게 없으면
                min = Math.min(dfs(depth + 1, bits[i] | bit) + w[depth][i], min);
            }
        }

        return dp[bit] = min;
    }

}