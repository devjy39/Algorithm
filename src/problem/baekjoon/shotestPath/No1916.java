package problem.baekjoon.shotestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1916 {

    static class Node implements Comparable<Node>{
        int to;
        int w;

        public Node(int to, int w) {
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    static int maxPrice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        maxPrice = (n + 1) * 100_000; // 경로의 최대 값

        List<List<Node>> edges = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            edges.get(Integer.parseInt(st.nextToken()))
                    .add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());
        br.close();

        System.out.println(dijkstra(n, edges, startNode, endNode, new int[n + 1]));
    }

    private static int dijkstra(int n, List<List<Node>> edges, int startNode, int endNode, int[] dist) {
        Arrays.fill(dist, maxPrice);
        dist[startNode] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startNode, 0));
        boolean[] visited = new boolean[n + 1];

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.to]) {
                continue;
            }
            if (cur.to == endNode) { // 최적화) 목적지까지만 탐색
                break;
            }
            visited[cur.to] = true;

            for (Node node : edges.get(cur.to)) {
                if (visited[node.to]) {
                    continue; // 최적화) pq 최적화
                }
                int w = dist[cur.to] + node.w;

                if (!visited[node.to] && w < dist[node.to]) {
                    pq.add(new Node(node.to, w));
                    dist[node.to] = w;
                }
            }
        }

        return dist[endNode];
    }

}