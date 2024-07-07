package problem.baekjoon.dp;

import java.io.*;
import java.util.Arrays;

public class No1509 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        System.out.println(getPalindromeCount(arr, arr.length));
    }

    private static int getPalindromeCount(char[] arr, int N) {
        int[] dp = new int[N]; // 인덱까지 팰린 최소 개수
        Arrays.fill(dp, N);
        dp[0] = 1;
        dp[1] = arr[0] == arr[1] ? 1 : 2;

        for (int i = 2; i < N; i++) {
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            if (arr[i] == arr[i - 1]) {
                checkPalindrome(arr, dp, i, i - 1);
            }

            if (arr[i] == arr[i - 2]) {
                checkPalindrome(arr, dp, i - 1, i - 1);
            }
        }

        return dp[N - 1];
    }

    private static void checkPalindrome(char[] arr, int[] dp, int left, int right) {
        while (--left >= 0 && ++right < arr.length) {
            if (arr[left] == arr[right]) {
                dp[right] = Math.min(dp[right], (left == 0 ? 0 : dp[left - 1]) + 1);
            } else {
                return;
            }
        }
    }

}