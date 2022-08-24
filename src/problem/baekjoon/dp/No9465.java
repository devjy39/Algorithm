package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No9465 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[2][n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[0][j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[1][j] = Integer.parseInt(st.nextToken());
            }

            result.append(dp(map, n)).append("\n");
        }
        br.close();

        System.out.println(result);
    }

    private static int dp(int[][] map, int n) {
        int prevUp = map[0][0];
        int prevDown = map[1][0];

        for (int i = 1; i < n; i++) {
            int curUp = Math.max(prevUp, prevDown + map[0][i]);
            int curDown = Math.max(prevDown, prevUp + map[1][i]);
            prevUp = curUp;
            prevDown = curDown;
        }

        return Math.max(prevDown, prevUp);
    }

}