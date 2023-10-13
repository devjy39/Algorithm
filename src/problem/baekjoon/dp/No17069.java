package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17069 {

    static long[][][] dp;
    static boolean[][] isBlock;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new long[3][n + 1][n + 1];
        isBlock = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                isBlock[i][j] = st.nextToken().equals("1");
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                isBlock[i][0] = isBlock[0][i] = true;
            }
        }

        dp[0][1][2] = 1;

        System.out.println(getCases(n, n, 0) + getCases(n, n, 1) + getCases(n, n, 2));
    }

    private static long getCases(int x, int y, int dir) {
        if (dp[dir][x][y] != 0) {
            return Math.max(0, dp[dir][x][y]);
        } else if (isBlock[x][y]) {
            return 0;
        }

        long count = 0;
        if (dir == 2) {
            if (!isBlock[x - 1][y] && !isBlock[x][y - 1]) {
                count += getCases(x - 1, y - 1, 0);
                count += getCases(x - 1, y - 1, 1);
                count += getCases(x - 1, y - 1, 2);
            }
        } else if (dir == 0) {
            if (!isBlock[x][y - 1]) {
                count += getCases(x, y - 1, 0);
                count += getCases(x, y - 1, 2);
            }
        } else {
            if (!isBlock[x - 1][y]) {
                count += getCases(x - 1, y, 1);
                count += getCases(x - 1, y, 2);
            }
        }

        if (count == 0) {
            dp[dir][x][y] = -1;
            return 0;
        }
        return dp[dir][x][y] = count;
    }

}
