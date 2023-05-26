package problem.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2458 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] graph = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from][to] = true;
        }

        System.out.println(getConfirmedRank(graph, n));
    }

    private static int getConfirmedRank(boolean[][] graph, int n) {
        int count = 0;

        for (int via = 1; via <= n; via++) {
            for (int i = 1; i <= n; i++) {
                if (via == i) {
                    continue;
                }
                for (int j = 1; j <= n; j++) {
                    if (graph[i][via] && graph[via][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }

        loop:
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (!graph[i][j] && !graph[j][i]) {
                    continue loop;
                }
            }
            for (int j = i + 1; j <= n; j++) {
                if (!graph[i][j] && !graph[j][i]) {
                    continue loop;
                }
            }
            count++;
        }

        return count;
    }

}
