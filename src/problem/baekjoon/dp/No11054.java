package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11054 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][2];
        int result = 0;

        for (int i = 1; i <= n; i++) {
            int up = 0;
            int down = 0;

            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) {
                    up = Math.max(up, dp[j][0]);
                } else if (arr[i] < arr[j]) {
                    down = Math.max(down, Math.max(dp[j][0], dp[j][1]));
                }
            }

            dp[i][0] = up + 1;
            dp[i][1] = down + 1;

            result = Math.max(result, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.println(result);
    }

}