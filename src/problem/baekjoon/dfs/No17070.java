package problem.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17070 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][n][3];
        n--;
        System.out.println(Math.max(0, dfs(map, 0, 1, 0)));
    }

    static int[][][] dp;

    // 가로 0 세로 1 대각선 2
    private static int dfs(int[][] map, int i, int j, int type) {
        if (i == n && j == n) {
            return 1;
        } else if (dp[i][j][type] != 0) {
            return Math.max(0, dp[i][j][type]);
        }

        int sum = 0;

        if (type != 1 && j < n && map[i][j + 1] != 1) { // 가로 이동
            sum += Math.max(0, dfs(map, i, j + 1, 0));
        }

        if (type != 0 && i < n && map[i + 1][j] != 1) { // 세로 이동
            sum += Math.max(0, dfs(map, i + 1, j, 1));
        }

        if (i < n && j < n && map[i + 1][j + 1] != 1 && map[i + 1][j] != 1 && map[i][j + 1] != 1) { // 대각 이동
            sum += Math.max(0, dfs(map, i + 1, j + 1, 2));
        }

        return dp[i][j][type] = sum == 0 ? -1 : sum;
    }

}
