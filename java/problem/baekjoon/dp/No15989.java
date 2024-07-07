package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No15989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] arr = new int[t];
        int max = 0;
        for (int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        int[] dp = getSumCases(max);

        StringBuilder result = new StringBuilder();
        for (int i : arr) {
            result.append(dp[i]).append("\n");
        }
        System.out.print(result);
    }

    private static int[] getSumCases(int max) {
        int[] dp = new int[max + 1]; // 1,2,3 으로 만드는 경우의 수
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        int[] two = new int[max + 1]; // 2,3으로 만드는 경우의 수
        two[2] = two[3] = 1;

        for (int i = 4; i < dp.length; i++) {
            two[i] = two[i - 2] + (i % 3 == 0 ? 1 : 0);
            dp[i] = dp[i - 1] + two[i];
        }

        return dp;
    }

}

