package algorithm.practice.practice2.src;

public class Practice5 {
    static class Node {
        int idx;
        int weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    static boolean[] visited;

    public static int solution(int[][] points) {
        visited = new boolean[points.length];

        return 0;
    }

    public static void main(String[] args) {
        // Test code
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        System.out.println(solution(points));

        points = new int[][]{{-4, 1}, {3, 12}, {-2, 5}};
        System.out.println(solution(points));
    }
}
