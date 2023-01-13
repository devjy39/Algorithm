package problem.baekjoon.shotestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No9370 {
    static class Edge {
        int to;
        float w;

        public Edge(int to, float w) {
            this.to = to;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[] nominees = new int[c];

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            List<List<Edge>> graph = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                float w = Integer.parseInt(st.nextToken());
                if (isTheRoute(g, h, start, end)) {
                    w -= 0.5f;
                }
                graph.get(start).add(new Edge(end, w));
                graph.get(end).add(new Edge(start, w));
            }

            for (int j = 0; j < c; j++) {
                nominees[j] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(nominees);

            for (int nominee : nominees) {
                if (isDestination(graph, s, nominee)) {
                    result.append(nominee).append(" ");
                }
            }
            result.append("\n");
        }

        System.out.print(result);
    }

    static int MAX = 2_000_000;
    private static boolean isDestination(List<List<Edge>> graph, int s, int nominee) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((r1, r2) -> r1.w < r2.w ? -1 : 1);
        pq.add(new Edge(s, 0));
        boolean[] visited = new boolean[graph.size()];
        float[] dist = new float[graph.size()];
        Arrays.fill(dist, MAX);
        dist[s] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (visited[cur.to]) {
                continue;
            }
            visited[cur.to] = true;

            if (cur.to == nominee) {
                return (int) cur.w != cur.w; // 소수점경로가 포함 됐는가?
            }

            for (Edge edge : graph.get(cur.to)) {
                if (!visited[edge.to] && dist[edge.to] > dist[cur.to] + edge.w) {
                    dist[edge.to] = dist[cur.to] + edge.w;
                    pq.offer(new Edge(edge.to, dist[edge.to]));
                }
            }
        }

        return false;
    }

    private static boolean isTheRoute(int g, int h, int from, int to) {
        return (to == g && from == h) || (to == h && from == g);
    }

}