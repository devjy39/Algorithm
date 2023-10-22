package problem.baekjoon.shotestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10159 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] graph = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = -1;
        }

        floyd(n, graph);

        System.out.println(getResult(n, graph));
    }

    private static String getResult(int n, int[][] graph) {
        StringBuilder result = new StringBuilder();
        for (int start = 1; start <= n; start++) {
            int count = 0;
            for (int end = 1; end <= n; end++) {
                if (graph[start][end] != 0) {
                    count++;
                }
            }
            result.append(n - count - 1).append('\n');
        }
        return result.toString();
    }

    private static void floyd(int n, int[][] graph) {
        for (int via = 1; via <= n; via++) {

            for (int i = 1; i <= n; i++) {
                if (via == i) {
                    continue;
                }
                for (int j = 1; j <= n; j++) {
                    if (graph[i][via] == 1 && graph[via][j] == 1) {
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }
                }
            }
        }
    }

}

