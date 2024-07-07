package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1086 {
    static class Element {
        String str;
        int length;
        int modK;

        public Element(String str) {
            this.str = str;
            this.length = str.length();
        }
    }

    static int K, N;
    static int[] bits, tens;
    static long[][] dp;
    static Element[] elements;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        elements = new Element[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            elements[i] = new Element(br.readLine());
            max = Math.max(max, elements[i].length);
        }
        K = Integer.parseInt(br.readLine());
        caching(max);

        System.out.println(abbreviation(dfs(0, 0, 0), factorial(N)));
    }

    private static String abbreviation(long numerator, long denominator) {
        long g;
        while ((g = gcd(numerator, denominator)) > 1) {
            numerator /= g;
            denominator /= g;
        }

        return String.format("%d/%d", numerator, denominator);
    }

    private static void caching(int max) {
        bits = new int[N];
        dp = new long[1 << N][K];

        bits[0] = 1;
        for (int i = 1; i < N; i++) {
            bits[i] = bits[i - 1] * 2;
        }

        tens = new int[max + 1];
        tens[0] = 1;
        for (int i = 1; i < tens.length; i++) {
            tens[i] = (tens[i - 1] * (10 % K)) % K;
        }

        for (int i = 0; i < N; i++) {
            elements[i].modK = mod(elements[i].str, K);
        }
    }

    private static long gcd(long v1, long v2) {
        if (v1 % v2 == 0) {
            return v2;
        }

        return gcd(v2, v1 % v2);
    }

    private static long factorial(int n) {
        long num = 1;
        for (int i = 2; i <= n; i++) {
            num *= i;
        }

        return num;
    }

    private static long dfs(int depth, int bit, int prev) {
        if (depth == N) {
            return prev == 0 ? 1 : 0;
        } else if (dp[bit][prev] != 0) {
            return dp[bit][prev] == -1 ? 0 : dp[bit][prev];
        }

        long sum = 0;
        for (int i = 0; i < N; i++) {
            if ((bit & bits[i]) == 0) {
                int m = (prev * tens[elements[i].length] + elements[i].modK) % K;
                sum += dfs(depth + 1, bit | bits[i], m);
            }
        }

        if (sum == 0) {
            dp[bit][prev] = -1;
        } else {
            dp[bit][prev] = sum;
        }
        return sum;
    }

    private static int mod(String s, int k) {
        int m = 0;

        for (int i = 0; i < s.length(); i++) {
            m *= 10 % k;
            m += s.charAt(i) - '0';
            m %= k;
        }

        return m;
    }
}