package problem.baekjoon.MST;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main4386 {
    static int v;
    static List<List<Node>> graph;
    static Point2D[] planet;

    public static void setInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        v = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }
        planet = new Point2D[v];

        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            planet[i] = new Point2D.Double(Double.parseDouble(st.nextToken()),
                    Double.parseDouble(st.nextToken()));
        }
        br.close();
    }

    public static void main(String[] args) throws IOException {
        setInput();
        double weightSum = 0;
        for (int i = 0; i < v; i++) {
            for (int j = i + 1; j < v; j++) {
                graph.get(i).add(new Node(j, planet[i].distance(planet[j])));
                graph.get(j).add(new Node(i, planet[i].distance(planet[j])));
            }
        }

        boolean[] visited = new boolean[v];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));
        int cnt = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.to]) {
                continue;
            }

            visited[cur.to] = true;
            weightSum += cur.weight;
            if (++cnt == v) {
                break;
            }

            for (Node node : graph.get(cur.to)) {
                if (!visited[node.to]) {
                    pq.add(new Node(node.to, node.weight));
                }
            }
        }

        System.out.println(weightSum);
    }

    private static class Node implements Comparable<Node>{
        int to;
        double weight;

        public Node(int to, double weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight > 0 ? 1 : -1;
        }
    }
}