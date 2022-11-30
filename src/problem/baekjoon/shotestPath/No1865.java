package problem.baekjoon.shotestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1865 {

    static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static final int INF = 100_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            Edge[] edges = new Edge[e * 2 + w];

            for (int j = 0; j < 2 * e; j += 2) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                edges[j] = new Edge(start, end, weight);
                edges[j + 1] = new Edge(end, start, weight);
            }
            for (int j = 2*e; j < 2*e+w; j++) {
                st = new StringTokenizer(br.readLine());
                edges[j] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), -Integer.parseInt(st.nextToken()));
            }

            result.append(bellmanFord(v, edges) ? "YES" : "NO").append("\n");
        }
        br.readLine();

        System.out.print(result);
    }

    private static boolean bellmanFord(int v, Edge[] edges) {
        int[] dist = new int[v + 1];
        Arrays.fill(dist, INF);
        // dist[1] = 0;

        for (int i = 0; i <= v; i++) {
            for (Edge edge : edges) {

//                if (dist[edge.from] == INF) {
//                    continue;
//                } 이 조건을 넣으면 안되는 이유 = 이 조건은 출발지에서 부터 차례대로 가게 만드는 조건인데
//                이 문제는 어느 노드가 출발지가 되어도 음수 사이클만 체크하면 되기 때문이다.

                if (dist[edge.to] > dist[edge.from] + edge.weight) {
                    dist[edge.to] = dist[edge.from] + edge.weight;

                    if (i == v) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

}