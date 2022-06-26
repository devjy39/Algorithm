package algorithm.practice.practice2.src;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*  최소신장트리,
*   간선의 수가 많기 때문에(최대값) prim 알고리즘이 효율적.
* */
public class Practice5 {
    static class Node {
        int idx;
        int weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "idx=" + idx +
                    ", weight=" + weight +
                    '}';
        }
    }

    static boolean[] visited;

    public static int solution(int[][] points) {
        visited = new boolean[points.length];
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int distance = Math.abs(points[i][0] - points[j][0]) +
                        Math.abs(points[i][1] - points[j][1]);
                graph.get(i).add(new Node(j, distance));
                graph.get(j).add(new Node(i, distance));
            }
        }

        return prim(graph, points.length);
    }

    private static int prim(List<List<Node>> graph, int n) {
        int weightSum = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.weight));
        pq.add(new Node(0, 0));
        int cnt = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.idx]) {
                continue;
            }
            visited[cur.idx] = true;
            weightSum += cur.weight;
            if (++cnt == n) {
                break;
            }

            for (Node node : graph.get(cur.idx)) {
                if (!visited[node.idx]) {
                    pq.add(node);
                }
            }

        }

        return weightSum;
    }


    public static void main(String[] args) {
        // Test code
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        System.out.println(solution(points));

        points = new int[][]{{-4, 1}, {3, 12}, {-2, 5}};
        System.out.println(solution(points));
    }
}
