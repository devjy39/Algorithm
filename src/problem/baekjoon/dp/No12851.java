package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No12851 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        br.close();

        if (k <= n) {
            System.out.printf("%d\n%d", n - k, 1);
        } else {
            findTarget(n, k);
        }
    }

    private static void findTarget(int n, int target) {
        int[] dp = new int[target + 2];
        int[] count = new int[dp.length];

        for (int i = 0; i <= n; i++) {
            dp[i] = n - i;
            count[i] = 1;
        }

        for (int i = n + 1; i < dp.length; i++) {
            int half = i >> 1;

            dp[i] = Math.min(dp[i - 1], i % 2 == 0 ? dp[half] :
                    Math.min(dp[half], dp[half + 1]) + 1) + 1;
        }

        for (int i = n + 1; i <= target; i++) {
            int half = i >> 1;

            count[i] += dp[i] == dp[i - 1] + 1 ? count[i-1] : 0;
            if (i % 2 == 0) {
                count[i] += dp[i] == dp[half] + 1 ? count[half] : 0;
            } else if (dp[i] == dp[i + 1] + 1) {
                count[i] += count[(i + 1) >> 1];
            }
        }

        System.out.printf("%d\n%d", dp[target], count[target]);
    }

}