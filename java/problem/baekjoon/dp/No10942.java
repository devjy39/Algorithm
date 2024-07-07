package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No10942 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = makePalindrome(arr, n);

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            result.append(dp[b - a][b - 1] ? '1' : '0').append("\n");
        }

        System.out.print(result);
    }

    private static boolean[][] makePalindrome(int[] arr, int n) {
        boolean[][] dp = new boolean[arr.length][arr.length];

        Arrays.fill(dp[0], true);
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                dp[1][i] = true;
            }
        }

        for (int i = 2; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (arr[j] == arr[j - i] && dp[i - 2][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }

        return dp;
    }

}