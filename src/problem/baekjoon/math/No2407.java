package problem.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class No2407 {
    static BigInteger[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        br.close();
        dp = new BigInteger[n + 1][m + 1];

        System.out.println(combination(n, m));
    }

    private static BigInteger combination(int n, int r) {
        if (dp[n][r] != null) {
            return dp[n][r];
        }
        if (n == r || r == 0) {
            return BigInteger.ONE;
        }

        return dp[n][r] = combination(n - 1, r - 1).add(combination(n - 1, r));
    }


}