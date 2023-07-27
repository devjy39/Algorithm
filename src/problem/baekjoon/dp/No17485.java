package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17485 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] fuels = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                fuels[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(getMinFuel(fuels, n, m));
    }

    static int[][][] dp;

    static int getMinFuel(int[][] fuels, int n, int m) {
        dp = new int[n][m][4];

        int minFuel = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            minFuel = Math.min(minFuel, dfs(fuels, n - 1, i, 0));
        }

        return minFuel;
    }


    static int dfs(int[][] fuels, int x, int y, int dir) {
        if (x == 0) {
            return fuels[x][y];
        }else if (dp[x][y][dir] > 0) {
            return dp[x][y][dir];
        }

        int minFuel = Integer.MAX_VALUE;
        if (y > 0 && dir != 1) {
            minFuel = Math.min(minFuel, dfs(fuels, x - 1, y - 1, 1));
        }

        if (dir != 2) {
            minFuel = Math.min(minFuel, dfs(fuels, x - 1, y, 2));
        }

        if (y < fuels[0].length - 1 && dir != 3) {
            minFuel = Math.min(minFuel, dfs(fuels, x - 1, y + 1, 3));
        }

        return dp[x][y][dir] = fuels[x][y] + minFuel;
    }

}
