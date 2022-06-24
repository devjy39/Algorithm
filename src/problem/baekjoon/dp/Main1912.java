package problem.baekjoon.dp;

import java.io.*;
import java.util.StringTokenizer;

public class Main1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        int answer = Integer.MIN_VALUE;
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            dp[i + 1] = Math.max(dp[i] + num, num);
            answer = Math.max(answer, dp[i + 1]);
        }

        System.out.println(answer);
    }
}