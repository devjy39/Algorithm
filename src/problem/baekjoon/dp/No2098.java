package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2098 {
    static int[][] costs,dp;
    static int[] bits;
    static int full;
    static final int INF = 20_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        bits = new int[N];
        full = bits[0] = 1;
        for (int i = 1; i < N; i++) {
            full += bits[i] = bits[i - 1] * 2;
        }
        dp = new int[N][full];

        costs = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(0, 1)); // 0에서 출발
    }

    // 마지막에 0으로 돌아가는 길이 없는 경로도 없다는 표시가 저장되어야 하니
    // 연쇄적으로 INF가 포함된 값이 저장되도록 해야한다.
    private static int dfs(int node, int bit) {
        if (bit == full) {
            return costs[node][0] == 0 ? INF : costs[node][0];
        } else if (dp[node][bit] > 0) {
            return dp[node][bit];
        }

        int cost = INF;

        for (int i = 1; i < costs.length; i++) {
            if (costs[node][i] > 0 && (bits[i] & bit) == 0) {
                cost = Math.min(cost, dfs(i, bit | bits[i]) + costs[node][i]);
            }
        }

        return dp[node][bit] = cost;
    }

}