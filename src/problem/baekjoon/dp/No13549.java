package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        if (n >= target) {
            System.out.println(n - target);
        } else {
            System.out.println(dp(n, target));
        }
    }

    private static int dp(int n, int target) {
        int[] dp = new int[target + 1];

        for (int i = 0; i <= n; i++) {
            dp[i] = n - i;
        }

        for (int i = n + 1; i <= target; i++) {
            dp[i] = Math.min(dp[i - 1] + 1, i % 2 == 0 ? dp[i >> 1] :
                    Math.min(dp[i >> 1], dp[(i >> 1) + 1]) + 1);
        }

        return dp[target];
    }

}