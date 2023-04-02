package problem.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] score = new int[n + 1];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                score[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }

            result.append(getPassCount(n, score)).append("\n");
        }

        System.out.print(result);
    }

    private static int getPassCount(int n, int[] score) {
        int minScore = n + 1;
        int passCount = 0;

        for (int i = 1; i <= n; i++) {
            if (score[i] < minScore) {
                passCount++;
            }
            minScore = Math.min(minScore, score[i]);
        }

        return passCount;
    }

}

