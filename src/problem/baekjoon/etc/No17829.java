package problem.baekjoon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No17829 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(pooling(map, 0, 0, n - 1, n - 1));
    }

    private static int pooling(int[][] map, int x1, int y1, int x2, int y2) {
        if (x1 == x2) {
            return map[x1][y1];
        }

        int half = (x2 - x1 + 1) >> 1;
        int[] temp = new int[4];
        temp[0] = pooling(map, x1, y1, x1 + half - 1, y1 + half - 1);
        temp[1] = pooling(map, x1, y1 + half, x1 + half - 1, y2);
        temp[2] = pooling(map, x1 + half, y1, x2, y1 + half - 1);
        temp[3] = pooling(map, x1 + half, y1 + half, x2, y2);

        Arrays.sort(temp);
        return temp[2];
    }

}

