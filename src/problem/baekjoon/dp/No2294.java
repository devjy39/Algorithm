package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class No2294 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        TreeSet<Integer> coins = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            int coin = Integer.parseInt(br.readLine());
            if (coin <= k) {
                coins.add(coin);
            }
        }

        System.out.println(getMinCoin(k, coins));
    }

    private static int getMinCoin(int k, TreeSet<Integer> coins) {
        int[] prev = new int[k + 1];
        int[] cur = new int[k + 1];
        Arrays.fill(prev, 100_000);
        prev[0] = 0;

        for (int coin : coins) {
            System.arraycopy(prev, 1, cur, 1, coin - 1);

            for (int j = coin; j <= k; j++) {
                cur[j] = Math.min(prev[j], cur[j - coin] + 1);
            }

            int[] temp = prev;
            prev = cur;
            cur = temp;
        }

        return prev[k] > k ? -1 : prev[k];
    }

}
