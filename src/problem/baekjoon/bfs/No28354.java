package problem.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No28354 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        Set<Integer>[] graph = new Set[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new HashSet<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1);

        Queue<Integer> queue = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            Integer node = Integer.valueOf(st.nextToken());
            queue.add(node);
            visited[node] = 0;
        }

        Queue<Integer> next = new LinkedList<>();

        int day = 1;
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            while (day <= t) {
                //진행
                linkTomato(graph, visited, queue, day, next);

                Queue<Integer> temp = queue;
                queue = next;
                next = temp;

                day++;
            }

            // 상태 변경
            setLink(graph, visited, next, day, a, b);
        }

        while (!queue.isEmpty() || !next.isEmpty()) { // 변경 후 쭉 진행
            linkTomato(graph, visited, queue, day, next);

            Queue<Integer> temp = queue;
            queue = next;
            next = temp;

            day++;
        }

        System.out.println(getResultString(n, visited));
    }

    private static StringBuilder getResultString(int n, int[] visited) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            result.append(visited[i]).append(" ");
        }
        return result;
    }

    private static void setLink(Set<Integer>[] graph, int[] visited, Queue<Integer> next, int day, int a, int b) {
        if (graph[a].contains(b)) {
            graph[a].remove(b);
            graph[b].remove(a);
        } else {
            graph[a].add(b);
            graph[b].add(a);
        }

        if (visited[a] == -1) {
            if (visited[b] != -1 && visited[b] < day) { // b만 연결
                if (graph[b].contains(a)) { // 연결 됐으면
                    next.add(a);
                    visited[a] = day;
                }
            }
        } else {
            if (visited[b] == -1 && visited[a] < day) { // a만 연결
                if (graph[a].contains(b)) { // 연결 됐으면
                    next.add(b);
                    visited[b] = day;
                }
            }
        }
    }

    private static void linkTomato(Set<Integer>[] graph, int[] visited, Queue<Integer> queue, int day, Queue<Integer> next) {
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();

            for (Integer node : graph[cur]) {
                if (visited[node] == -1) {
                    next.add(node);
                    visited[node] = day;
                }
            }
        }

    }

}

