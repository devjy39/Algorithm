package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No12865 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            int[] next = dp.clone();
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            for (int j = w; j <= k; j++) {
                next[j] = Math.max(dp[j], dp[j - w] + v);
            }
            dp = next;
        }
        br.close();

        System.out.println(dp[k]);
    }

}