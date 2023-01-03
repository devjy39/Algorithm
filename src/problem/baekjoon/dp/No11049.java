package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11049 {

    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n][n];
        System.out.print(getMinMultiple(arr, 0, n - 1));
    }

    private static int getMinMultiple(int[][] arr, int left, int right) {
        if (left == right) {
            return 0;
        } else if (dp[left][right] > 0) {
            return dp[left][right];
        }

        int minMultipleCount = Integer.MAX_VALUE;

        for (int i = left; i < right; i++) {
            minMultipleCount = Math.min(minMultipleCount,
                arr[left][0] * arr[right][1] * arr[i][1]  // 둘을 곱하는 비용
                    + getMinMultiple(arr, left, i) + getMinMultiple(arr, i + 1, right)); // 재료 둘을 만드는 비용
        }

        return dp[left][right] = minMultipleCount;
    }

}