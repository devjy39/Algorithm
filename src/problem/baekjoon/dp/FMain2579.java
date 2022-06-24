package problem.baekjoon.dp;

import java.io.*;

public class FMain2579 {
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n];
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = arr[0];
        br.close();

        System.out.println(dfs(n - 1));
    }

    static int dfs(int n) {
        if (n < 0) {
            return 0;
        } else if (dp[n] != 0) {
            return dp[n];
        }

        // 1칸 이전 dfs를 이전의 카운트가 몇인지 알수 없어서 풀 수 없는데
        // 이걸 3칸전 + 1칸전'값' 으로 바꿔 푸는 아이디어;;;;
        // 사실 1칸전은 이전에 무조건 점프 했어야 하니까 이게 맞다.
        return dp[n] = arr[n] + Math.max(dfs(n - 3) + arr[n - 1], dfs(n - 2));
    }

}