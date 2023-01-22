package problem.baekjoon.shotestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11780 {
    static class Node {
        int w;
        int via;
        int count;

        public Node(int w) {
            this.w = w;
            this.count = 2;
        }

    }

    static int MAX = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        Node[][] graph = new Node[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j && graph[i][j] == null) {
                    graph[i][j] = new Node(MAX);
                }
            }
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[s][e].w = Math.min(graph[s][e].w, w);
        }

        floyd(n, graph);

        System.out.print(getResult(n, graph));
    }

    private static void floyd(int n, Node[][] graph) {
        for (int via = 1; via <= n; via++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j || i == via || via == j) {
                        continue;
                    }

                    if (graph[i][via].w + graph[via][j].w < graph[i][j].w) {
                        graph[i][j].w = graph[i][via].w + graph[via][j].w;
                        graph[i][j].count = graph[i][via].count + graph[via][j].count - 1;
                        graph[i][j].via = via;
                    }
                }
            }
        }
    }

    private static String getResult(int n, Node[][] graph) {
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    result.append(graph[i][j].w == MAX ? 0 : graph[i][j].w);
                } else {
                    result.append(0);
                }
                result.append(" ");
            }
            result.append("\n");
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j || graph[i][j].w == MAX) {
                    result.append(0);
                } else {
                    result.append(graph[i][j].count).append(" ");
                    findPath(result, graph, i, j);
                    result.append(j).append(" ");
                }
                result.append("\n");
            }
        }
        return result.toString();
    }

    private static void findPath(StringBuilder result, Node[][] graph, int start, int end) {
        int via = graph[start][end].via;
        if (via == 0) {
            result.append(start).append(" ");
            return;
        }

        findPath(result, graph, start, via);
        findPath(result, graph, via, end);
    }

}