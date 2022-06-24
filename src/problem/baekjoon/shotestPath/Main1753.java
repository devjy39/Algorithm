package problem.baekjoon.shotestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1753 {
    static int v, start;
    static Map<Integer, List<Node>> graph;
    static final int INF = 1_000_000_000;

    public static void setInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        graph = new HashMap<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            if (!graph.containsKey(from)) {
                graph.put(from, new ArrayList<>());
            }
            graph.get(from).add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        br.close();

    }

    public static void main(String[] args) throws IOException {
        setInput();
        int[] dist = new int[v + 1];
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.offer(new Node(start, 0));
        Arrays.fill(dist, INF);
        dist[start] = 0;
        boolean[] visited = new boolean[v + 1];
        visited[start] = true;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (!graph.containsKey(cur.to)) {
                continue;
            }
            visited[cur.to] = true;
            for (Node node : graph.get(cur.to)) {
                int w = dist[cur.to] + node.weight;
                if (!visited[node.to] && w < dist[node.to]) { // math.min 금지 메모리초과
                    dist[node.to] = w;
                    pq.add(new Node(node.to, dist[node.to]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == INF) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.print(sb);
    }

    static class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}