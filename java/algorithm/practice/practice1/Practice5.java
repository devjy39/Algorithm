package algorithm.practice.practice1;

import java.util.*;

public class Practice5 {

    static List<List<int[]>> graph;
    public static int solution(int n, int m, int[][] data) {
        if (data == null || data.length == 0 || data[0].length == 0) {
            return -1;
        }

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] datum : data) {
            graph.get(datum[0]).add(new int[]{datum[1], datum[2] ^ 1});
            graph.get(datum[1]).add(new int[]{datum[0], 0});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        int minWeightSum = prim(pq, n);

        pq = new PriorityQueue<>((x, y) -> y[1] - x[1]); //max
        int maxWeightSum = prim(pq, n);

        System.out.println("kruskal : "+(kruskal(n, m, data, false) - kruskal(n, m, data, true)));
        return maxWeightSum - minWeightSum;
    }
    static int[] parents;

    static int kruskal(int n, int m, int[][] data, boolean isAscent) {

        for (int i = 0; i < m; i++) {
            data[i][2] = data[i][2] ^ 1;
        }

        if (isAscent) {
            Arrays.sort(data, (x, y) -> x[2] - y[2]); //min
        } else {
            Arrays.sort(data, (x, y) -> y[2] - x[2]); //max
        }

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        int weightSum = 0;

        for (int[] datum : data) {
            if (find(datum[0]) != find(datum[1])) {
                union(datum[0], datum[1]);
                weightSum += datum[2];
            }
        }

        return (int) Math.pow(weightSum, 2);
    }

    private static void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);

        if (p1 != p2) {
            parents[n1] = p2;
        }
    }

    private static int find(int node) {
        if (parents[node] == node) {
            return node;
        }

        return parents[node] = find(parents[node]);
    }


    static int prim(PriorityQueue<int[]> pq, int n) {
        int weightSum = 0;
        boolean[] visited = new boolean[n + 1];
        int cnt = 0;
        pq.add(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (visited[cur[0]]) {
                continue; //사이클제거
            }

            visited[cur[0]] = true;
            weightSum += cur[1];
            if (++cnt == n) {
                break;
            }

            for (int[] edge : graph.get(cur[0])) {
                if (!visited[edge[0]]) {
                    pq.add(edge);
                }
            }
        }

        return (int) Math.pow(weightSum, 2);
    }

    public static void main(String[] args) {
        // Test code
        int n = 4;
        int m = 5;
        int[][] data = {{1, 2, 0}, {1, 4, 0}, {2, 3, 0}, {3, 4, 1}, {4, 2, 1}};

        System.out.println(solution(n, m, data));
    }
}
