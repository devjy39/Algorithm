package problem.baekjoon.MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No20040 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] edges = new int[m][2];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.print(kruskal(edges, n));
    }

    static int[] parents;
    private static int kruskal(int[][] edges, int n) {
        parents = new int[n];
        for (int i = 1; i < n; i++) {
            parents[i] = i;
        }

        int count = 1;

        for (int[] edge : edges) {
            if (find(edge[0]) != find(edge[1])) {
                count++;
                union(edge[0], edge[1]);
            } else {
                return count;
            }
        }

        return 0;
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