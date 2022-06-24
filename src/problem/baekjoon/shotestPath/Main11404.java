package problem.baekjoon.shotestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11404 {
    static int v, e;
    static Edge[] edges;
    static final int INF = 1_000_000_000;

    public static void setInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());
        edges = new Edge[e];

        StringTokenizer st = null;
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i] = new Edge(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        br.close();
    }

    public static void main(String[] args) throws IOException {
        setInput();
        int[][] dist = new int[v + 1][v + 1];
        for (int i = 0; i < v + 1; i++) {
            for (int j = 0; j < v + 1; j++) {
                if (i != j) {
                    dist[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < e; i++) {
            int from = edges[i].from;
            int to = edges[i].to;
            dist[from][to] = Math.min(dist[from][to], edges[i].weight);
        }

        for (int k = 0; k <= v; k++) {

            for (int i = 0; i <= v; i++) {
                for (int j = 0; j <= v; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < dist.length; i++) {
            for (int j = 1; j < dist[i].length; j++) {
                sb.append((dist[i][j] == INF) ? 0 : dist[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}