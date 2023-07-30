package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17845 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[n + 1];

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int importance = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            for (int i = n; i >= time; i--) {
                dp[i] = Math.max(dp[i], dp[i - time] + importance);
            }
        }

        System.out.println(dp[n]);
    }

}
