package problem.baekjoon.shotestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No2307 {
    static int N;
    static class Edge {
        int to;
        int time;
        Edge next;

        public Edge(int to, int time, Edge next) {
            this.to = to;
            this.time = time;
            this.next = next;
        }
    }

    static Edge[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new Edge[N + 1];
        times = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new Edge(i, 0, null);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph[a].next = new Edge(b, t, graph[a].next);
            graph[b].next = new Edge(a, t, graph[b].next);
        }

        int[] prevNode = new int[N + 1];
        int minTime = dijkstra(prevNode);
        int diffTime = 0;

        for (int i = 2; i <= N; i++) {
            int time = blockShortestPath(i, prevNode[i]);
            if (time == -1) {
                diffTime = -1;
                break;
            }
            diffTime = Math.max(diffTime, time - minTime);
        }

        System.out.println(diffTime);
    }

    static int[] times;

    static int dijkstra(int[] prevNode) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.time));
        pq.add(graph[1]);
        Arrays.fill(times,1_000_000_000);
        times[1] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (cur.time > times[cur.to]) {
                continue;
            }
            if (cur.to == N) {
                return cur.time;
            }

            for (Edge next = graph[cur.to].next; next != null; next = next.next) {
                if (cur.time + next.time < times[next.to]) {
                    prevNode[next.to] = cur.to;
                    times[next.to] = cur.time + next.time;
                    pq.add(new Edge(next.to, times[next.to], null));
                }
            }
        }

        return -1;
    }

    private static int blockShortestPath(int a, int b) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.time));
        pq.add(graph[1]);
        Arrays.fill(times,1_000_000_000);
        times[1] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (cur.time > times[cur.to]) {
                continue;
            }

            if (cur.to == N) {
                return cur.time;
            }

            for (Edge next = graph[cur.to].next; next != null; next = next.next) {
                if (cur.time + next.time < times[next.to]) {
                    if ((cur.to == a && next.to == b) || (cur.to == b && next.to == a)) {
                        continue;
                    }
                    times[next.to] = cur.time + next.time;
                    pq.add(new Edge(next.to, times[next.to], null));
                }
            }
        }

        return -1;
    }

}

