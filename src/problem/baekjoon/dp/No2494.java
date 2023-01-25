package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2494 {

    static int[] locks, targets;
    static int n;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        String now = br.readLine();
        String target = br.readLine();

        locks = new int[n];
        targets = new int[n];
        for (int i = 0; i < n; i++) {
            locks[i] = now.charAt(i) - '0';
            targets[i] = target.charAt(i) - '0';
        }

        dp = new int[n + 1][10];

        System.out.print(getResult());
    }

    // getMoveCount 함수에서 실행했던 것을 dp결과값으로 재연
    private static String getResult() {
        StringBuilder result = new StringBuilder();
        result.append(getMoveCount(0, 0)).append("\n");

        int increase = 0;
        for (int i = 0; i < n; i++) {
            int cur = (locks[i] + increase) % 10;
            int move = Math.abs(cur - targets[i]);
            int plus = cur < targets[i] ? move : 10 - move;
            int minus = 10 - plus;

            if (dp[i + 1][(increase + plus) % 10] + plus < dp[i + 1][increase] + minus) {
                result.append(i + 1).append(" ").append(plus).append("\n");
                increase = (increase + plus) % 10;
            } else {
                result.append(i + 1).append(" ").append(-minus).append("\n");
            }
        }
        return result.toString();
    }

    private static int getMoveCount(int depth, int increase) {
        if (depth == n) {
            return 0;
        }
        if (dp[depth][increase] > 0) {
            return dp[depth][increase];
        }

        int cur = (locks[depth] + increase) % 10;
        int move = Math.abs(cur - targets[depth]);
        int plus = cur < targets[depth] ? move : 10 - move; // 증가하는 방향 칸 수
        int minus = 10 - plus; // 감소하는 방향 칸 수

        return dp[depth][increase] = Math.min(getMoveCount(depth + 1, (increase + plus) % 10) + plus,
                getMoveCount(depth + 1, increase) + minus); // 증가시키거나 or 감소시키거나 최솟값
    }

}