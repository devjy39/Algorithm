package problem.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1890 {
    static int n;
    static long[][] dp;

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

        dp = new long[n][n];
        n--;
        System.out.println(dfs(map, 0, 0));
    }

    private static long dfs(int[][] map, int x, int y) {
        if (x == n && y == n) {
            return 1;
        } else if (dp[x][y] != 0) {
            return Math.max(0, dp[x][y]);
        }

        long count = 0;
        int jump = map[x][y];
        if (jump > 0) {
            if (x + jump <= n) {
                count += dfs(map, x + jump, y);
            }
            if (y + jump <= n) {
                count += dfs(map, x, y + jump);
            }
        }

        dp[x][y] = count == 0 ? -1 : count;
        return count;
    }

}
