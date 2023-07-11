package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No5582 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        System.out.println(getCommonSeqMaxLength(str1, str2));
    }

    private static int getCommonSeqMaxLength(String str1, String str2) {
        int[] dp = new int[str2.length()];
        int maxLength = 0;
        int temp;

        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);

            int prev = 0;
            for (int j = 0; j < str2.length(); j++) {
                char c2 = str2.charAt(j);

                temp = dp[j];
                dp[j] = c1 == c2 ? prev + 1 : 0;
                maxLength = Math.max(maxLength, dp[j]);
                prev = temp;
            }
        }

        return maxLength;
    }

}

