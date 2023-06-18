package problem.baekjoon.shotestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1939 {
    static class Edge {
        int to;
        int weight;
        Edge next;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        public Edge(int to, int weight, Edge next) {
            this.to = to;
            this.weight = weight;
            this.next = next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Edge[] nodes = new Edge[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            nodes[a] = new Edge(b, w, nodes[a]);
            nodes[b] = new Edge(a, w, nodes[b]);
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(getMaxWeightPath(nodes, start, end));
    }

    private static int getMaxWeightPath(Edge[] nodes, int start, int end) {
        PriorityQueue<Edge> queue = new PriorityQueue<>((e1, e2) -> e2.weight - e1.weight);
        queue.add(new Edge(start, Integer.MAX_VALUE));
        boolean[] visited = new boolean[nodes.length];

        while (!queue.isEmpty()) {
            Edge edge = queue.remove();

            if (visited[edge.to]) {
                continue;
            } else if (edge.to == end) {
                return edge.weight;
            }
            visited[edge.to] = true;

            for (Edge node = nodes[edge.to]; node != null; node = node.next) {
                if (!visited[node.to]) {
                    queue.add(new Edge(node.to, Math.min(node.weight, edge.weight)));
                }
            }
        }

        return -1;
    }

}

