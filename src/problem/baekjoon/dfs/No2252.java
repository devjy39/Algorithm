package problem.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No2252 {
    static List<Set<Integer>> graph;
    static final String SPACE = " ";
    static StringBuilder result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new HashSet<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(end).add(start);
        }
        result = new StringBuilder();


        topologicalSort(n);
        System.out.print(result);
    }

    private static void topologicalSort(int n) {
        for (int i = 1; i <= n; i++) {
            if(graph.get(i) != null) {
                dfs(i);
            }
        }
    }

    private static void dfs(int node) {
        for (Integer input : graph.get(node)) {
            if(graph.get(input) != null) {
                dfs(input);
            }
        }

        result.append(node).append(SPACE);
        graph.set(node, null);
    }

}