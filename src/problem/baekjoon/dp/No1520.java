package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1520 {

    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1; // 시작좌표는 1로 초기화
        System.out.print(getPathCount(map, n - 1, m - 1));
    }


    /*
    *   i, j 좌표에서 올 수 있는 경우의 칸의 합
    *   dfs -> 메모이제이션 적용
    * */
    private static int getPathCount(int[][] map, int i, int j) {
        if (dp[i][j] > 0) {
            return dp[i][j];
        }

        int pathCountSum = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x < 0 || y < 0 || x >= map.length || y >= map[x].length || map[x][y] <= map[i][j] || dp[x][y] == -1) {
                continue;
            }

            pathCountSum += getPathCount(map, x, y);
        }

        dp[i][j] = pathCountSum == 0 ? -1 : pathCountSum;
        return pathCountSum;
    }

}