package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(getMinSquareCount(n));
    }

    private static int getMinSquareCount(int n) {
        int[] square = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            square[i] = 1 + square[i - 1];
            for (int j = 1; j * j <= i; j++) {
                square[i] = Math.min(square[i], 1 + square[i - j * j]);
            }
        }

        return square[n];
    }

}
