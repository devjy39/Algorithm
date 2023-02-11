package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2228 {
    static int[] arr;
    static int[][][] dp;
    static final int M_INF = -10_000_000;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/data.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[N][N][M + 1];
        for (int i = 0; i < N; i++) {
            int max = M_INF;
            int sum = 0;
            for (int j = i; j < N; j++) {
                max = Math.max(max, sum += arr[j]);
                sum = Math.max(0, sum);
                dp[i][j][1] = max;
            }
        }

        for (int m = 2; m <= M; m++) {
            for (int i = 0; i < N; i++) {
                for (int j = i + (m - 1) * 2; j < N; j++) {
                    dp[i][j][m] = M_INF;
                    for (int k = j - 2 * (m - 1); k >= i; k--) {
                        dp[i][j][m] = Math.max(dp[i][j][m], dp[i][k][1] + dp[k + 2][j][m - 1]);
                    }
                }
            }
        }

        System.out.println(dp[0][N - 1][M]);
    }

}