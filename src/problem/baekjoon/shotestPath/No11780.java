package problem.baekjoon.shotestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11780 {
    static class Path {
        int node;
        Path prev;

        public Path(int node) {
            this.node = node;
        }
    }

    static class Node {
        int w;
        Path path;

        public Node(int w, Path path) {
            this.w = w;
            this.path = path;
        }

    }

    static int MAX = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/data.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        Node[][] graph = new Node[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j && graph[i][j] == null) {
                    graph[i][j] = new Node(MAX, null);
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
            graph[s][e].path = new Path(s);
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
                        Path prev = graph[via][j].path;
                        Path cur = graph[i][j].path = new Path(prev.node);
                        prev = prev.prev;

                        while (prev != null) {
                            cur.prev = new Path(prev.node);
                            cur = cur.prev;
                            prev = prev.prev;
                        }
                        cur.prev = graph[i][via].path;
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

        int[] tmp = new int[101];
        int count;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j || graph[i][j].path == null) {
                    result.append(0);
                } else {
                    count = 0;
                    tmp[count] = j;
                    Path path = graph[i][j].path;
                    while (path != null) {
                        tmp[++count] = path.node;
                        path = path.prev;
                    }

                    result.append(count + 1).append(" ");
                    for (int k = count; k >= 0; k--) {
                        result.append(tmp[k]).append(" ");
                    }
                }
                result.append("\n");
            }
        }
        return result.toString();
    }

}