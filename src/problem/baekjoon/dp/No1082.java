package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1082 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        maxPrice = new int[n];
        maxPrice[0] = 1;
        dp = new int[n][m + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }

        dfs(new int[n], n - 1, 0, m);

        StringBuilder result = new StringBuilder();
        for (int i = maxPrice.length - 1; i >= 0; i--) {
            result.append(String.valueOf(i).repeat(maxPrice[i]));
        }
        System.out.println(result);
    }

    static int[][] dp;
    static int[] prices, maxPrice;
    static int maxSize;

    private static void dfs(int[] count, int depth, int size, int balance) {
        if (depth <= 0) {
            if (size == 0 || size + balance / prices[0] <= maxSize) {
                return;
            }
            count[0] = balance / prices[0];
            maxSize = size + count[0];
            System.arraycopy(count, 0, maxPrice, 0, count.length);
            return;
        } else if (size <= dp[depth][balance]) {
            return;
        }

        for (int i = balance / prices[depth]; i >= 0; i--) {
            count[depth] = i;
            dfs(count, depth - 1, size + i, balance - prices[depth] * i);
        }

        dp[depth][balance] = size;
    }
}

