package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No13902 {
    static final int MAX = 100_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(dp(n, generateSumList(n, m, arr)));
    }

    private static int[] generateSumList(int n, int m, int[] arr) {
        boolean[] check = new boolean[n + 1];
        int count = 0;
        for (int i = 0; i < m; i++) {
            check[arr[i]] = true;
            count++;
            for (int j = i + 1; j < m; j++) {
                int sum = arr[i] + arr[j];
                if (sum <= n && !check[sum]) {
                    count++;
                    check[sum] = true;
                }
            }
        }

        int[] sortedArr = new int[count];
        int idx = 0;

        for (int i = 1; i <= n; i++) {
            if (check[i]) {
                sortedArr[idx++] = i;
            }
        }

        return sortedArr;
    }

    private static int dp(int n, int[] arr) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;

        for (int number : arr) {
            for (int i = number; i <= n; i++) {
                dp[i] = Math.min(dp[i], dp[i - number] + 1);
            }
        }

        return dp[n] == MAX ? -1 : dp[n];
    }

}