package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2096 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] prev = new int[2][3];
        int[][] cur = new int[2][3];
        int[][] temp;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cur[0][0] = Math.max(prev[0][0], prev[0][1]);
            cur[1][0] = Math.min(prev[1][0], prev[1][1]);

            cur[0][2] = Math.max(prev[0][1], prev[0][2]);
            cur[1][2] = Math.min(prev[1][1], prev[1][2]);

            cur[0][1] = Math.max(cur[0][0], cur[0][2]);
            cur[1][1] = Math.min(cur[1][0], cur[1][2]);

            for (int j = 0; j < 3; j++) {
                int num = Integer.parseInt(st.nextToken());
                cur[0][j] += num;
                cur[1][j] += num;
            }

            temp = prev;
            prev = cur;
            cur = temp;
        }
        br.close();

        System.out.println(arrMax(prev[0]) + " " + arrMin(prev[1]));
    }

    private static int arrMax(int[] arr) {
        int max = 0;
        for (int j : arr) {
            max = Math.max(max, j);
        }
        return max;
    }

    private static int arrMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int j : arr) {
            min = Math.min(min, j);
        }
        return min;
    }
}