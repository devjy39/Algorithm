package problem.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No14556 {
    static int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(count(n));
    }

    private static long count(int n) {
        long prev = 1;

        for (int i = 2; i <= n; i++) {
            prev = ((2L * i - 1) * prev) % MOD;
        }

        return prev;
    }

}

