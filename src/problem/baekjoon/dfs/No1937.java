package problem.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1937 {
    static int result;
    static int[][] dp, map;
    static int N;
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        map = new int[N][N];
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dp[i][j] == 0) {
                    dfs(i, j);
                }
                result = Math.max(result, dp[i][j]);
            }
        }

        System.out.println(result);
    }

    private static int dfs(int i, int j) {
        if (dp[i][j] > 0) {
            return dp[i][j];
        }

        int maxCount = 0;
        for (int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;

            if (x < 0 || y < 0 || x >= N || y >= N || map[x][y] <= map[i][j]) {
                continue;
            }

            maxCount = Math.max(maxCount, dfs(x, y));
        }

        return dp[i][j] = maxCount + 1;
    }

}