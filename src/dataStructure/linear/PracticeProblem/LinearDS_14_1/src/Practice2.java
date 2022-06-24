package dataStructure.linear.PracticeProblem.LinearDS_14_1.src;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Practice2 {

    public static void solution(int[][] matrix) {
        Set<Integer> x = new HashSet<>();
        Set<Integer> y = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    x.add(i);
                    y.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (x.contains(i) || y.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

        System.out.println(Arrays.deepToString(matrix));
    }

    public static void main(String[] args) {
        // Test code
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution(matrix);

        System.out.println();
        matrix = new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        solution(matrix);
    }
}
