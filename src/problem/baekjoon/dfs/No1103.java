package problem.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1103 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = str.charAt(j);
                map[i][j] = c == 'H' ? 0 : c - '0';
            }
        }

        dp = new int[n][m];

        System.out.println(dfs(map, 0, 0));
    }

    static int[][] dp;
    static final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static int dfs(int[][] map, int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        dp[i][j] = -1;

        int count = 0;

        for (int[] dirs : dirs) {
            int x = dirs[0] * map[i][j] + i;
            int y = dirs[1] * map[i][j] + j;

            if (x < 0 || y < 0 || x >= map.length || y >= map[x].length || map[x][y] == 0) {
                continue;
            }
            int nextCount = dfs(map, x, y);
            if (nextCount == -1) {
                return -1;
            }
            count = Math.max(count, nextCount);
        }

        return dp[i][j] = count + 1;
    }

}

