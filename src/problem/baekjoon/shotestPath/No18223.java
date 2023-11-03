package problem.baekjoon.shotestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No18223 {
    static class Edge{
        int to;
        int distance;
        boolean save;

        public Edge(int to, int distance, boolean save) {
            this.to = to;
            this.distance = distance;
            this.save = save;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>(v + 1);
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, d, false));
            graph.get(b).add(new Edge(a, d, false));
        }

        System.out.println(isSaved(graph, p) ? "SAVE HIM" : "GOOD BYE");
    }

    private static boolean isSaved(List<List<Edge>> graph, int p) {
        int[] distance = new int[graph.size()];
        Arrays.fill(distance, 1_000_000_000);
        int V = graph.size() - 1;
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.distance));

        distance[1] = 0;
        queue.add(new Edge(1, 0, false));

        while (!queue.isEmpty()) {
            Edge cur = queue.poll();
            if (cur.distance > distance[cur.to]) {
                continue;
            }
            if (cur.to == p) {
                cur.save = true;
            } else if (cur.to == V && cur.save) {
                return true;
            }

            for (Edge next : graph.get(cur.to)) {
                if (cur.distance + next.distance <= distance[next.to]) {
                    distance[next.to] = cur.distance + next.distance;
                    queue.add(new Edge(next.to, distance[next.to], cur.save));
                }
            }
        }

        return false;
    }

}

