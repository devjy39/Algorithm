package problem.baekjoon.shotestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11403 {
    static boolean[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        graph = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (st.nextToken().equals("1")) {
                    graph[i][j] = true;
                }
            }
        }
        br.close();

        floyd(n);

        for (boolean[] edges : graph) {
            for (boolean edge : edges) {
                sb.append(edge ? 1 : 0).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void floyd(int n) {
        for (int via = 0; via < n; via++) {

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!graph[i][j] && graph[i][via] && graph[via][j]) {
                        graph[i][j] = true;
                    }
                }
            }
            
        }
    }
}