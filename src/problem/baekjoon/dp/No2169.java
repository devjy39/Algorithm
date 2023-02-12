package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2169 {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/data.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][M];
        dp[0][0] = map[0][0];
        for (int i = 1; i < M; i++) {
            dp[0][i] = dp[0][i - 1] + map[0][i];
        }

        for (int i = 1; i < N - 1; i++) {
            for (int j = 0; j < M; j++) {
                dp[i][j] = dp[i - 1][j]; // 위에서 내려옴

                int sum = 0;
                for (int k = j - 1; k >= 0; k--) { //왼쪽에서 옴
                    sum += map[i][k];
                    dp[i][j] = Math.max(dp[i][j], sum + dp[i - 1][k]);
                }

                sum = 0;
                for (int k = j + 1; k < M; k++) { // 오른쪽에서 옴
                    sum += map[i][k];
                    dp[i][j] = Math.max(dp[i][j], sum + dp[i - 1][k]);
                }

                dp[i][j] += map[i][j]; //대소비교 후 마지막에 더하기
            }
        }

        // 맨 밑 줄
        if (N == 1) {
            System.out.println(dp[N - 1][M - 1]);
            return;
        }

        dp[N - 1][0] = dp[N - 2][0] + map[N - 1][0];

        for (int i = 1; i < M; i++) {
            dp[N - 1][i] += Math.max(dp[N - 1][i - 1], dp[N - 2][i]) + map[N - 1][i];
        }
        System.out.println(dp[N - 1][M - 1]);
    }

}