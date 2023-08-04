package problem.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1325 {
    public static int max, maxCount;
    public static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(b).add(a);
        }

        int[] result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int[] visited = new int[n + 1];
            visited[i] = 1;
            maxCount = 0;
            bfs(visited, i);
            result[i] = maxCount;
            max = Math.max(max, maxCount);
        }

        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (max == result[i]) {
                resultBuilder.append(i).append(" ");
            }
        }

        System.out.print(resultBuilder);
    }

    static Queue<Integer> queue = new ArrayDeque<>();

    public static void bfs(int[] visited, int start) {
        queue.add(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph.get(cur)) {
                if (visited[next] == 0) {
                    visited[next] = 1;
                    maxCount++;
                    queue.add(next);
                }
            }
        }

    }
}

