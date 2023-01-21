package problem.baekjoon.shotestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No11779 {
    static class Node {
        int to;
        int w;
        Node prev;

        public Node(int to, int w) {
            this.to = to;
            this.w = w;
        }

        public Node(int to, int w, Node prev) {
            this.to = to;
            this.w = w;
            this.prev = prev;
        }
    }

    static int MAX = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/data.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, w));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        System.out.println(getShortestPath(n, graph, s, e));
    }

    private static String getShortestPath(int n, List<List<Node>> graph, int s, int e) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.w));
        pq.add(new Node(s, 0));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, MAX);
        boolean[] visited = new boolean[n + 1];
        dist[s] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.to]) {
                continue;
            }
            visited[cur.to] = true;

            if (cur.to == e) {
                return getPath(cur);
            }

            for (Node node : graph.get(cur.to)) {
                if (!visited[node.to] && cur.w + node.w < dist[node.to]) {
                    pq.add(new Node(node.to, cur.w + node.w, cur));
                    dist[node.to] = cur.w + node.w;
                }
            }
        }

        return null;
    }

    private static String getPath(Node cur) {
        StringBuilder sb = new StringBuilder();
        sb.append(cur.w).append("\n");

        List<Integer> list = new ArrayList<>();

        while (cur != null) {
            list.add(cur.to);
            cur = cur.prev;
        }

        sb.append(list.size()).append("\n");
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i)).append(" ");
        }

        return sb.toString();
    }

}