package algorithm.MST;
// Practice1
// 2250년, 인류는 지구 뿐 아니라 여러 행성을 다니며 살고 있다.
// 이 행성 간을 빨리 오가기 위해 새롭게 터널을 구축하려 한다.

// 행성은 (x, y, z) 좌표로 주어진다.
// 행성1: (x1, y1, z1), 행성2: (x2, y2, z2)
// 이 때 행성간 터널 연결 비용은 min(|x1-x2|, |y1-y2|, |z1-z2|) 로 계산한다.

// n 개의 행성 사이를 n-1 개의 터널로 연결하는데 드는 최소 비용을 구하는 프로그램을 작성하세요.

// 입출력 예시
// 입력:
// data = {{11, -15, -15}, {14, -5, -15}, {-1, -1, -5}, {10, -4, -1}, {19, -4, 19}}
// 출력: 4


import java.util.*;

public class Practice1 {
    static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }

    static int[] parents;
    static List<Edge> edges;

    static int getDistance(int[] a, int[] b) {
        return Math.min(Math.min(Math.abs(a[0] - b[0]), Math.abs(a[1] - b[1])),
                Math.abs(a[2] - b[2]));
    }

    static int find(int a) { //부모노드 찾기
        if (a == parents[a]) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }

    static void union(int a, int b) {// 연결
        int aP = find(a);
        int bP = find(b);

        if (aP != bP) {
            parents[aP] = bP;
        }
    }

    public static int solution(int[][] data) {
        int n = data.length;
        edges = new ArrayList<>();
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new Edge(i, j, getDistance(data[i], data[j])));
            }
        }
        Collections.sort(edges);
        int weightSum = 0;
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (Edge edge : edges) {
            if (find(edge.from) != find(edge.to)) {
                System.out.println(edge);
                union(edge.from, edge.to);
                weightSum += edge.weight;
                System.out.println(Arrays.toString(parents) +" w: " + weightSum);
            }
        }
        System.out.println(Arrays.toString(parents));

        return weightSum;
    }

    public static void main(String[] args) {
        // Test code
        int[][] data = {{11, -15, -15}, {14, -5, -15}, {-1, -1, -5}, {10, -4, -1}, {19, -4, 19}};
        System.out.println(solution(data));
    }
}
