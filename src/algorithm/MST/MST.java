package algorithm.MST;
/*  알고리즘 - 최소 신장 트리 Minimum Spanning Tree
*   그래프 상 모든 노드들을 최소 비용으로 연결. *최단경로와 차이 : 모든 노드를 방문!
*   kruskal   -> 선택기준 - 간선을 정렬 돌려도 시간이 괜찮겠는가?
*   간선 중 최소 값을 가진 간선부터 연결, *핵심* : 간선의 *정렬*! + 연결노드표시 + union find
*   사이클 발생 시 다른 간선 선택 - union-find 배열로 부모노드 가르키는 것 메모
*   주로 간선 수가 적을 때 사용, O(ElogE)  정렬한 간선만 돌리기 때문에 정렬값만 소모.
*
*   prim
*   임의 노드에서 시작,현재 갈 수 있는 모든(들른노드 모두 포함)간선 중에서 가장 낮은 가중치를 갖는 간선 선택
*   visited check로 사이클 제거
*   간선의 개수가 많을 때 크루스칼보다 유리. O(ElogV) 노드를 기준으로 최소값 간선을 돌리기 때문
*   간선은 최대값인 v^2에 가까울 때 크다고 판단.
*  */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MST {
    static int[] parents;
    public static int kruskal(int[][] data, int v, int e) {
        int weightSum = 0;

        Arrays.sort(data, (x, y) -> x[2] - y[2]);
        parents = new int[v + 1];
        for (int i = 1; i < v + 1; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < e; i++) {
            if (find(data[i][0]) != find(data[i][1])) { //사이클 제거
                union(data[i][0], data[i][1]);
                weightSum += data[i][2];
            }
        }

        System.out.println(Arrays.toString(parents));
        return weightSum;
    }

    //b의 부모노드를 a의 부모노드로 설정
    public static void union(int a, int b) {
        int aP = find(a);
        int bP = find(b);

        if (aP != bP) {
            parents[aP] = bP;
        }
    }

    public static int find(int a) {
        if (a == parents[a]) {
            return a;
        }
        // 업데이트 된 부모노드 찾아 쭉 이동
        return parents[a] = find(parents[a]);
    }

//-----------------------------------prim-----------------------------------------------

    public static int prim(int[][] data, int v, int e) {
        int weightSum = 0;

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            graph.get(data[i][0]).add(new Node(data[i][1], data[i][2]));
            graph.get(data[i][1]).add(new Node(data[i][0], data[i][2]));
        }

        boolean[] visited = new boolean[v + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((i, j) -> i.weight - j.weight);
        pq.offer(new Node(1, 0));
        int cnt = 0;

        while (!pq.isEmpty()) {
            System.out.println(pq);
            Node cur = pq.poll();
            if (visited[cur.to]) {
                // 최선의 간선 값이지만, 방문한 노드이므로 이걸로 사이클이 제거됨
                continue;
            }

            visited[cur.to] = true; //현 노드를 방문 했을 때 방문표시를 해야함.
            weightSum += cur.weight;
            System.out.println(cur.to + " " + weightSum);

            if (++cnt == v) {
                // 가중치가 다른 같은 목적지의 간선이 pq에 있으니, 모든 최선 노드 방문 시 탈출
                break;
            }


            for (Node node : graph.get(cur.to)) {
                // 실제 방문하지 않았으면 목적지가 같아도 가중치가 다르므로 다 넣어야 함.
                if (!visited[node.to]) {
                    pq.offer(node);
                }
            }
        }

        return weightSum;
    }

    public static void main(String[] args) {
        // Test code
        int v = 7;
        int e = 10;
        int[][] graph = {{1, 3, 1}, {1, 2, 9}, {1, 6, 8}, {2, 4, 13}, {2, 5, 2}, {2, 6, 7}, {3, 4, 12}, {4, 7, 17}, {5, 6, 5}, {5, 7, 20}};
        System.out.println("kruskal => "+kruskal(graph, v, e));

        System.out.println("prim => "+prim(graph, v, e));
    }
}

class Node {
    int to;
    int weight;

    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "to=" + to +
                ", weight=" + weight +
                '}';
    }
}