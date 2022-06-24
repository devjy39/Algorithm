package problem.baekjoon.shotestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11657 {
    static int v, e;
    static Edge[] edges;
    static final int INF = 1_000_000_000;

    public static void setInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        edges = new Edge[e];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i] = new Edge(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        br.close();
    }

    public static void main(String[] args) throws IOException {
        setInput();
        long[] dist = new long[v + 1]; //weight 범위가 커 long으로
        Arrays.fill(dist, INF);
        dist[1] = 0;
        boolean isMinus = false;

        for (int i = 0; i < v + 1; i++) {
            for (int j = 0; j < e; j++) {
                Edge edge = edges[j];
                if (dist[edge.from] == INF) {
                    continue;
                }

                long viaDist = dist[edge.from] + edge.weight;
                if (dist[edge.to] > viaDist) { //경유가 더 빠르다면
                    dist[edge.to] = viaDist;

                    if (i == v) {
                        isMinus = true;
                        break;
                    }
                }
            }
        }

        if (isMinus) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i < dist.length; i++) {
                if (dist[i] == INF) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(dist[i]).append("\n");
                }
            }
            System.out.print(sb);
        }
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