package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11062 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] cards = new int[n];
            for (int i = 0; i < n; i++) {
                cards[i] = Integer.parseInt(st.nextToken());
            }

            result.append(getMaxScore(cards, n)).append("\n");
        }

        System.out.print(result);
    }

    static int[][] dp;
    private static int getMaxScore(int[] cards, int n) {
        dp = new int[n][n];
        return dfs(cards, 0, n - 1);
    }

    private static int dfs(int[] cards, int left, int right) {
        if (left >= right) {
            return left == right ? cards[left] : 0;
        } else if (dp[left][right] > 0) {
            return dp[left][right];
        }

        int leftScore = cards[left];
        leftScore += Math.min(dfs(cards, left + 1, right - 1), dfs(cards, left + 2, right));

        int rightScore = cards[right];
        rightScore += Math.min(dfs(cards, left + 1, right - 1), dfs(cards, left, right - 2));

        return dp[left][right] = Math.max(leftScore, rightScore);
    }

}

