package problem.baekjoon.shotestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1504 {
    static class Edge {
        int to;
        int w;

        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map[n1][n2] = w;
            map[n2][n1] = w;
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        System.out.println(getViaDistance(v1, v2));
    }

    private static int getViaDistance(int v1, int v2) {
        int n = map.length - 1;
        int v1First = getCourseDistance(v1, v2, n);
        int v2First = getCourseDistance(v2, v1, n);
        int minDistance = Math.min(v1First, v2First);

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance + getDistance(v1, v2);
    }

    // 1 -> v1   +   v2 -> n
    private static int getCourseDistance(int v1, int v2, int n) {
        int distance1 = getDistance(1, v1);
        if (distance1 == -1) {
            return Integer.MAX_VALUE;
        }
        int distance2 = getDistance(v2, n);
        if (distance2 == -1) {
            return Integer.MAX_VALUE;
        }

        return distance1 + distance2;
    }

    private static int getDistance(int start, int to) {
        int n = map.length;
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.w));
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (visited[cur.to]) {
                continue;
            }
            visited[cur.to] = true;
            if (cur.to == to) {
                return cur.w;
            }

            for (int node = 1; node < n; node++) {
                if (!visited[node] && map[cur.to][node] > 0) {
                    pq.add(new Edge(node, cur.w + map[cur.to][node]));
                }
            }
        }

        return -1;
    }


}