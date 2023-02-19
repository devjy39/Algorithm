package problem.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1926 {

    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int area = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    area = Math.max(area, getArea(map, i, j));
                    count++;
                }
            }
        }

        System.out.printf("%d\n%d", count, area);
    }

    private static int getArea(int[][] map, int i, int j) {
        int sum = 0;
        map[i][j] = -1;

        for (int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;

            if (x < 0 || y < 0 || x >= N || y >= M || map[x][y] <= 0) {
                continue;
            }
            sum += getArea(map, x, y);
        }

        return sum + 1;
    }

}