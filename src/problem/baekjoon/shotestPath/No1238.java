package problem.baekjoon.shotestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1238 {

    static int[][] dist;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        dist = new int[v + 1][v + 1];
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (i != j) {
                    dist[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            dist[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        br.close();

        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= v; i++) {
            result = Math.max(result, dist[i][target] + dist[target][i]);
        }

        System.out.println(result);
    }

}