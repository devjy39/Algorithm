package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2193 {
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new long[N + 1][2];
        System.out.println(countPinaryNumber(N, 1, 1));
    }

    private static long countPinaryNumber(int n, int idx, int prev) {
        if (dp[idx][prev] > 0) {
            return dp[idx][prev];
        } else if (idx == n) {
            return 1;
        }

        return dp[idx][prev] = (prev == 0 ? countPinaryNumber(n, idx + 1, 1) : 0)
                + countPinaryNumber(n, idx + 1, 0);
    }

}

