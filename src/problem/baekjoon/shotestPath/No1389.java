package problem.baekjoon.shotestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1389 {
    static int[][] dist;
    static final int INF = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    dist[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            dist[x][y] = 1;
            dist[y][x] = 1;
        }
        br.close();

        floyd(n);
        System.out.println(getMinNode(n));
    }

    private static void floyd(int v) {
        for (int via = 1; via <= v; via++) {

            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    if (dist[i][j] > dist[i][via] + dist[via][j]) {
                        dist[i][j] = dist[i][via] + dist[via][j];
                    }
                }
            }
        }
    }

    private static int getMinNode(int v) {
        int answer = Integer.MAX_VALUE;
        int minNode = 0;

        for (int i = 1; i <= v; i++) {
            int sum = 0;
            for (int j = 1; j <= v; j++) {
                sum += dist[i][j];
            }

            if (sum < answer) {
                minNode = i;
                answer = sum;
            }
        }

        return minNode;
    }

}