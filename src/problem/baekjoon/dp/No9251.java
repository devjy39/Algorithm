package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9251 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(longestCommonSubsequence(br.readLine(), br.readLine()));
        br.close();
    }

    private static int longestCommonSubsequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[] temp;
        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i) == str2.charAt(j - 1)) {
                    cur[j] = prev[j - 1] + 1;
                } else {
                    cur[j] = Math.max(prev[j], cur[j - 1]);
                }
            }

            temp = cur;
            cur = prev;
            prev = temp;
        }

        return prev[m];
    }
}