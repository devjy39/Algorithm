package algorithm.shortestPath;
// Practice1
// 2차원 배열 data 에 그래프 데이터가 주어졌다.
// 무방향이고 간선에 가중치 값이 있는 그래프이다.
// 1번 정점에서 N 번 정점으로 최단 경로로 이동하려고 하는데,
// 두 정점을 경유해서 가려고 한다.
// 1번 점점에서 출발하여 두 정점을 경유하여 N 번 정점으로 가는 최단 경로를 구하세요.

// 입출력 예시)
// 입력 data: {{1, 2, 3}, {1, 3, 5}, {1, 4, 4}, {2, 3, 3}, {2, 4, 5}, {3, 4, 1}}
// 출력: 7


import java.util.*;

public class Practice1 {
    static List<List<Node>> graph;
    final static int INF = 1_000_000_000;

    public static int solution(int[][] data, int v, int via1, int via2, int start, int n) {
        graph = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < data.length; i++) {
            graph.get(data[i][0]).add(new Node(data[i][1], data[i][2]));
        }

        //case1 start -> via1 -> via2 -> n
        int case1 = dijkstra(v, start, via1);
        case1 += dijkstra(v, via1, via2);
        case1 += dijkstra(v, via2, n);

        //case2 start -> via2 -> via1 -> n
        int case2 = dijkstra(v, start, via2);
        case2 += dijkstra(v, via2, via1);
        case2 += dijkstra(v, via1, n);

        int min = Math.min(case1, case2);
        return min >= INF ? -1 : min;
    }

    public static int dijkstra(int v, int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(i->i.weight));
        pq.add(new Node(start, 0));
        int[] dist = new int[v + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        boolean[] visited = new boolean[v + 1];
        visited[start] = true;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (Node node : graph.get(cur.to)) {
                dist[node.to] = Math.min(dist[node.to], node.weight);
                if (!visited[node.to]) {
                    visited[node.to] = true;
                    pq.add(new Node(node.to, node.weight));
                }
            }
        }

        System.out.println(Arrays.toString(dist));
        return dist[end];
    }

    public static void main(String[] args) {
        // Test code
        int[][] data = {{1, 2, 3}, {1, 3, 5}, {1, 4, 4}, {2, 3, 3}, {2, 4, 5}, {3, 4, 1}};
        int v = 4;
        int via1 = 2;
        int via2 = 3;
        int start = 1;
        int n = 4;
        System.out.println(solution(data, v, via1, via2, start, n));
    }
}
