package algorithm.practice.practice2.src;

public class Practice4 {
    public static int solution(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return -1;
        }

        return 0;
    }

    public static void main(String[] args) {
        // Test code
        int[][] data = {{0, 1}, {1, 0}};
        System.out.println(solution(data));

        data = new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 1, 1, 0}};
        System.out.println(solution(data));
    }
}
