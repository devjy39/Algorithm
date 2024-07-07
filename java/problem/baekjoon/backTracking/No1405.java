package problem.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1405 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        double[] prob = new double[4];
        for (int i = 0; i < 4; i++) {
            prob[i] = Integer.parseInt(st.nextToken()) / 100.0;
        }

        System.out.println(dfs(N, prob, new boolean[30][30], 15, 15));
    }

    static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static double dfs(int n, double[] probability, boolean[][] visited, int i, int j) {
        if (n == 0) {
            return 1;
        }
        visited[i][j] = true;
        double sum = 0;

        for (int dir = 0; dir < dirs.length; dir++) {
            if (probability[dir] > 0) {
                int x = dirs[dir][0] + i;
                int y = dirs[dir][1] + j;

                if (!visited[x][y]) {
                    sum += probability[dir] * dfs(n - 1, probability, visited, x, y);
                }
            }
        }

        visited[i][j] = false;
        return sum;
    }

}

