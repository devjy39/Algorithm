package problem.baekjoon.divide_conquer;

import java.io.*;
import java.util.*;

public class No11401 {
    static final long MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long nominator = factorial(n);
        long denominator = (factorial(k) * factorial(n - k)) % MOD;

        if (k == 0) {
            System.out.println(1);
        } else {
            System.out.println((nominator * pow(denominator, MOD - 2)) % MOD);
        }
    }

    private static long pow(long number, long exp) {
        if (exp == 1) {
            return number;
        }

        long halfResult = pow(number, exp >> 1);
        long result = (halfResult * halfResult) % MOD;

        if (exp % 2 == 1) {
            return (result * number) % MOD;
        }

        return result;
    }

    private static long factorial(int n) {
        long result = 1L;

        while (n > 1) {
            result = (result * n--) % MOD;
        }

        return result;
    }

}
