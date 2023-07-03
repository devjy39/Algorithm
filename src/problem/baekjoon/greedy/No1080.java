package problem.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1080 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] matrix1 = new boolean[n][m];
        boolean[][] matrix2 = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                matrix1[i][j] = str.charAt(j) == '1';
            }
        }
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                matrix2[i][j] = str.charAt(j) == '1';
            }
        }

        System.out.println(getReplacementCount(matrix1, matrix2, n, m));
    }

    private static int getReplacementCount(boolean[][] matrix1, boolean[][] matrix2, int n, int m) {
        if (n < 3 || m < 3) {
            return isDifferent(matrix1, matrix2, 0, 0) ? -1 : 0;
        }

        int replaceCount = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    change(matrix1, i, j);
                    replaceCount++;
                }
            }

            for (int j = m - 2; j < m; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return -1;
                }
            }
        }

        return isDifferent(matrix1, matrix2, n - 2, 0) ? -1 : replaceCount;
    }

    private static boolean isDifferent(boolean[][] matrix1, boolean[][] matrix2, int x, int y) {
        for (int i = x; i < matrix1.length; i++) {
            for (int j = y; j < matrix1[i].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return true;
                }
            }
        }

        return false;
    }

    private static void change(boolean[][] matrix, int x, int y) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[x + i][y + j] = !matrix[x + i][y + j];
            }
        }

    }

}

