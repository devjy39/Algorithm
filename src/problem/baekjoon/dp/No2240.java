package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2240 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] arr = new int[t + 1];
        for (int i = 1; i <= t; i++) {
            arr[i] = Integer.parseInt(br.readLine()) - 1; // 0 or 1
        }

        System.out.println(getMaxScore(t, w, arr));
    }

    private static int getMaxScore(int t, int w, int[] arr) {
        int[][] dp = new int[t + 1][2];
        int[][] prev = new int[t + 1][2];
        for (int i = 1; i <= t; i++) {
            prev[i][0] = prev[i - 1][0] + (arr[i] == 0 ? 1 : 0);
        }

        while (w-- > 0) {
            for (int i = 1; i <= t; i++) {
                dp[i][arr[i]] = Math.max(dp[i - 1][arr[i]], prev[i - 1][arr[i] ^ 1]) + 1;
                dp[i][arr[i] ^ 1] = dp[i - 1][arr[i] ^ 1];
            }

            int[][] temp = dp;
            dp = prev;
            prev = temp;
        }

        return Math.max(prev[t][0], prev[t][1]);
    }

}

