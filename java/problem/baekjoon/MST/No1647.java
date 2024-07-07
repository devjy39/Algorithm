package problem.baekjoon.MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1647 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> edges = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[2]));

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new int[]{a, b, c});
        }

        System.out.print(kruskal(edges, n));
    }

    static int[] parents;
    private static int kruskal(PriorityQueue<int[]> edges, int n) {
        int sum = 0;
        int edgesCount = 2;

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        while (!edges.isEmpty()) {
            int[] edge = edges.poll();
            if (find(edge[0]) != find(edge[1])) {
                union(edge[0], edge[1]);
                sum += edge[2];
                if (++edgesCount >= n) {
                    break;
                }
            }
        }

        return sum;
    }

    private static void union(int a, int b) {
        int pA = find(a);
        int pB = find(b);

        parents[pB] = pA;
    }

    private static int find(int n) {
        if (parents[n] == n) {
            return n;
        }

        return parents[n] = find(parents[n]);
    }

}