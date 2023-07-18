package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No1660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        list.add(0);
        while (list.get(list.size() - 1) <= n) {
            list.add(list.get(list.size() - 1) + (list.size() * (list.size() + 1) / 2));
        }

        dp = new int[n + 1];
        System.out.println(dfs(list, list.size() - 2, n));
    }

    static int[] dp;

    private static int dfs(List<Integer> list, int idx, int n) {
        if (dp[n] > 0) {
            return dp[n];
        }

        int count = Integer.MAX_VALUE;

        for (int i = idx; i > 0; i--) {
            int num = list.get(i);
            if (num <= n) {
                if (num == n) {
                    count = 1;
                    break;
                }
                count = Math.min(count, 1 + dfs(list, idx, n - num));
            } else {
                idx--;
            }
        }

        return dp[n] = count;
    }

}

