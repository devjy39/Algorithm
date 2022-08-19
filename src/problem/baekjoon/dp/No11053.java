package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11053 {
    static int MAX_LEN = 1001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dp = new int[MAX_LEN]; // index로 끝나는 수에서 최대 개수 저장

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            int max = 0;
            for (int j = 1; j < num; j++) {
                if(dp[j]>0)
                    max = Math.max(max, dp[j]);
            }
            dp[num] = max + 1;
        }
        br.close();

        int answer = 0;
        for (int i = 1; i < MAX_LEN; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}