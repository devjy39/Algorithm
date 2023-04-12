package problem.baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10971 {
    static int fullBit;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n; i++) {
            fullBit += 1 << i;
        }
        dp = new int[fullBit][n];

        System.out.println(dfs(map, 0, 0));
    }

    static final int MAX = 10_000_000;
    private static int dfs(int[][] map, int bit, int node) {
        if (bit == fullBit) {
            return map[node][0] == 0 ? MAX : map[node][0];
        } else if (dp[bit][node] > 0) {
            return dp[bit][node];
        }

        int nextCost = MAX;

        for (int i = 1; i < map.length; i++) {
            if (((1 << i) & bit) == 0 && map[node][i] > 0) { // 겹치는 비트 없고, 길 있으면
                nextCost = Math.min(nextCost, dfs(map, bit | 1 << i, i) + map[node][i]);
            }
        }

        return dp[bit][node] = nextCost;
    }

}

