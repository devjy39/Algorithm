package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2169 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(getMaxValue(N, M, map));
    }

    private static int getMaxValue(int N, int M, int[][] map) {
        int[][] dp = new int[N + 1][M + 1];
        int[] left = new int[M + 1];
        int[] right = new int[M + 2];
        left[0] = -100_000;
        right[M + 1] = -100_000;
        for (int i = 1; i <= M; i++) {
            left[i] = dp[1][i] = map[1][i] + dp[1][i - 1];
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                left[j] = Math.max(dp[i - 1][j], left[j - 1]) + map[i][j]; // 위 or 왼쪽에서 오는 경우
            }

            if (i == N) {
                break; // 마지막은 오른쪽에서 못 옴
            }
            for (int j = M; j > 0; j--) { // 오른쪽에서 오는 경우
                right[j] = Math.max(dp[i - 1][j], right[j + 1]) + map[i][j];
                dp[i][j] = Math.max(left[j], right[j]);
            }
        }

        return left[M];
    }

}