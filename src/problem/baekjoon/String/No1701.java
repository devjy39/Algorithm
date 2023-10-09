package problem.baekjoon.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No1701 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] pattern = br.readLine().toCharArray();
        int maxLength = 0;

        int[] pi = new int[pattern.length];
        for (int i = 0; i < pattern.length; i++) {
            maxLength = Math.max(maxLength, getMaxLength(pi, pattern, i));
        }

        System.out.println(maxLength);
    }

    private static int getMaxLength(int[] pi, char[] pattern, int start) {
        int maxLength = 0;
        pi[start] = start;

        for (int i = start + 1, j = start; i < pi.length; i++) {
            while (j > start && pattern[i] != pattern[j]) {
                j = pi[j - 1];
            }

            if (pattern[i] == pattern[j]) {
                pi[i] = ++j;
                maxLength = Math.max(maxLength, pi[i] - start);
            } else {
                pi[i] = start;
            }
        }

        return maxLength;
    }

}

