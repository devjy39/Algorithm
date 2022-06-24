package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = null;

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] newSum = new int[i];

            for (int j = 0; j < i; j++) {
                int num = Integer.parseInt(st.nextToken());
                newSum[j] = num;
                if (dp != null) {
                    int leftUp = j == 0 ? 0 : dp[j - 1];
                    int rightUp = j == i - 1 ? 0 : dp[j];
                    newSum[j] += Math.max(leftUp, rightUp);
                }
            }

            dp = newSum;
        }

        br.close();
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}