package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] consults = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            consults[i][0] = Integer.parseInt(st.nextToken());
            consults[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getMaxProfit(N, consults));
    }

    private static int getMaxProfit(int N, int[][] consults) {
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int endDay = consults[i][0] + i - 1;
            dp[i] = Math.max(dp[i], dp[i - 1]);
            if (endDay <= N) {
                dp[endDay] = Math.max(dp[endDay], dp[i - 1] + consults[i][1]);
            }
        }

        return dp[N];
    }

}

