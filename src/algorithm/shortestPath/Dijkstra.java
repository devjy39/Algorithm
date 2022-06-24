package algorithm.shortestPath;

import java.util.*;

/*  알고리즘 - 최단 경로 Dijkstra
 *   한 노드에서 다른 모든 노드로의 최단경로가 구해진다.
 *   간선에 음의 가중치가 없어야 함!
 *   그리디 + DP 로   O(E logV)
 *   우선순위큐 써서 시작점,거리0 넣고 시작점에서 총거리가 가까운 노드순으로 돌리면 됨.
 *   pq에 들어가는 가중치는 시작점에서 총 거리가 돼야한다. 그래야 단거리 노드부터 방문이 가능 함.
 *   visited 최적화가 가능함! 하지만 동일 노드가 pq에 들어갈 수 있으므로 visit continue 필수
 * */

public class Dijkstra {
    static boolean[] visited; // 필수
    //우선순위 큐로 구현
    public static void dijkstraPriQ(int v, int[][] data, int start) {
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < data.length; i++) {
            graph.get(data[i][0]).add(new Node(data[i][1], data[i][2]));
        }

        int[] dist = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        pq.add(new Node(start, 0));
        visited = new boolean[v + 1];

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.to]) {
                continue; //필수 최적화
            }
            visited[cur.to] = true;

            for (Node adjNode : graph.get(cur.to)) {
                int w = adjNode.weight + dist[cur.to];

                if (!visited[adjNode.to] && w < dist[adjNode.to]) {
                    dist[adjNode.to] = w;
                    pq.add(new Node(adjNode.to, dist[adjNode.to])); // new node 필수
                }
            }
        }

        System.out.println(Arrays.toString(dist));
    }

    public static void main(String[] args) {
        // Test code
        int[][] data = {{1, 2, 2}, {1, 3, 3}, {2, 3, 4}, {2, 4, 5}, {3, 4, 6}, {5, 1, 1}};
        dijkstraPriQ(5, data, 1);
    }
}
