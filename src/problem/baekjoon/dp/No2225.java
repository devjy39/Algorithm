package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    0개로 만들기 0 0 0 0
    1개로 만들기 1 1 1 1
    2개로 만들기 1 2 3 4
    3개로 만들기 1 3 6 10
    3개로 1만들기 0 0 1, 0 1 0, 1 0 0,
    3개로 2만들기 0 0 2, 0 2 0, 2 0 0,    1 1 0, 1 0 1, 0 1 1,
    3개로 3만들기 0 0 3, 0 3 0, 3 0 0,    2 1 0, 2 0 1, 1 2 0, 0 2 1, 1 0 2, 0 1 2,  1 1 1,
    이전 셋의 현재 인덱스까지 합으로 표현 됨.
*/

public class No2225 {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(getNumberOfCasesOfConsensus(n, k));
    }

    private static int getNumberOfCasesOfConsensus(int n, int k) {
        int[][] dp = new int[k + 1][n + 1]; // k번 써서 n을 만드는 경우의 수

        for (int i = 1; i <= k; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }

        return dp[k][n];
    }

}
