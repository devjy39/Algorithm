package algorithm.practice.practice2.src;

import java.util.Arrays;

/*  dp로 정사각형일 경우 변의 길이를 누적해서 구한다.
* */
public class Practice4 {
    public static int solution(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return -1;
        }
        int result = 0;
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                if (i == 0 || j == 0) {
                    result = Math.max(result, matrix[i][j]);
                    continue;
                }
                matrix[i][j] = Math.min( Math.min(matrix[i - 1][j], matrix[i][j - 1]),
                            matrix[i - 1][j - 1]) + 1;
                result = Math.max(result, matrix[i][j]);
            }
        }

        System.out.println(Arrays.deepToString(matrix));

        return result * result;
    }

    public static void main(String[] args) {
        // Test code
        int[][] data = {{0, 1}, {1, 0}};
        System.out.println(solution(data));

        data = new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 1, 1, 0}};
        System.out.println(solution(data));
    }
}
