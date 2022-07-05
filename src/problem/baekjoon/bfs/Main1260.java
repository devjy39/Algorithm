package problem.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1260 {
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        br.close();
        graph.forEach(adjList -> adjList.sort(Comparator.naturalOrder()));

        dfsResult = new StringBuilder();
        visited = new boolean[n + 1];
        dfs(graph, v);
        System.out.println(dfsResult);

        visited = new boolean[n + 1];
        System.out.println(bfs(graph, n, v));
    }

    static StringBuilder dfsResult;
    private static void dfs(List<List<Integer>> graph, int start) {
        dfsResult.append(start).append(" ");
        visited[start] = true;

        for (int node : graph.get(start)) {
            if (!visited[node]) {
                dfs(graph, node);
            }
        }
    }

    private static StringBuilder bfs(List<List<Integer>> graph, int n, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        StringBuilder result = new StringBuilder();
        result.append(start).append(" ");
        visited[start] = true;

        Queue<Integer> next = new LinkedList<>();
        int cnt = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cnt == n) {
                break;
            }
            for (int node : graph.get(cur)) {
                if (!visited[node]) {
                    visited[node] = true;
                    next.add(node);
                    result.append(node).append(" ");
                    cnt++;
                }
            }
            if (queue.isEmpty()) {
                queue = next;
            }
        }

        return result;
    }
}