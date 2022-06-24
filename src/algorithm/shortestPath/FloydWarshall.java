package algorithm.shortestPath;
/*  플로이드-워셜
*   모든 노드 간의 최단경로
*   음의 간선이 있어도 되고, 음수 사이클이 있으면 안됨
*   음수 사이클은 자기 자신으로 가는 가중치가 -인지 확인
*   O(V^3)  3중 포문
*   말 그대로 이차원 저장 테이블을 갖고 모든 경우의 수(via 거쳐가는) 다돌리기
*   모든 최소 간선의 정보를 구하라고 할때나 쓸듯
*/

public class FloydWarshall {
    static int[][] dist;
    static final int INF = 1_000_000_000; //overflow 방지

    public static void floydWarshall(int v, int e, int[][] data, int start) {
        dist = new int[v + 1][v + 1];
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (i != j) {
                    dist[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < e; i++) {
            dist[data[i][0]][data[i][1]] = data[i][2];
        }

        for (int k = 1; k <= v; k++) { //K를 거쳐감

            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        for (int i = 1; i < v + 1; i++) {
            for (int j = 1; j < v + 1; j++) {
                if (dist[i][j] == INF) {
                    System.out.printf("  INF\t");
                } else {
                    System.out.printf("%5d\t", dist[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Test code
        int[][] data = {{1, 2, 8}, {1, 3, 6}, {1, 5, 5}, {2, 3, -5}, {2, 4, 1}, {2, 6, 4}, {3, 4, 4}, {4, 7, 3}, {5, 6, 5}, {6, 2, 0}, {6, 7, -7}};
        floydWarshall(7, 11, data, 1);
        System.out.println();

        data = new int[][]{{1, 2, 8}, {1, 3, 6}, {1, 5, 5}, {2, 3, -5}, {2, 4, 1}, {2, 6, 4}, {3, 4, 4}, {4, 7, 3}, {5, 6, 5}, {6, 2, -5}, {6, 7, -7}};
        floydWarshall(7, 11, data, 1);
    }
}
