package algorithm.shortestPath;
/*  벨만-포드
*   다익스트라와 달리 음수 간선이 있어도 구할 수 있다.
*   음수 사이클이 있으면 정상동작 안함
*       음수 사이클은 사이클을 돌수록 값이 계속 작아지는 사이클이다.
*   매번 모든 간선을 확인하기 때문에 다익스트라보다 느림 O(VE)
*   결국 모든 노드를 간선수만큼 계속 돌려야함 n^2
*/

import java.util.Arrays;

public class BellmanFord {
    static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    public static void bellmanFord(int v, int e, int[][] data, int start) {
        Edge[] edges = new Edge[e];
        for (int i = 0; i < e; i++) {
            edges[i] = new Edge(data[i][0],data[i][1],data[i][2]);
        }

        int[] dist = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        boolean isMinusCycle = false;

        for (int i = 0; i < v + 1; i++) {
            for (int j = 0; j < e; j++) {
                Edge cur = edges[j];

                if (dist[cur.from] == Integer.MAX_VALUE) {
                    continue;
                }

                if (dist[cur.to] > dist[cur.from] + cur.weight) {
                    dist[cur.to] = dist[cur.from] + cur.weight;

                    if (i == v) {
                        isMinusCycle = true;
                    }
                }
            }
            System.out.println(Arrays.toString(dist));
        }

        System.out.println("음수 사이클 : "+isMinusCycle);

    }

    public static void main(String[] args) {
        // Test code
        int[][] data = {{1, 2, 8}, {1, 3, 6}, {1, 5, 5}, {2, 3, -5}, {2, 4, 1}, {2, 6, 4}, {3, 4, 4}, {4, 7, 3}, {5, 6, 5}, {6, 2, 0}, {6, 7, -7}};
        bellmanFord(7, 11, data, 1);

        data = new int[][]{{1, 2, 8}, {1, 3, 6}, {1, 5, 5}, {2, 3, -5}, {2, 4, 1}, {2, 6, 4}, {3, 4, 4}, {4, 7, 3}, {5, 6, 5}, {6, 2, -5}, {6, 7, -7}};
        bellmanFord(7, 11, data, 1);
    }
}
