package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9252 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        String str = br.readLine();
        int m = str.length() - 1;
        int n = target.length() - 1;

        int[][] lcs = lcs(target, str);

        if (lcs[m][n] == 0) {
            System.out.print(0);
        } else {
            System.out.print(getReverseSearch(target, m, n, lcs));
        }
    }

    static StringBuilder getReverseSearch(String target, int m, int n, int[][] lcs) {
        StringBuilder result = new StringBuilder();
        int prev = n;
        int count = lcs[m][n];
        System.out.println(count);

        for (int i = m; i >= 0; i--) {
            for (int j = i; j > 0; j--) {
                if (lcs[j][prev] == lcs[j - 1][prev]) {
                    i--;
                } else {
                    break;
                }
            }

            for (; prev >= 0; prev--) {
                if (lcs[i][prev] < count) {
                    break;
                }
            }

            result.insert(0, target.charAt(prev + 1));
            if (--count <= 0) {
                break;
            }
        }

        return result;
    }

    static int[][] lcs(String target, String str) {
        int[][] dp = new int[str.length()][target.length()];

        int idx = target.indexOf(str.charAt(0));
        if (idx >= 0) {
            for (int i = idx; i < target.length(); i++) {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);

            dp[i][0] = target.charAt(0) == c ? 1 : dp[i - 1][0];
            for (int j = 1; j < target.length(); j++) {
                if (target.charAt(j) == c) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i][j - 1]);
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp;
    }
}