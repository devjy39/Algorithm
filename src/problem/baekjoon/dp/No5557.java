package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No5557 {
    static int target, n;
    static int[] arr;
    static long[][] dp;
    static final int MAX_NUMBER = 20;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()) - 1;
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        target = Integer.parseInt(st.nextToken());
        dp = new long[n][MAX_NUMBER + 1];

        System.out.println(Math.max(0, getNumberOfEquations(arr, 1, arr[0])));
    }

    private static long getNumberOfEquations(int[] arr, int depth, int sum) {
        if (depth >= n) {
            return sum == target ? 1 : 0;
        } else if (dp[depth][sum] != 0) {
            return Math.max(0, dp[depth][sum]);
        }

        long count = 0;
        if (sum + arr[depth] <= MAX_NUMBER) {
            count = getNumberOfEquations(arr, depth + 1, sum + arr[depth]);
        }
        if (sum - arr[depth] >= 0) {
            count += getNumberOfEquations(arr, depth + 1, sum - arr[depth]);
        }

        return Math.max(0, dp[depth][sum] = count == 0 ? -1 : count);
    }

}
