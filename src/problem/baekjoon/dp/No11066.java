package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11066 {
    static int[][] dp;
    static int[] accSum;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            dp = new int[n][n];
            accSum = new int[n + 1];
            for (int j = 0; j < n; j++) {
                accSum[j + 1] = accSum[j] + Integer.parseInt(st.nextToken());
            }

            result.append(getMinSum(0, n - 1)).append("\n");
        }

        System.out.print(result);
    }

    /*  **메모이제이션 적용
    * */
    private static int getMinSum(int left, int right) {
        if (dp[left][right] != 0) {
            return dp[left][right];
        } else if (left == right) {
            return 0;
        }

        int minSum = Integer.MAX_VALUE;
        for (int i = left + 1; i <= right; i++) {
            minSum = Math.min(minSum, getMinSum(left, i - 1) + getMinSum(i, right));
        }

        return dp[left][right] = minSum + accSum[right + 1] - accSum[left];
    }

}
/*
*   점화식 세우기 : 최종결과인 전부의 합의 경우의 수를 생각해보기
* */