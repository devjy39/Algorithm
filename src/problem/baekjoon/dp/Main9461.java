package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main9461 {
    static long[] m = new long[101];

    static long dp(int n) {
        if (m[n] != 0)
            return m[n];
        return m[n] = dp(n - 2) + dp(n - 3);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m[1] = m[2] = m[3] = 1;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp(n));
        }
        br.close();
    }
}