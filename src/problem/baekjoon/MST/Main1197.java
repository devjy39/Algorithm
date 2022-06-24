package problem.baekjoon.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1197 {
    static int v, e;
    static Edge[] edges;
    static int[] parents;

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
        parents = new int[v + 1];
        for (int i = 1; i < parents.length; i++) {
            parents[i] = i;
        }
        int weightSum = 0;
        Arrays.sort(edges, (x, y) -> x.weight - y.weight);

        for (int i = 0; i < e; i++) {
            Edge edge = edges[i];
            if (find(edge.from) != find(edge.to)) {
                union(edge.from, edge.to);
                weightSum += edge.weight;
            }
        }

        System.out.println(weightSum);
    }

    private static void union(int from, int to) {
        int fromP = find(from);
        int toP = find(to);

        if (fromP != toP) {
            parents[fromP] = toP;
        }
    }

    private static int find(int a) {
        if (a == parents[a]) {
            return a;
        }
        return parents[a] = find(parents[a]);
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