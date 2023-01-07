package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No7579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int idx = 0;
        int[] memories = new int[n];
        int[] prices = new int[n];
        int maxPrice = 0;

        StringTokenizer m = new StringTokenizer(br.readLine());
        StringTokenizer p = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
            int memory = Integer.parseInt(m.nextToken());
            int price = Integer.parseInt(p.nextToken());

            if (price == 0) {
                target -= memory;
            } else {
                memories[idx] = memory;
                prices[idx++] = price;
                maxPrice += price;
            }
        }

        System.out.print(getMinPrice(target, getDpResult(memories, prices, idx, maxPrice)));
    }

    private static int getMinPrice(int target, int[] dp) {
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] >= target) {
                return i;
            }
        }
        return -1;
    }

    private static int[] getDpResult(int[] memories, int[] prices, int length, int maxPrice) {
        int[] prev = new int[maxPrice + 1];
        int[] cur = new int[maxPrice + 1];
        int[] temp;

        for (int i = 0; i < length; i++) {
            System.arraycopy(prev, 1, cur, 1, prices[i] - 1);

            cur[prices[i]] = Math.max(prev[prices[i]], memories[i]);
            for (int j = prices[i] + 1; j < cur.length; j++) {
                if (prev[j - prices[i]] > 0) {
                    cur[j] = Math.max(prev[j], prev[j - prices[i]] + memories[i]);
                } else {
                    cur[j] = prev[j];
                }
            }
            temp = prev;
            prev = cur;
            cur = temp;
        }

        return prev;
    }

}