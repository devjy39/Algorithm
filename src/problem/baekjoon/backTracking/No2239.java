package problem.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No2239 {

    static boolean[][] checkX, checkY, checkZ;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[9][9];
        checkX = new boolean[9][10];
        checkY = new boolean[9][10];
        checkZ = new boolean[9][10];

        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = str.charAt(j) - '0';
                if (map[i][j] != 0) {
                    checkX[i][map[i][j]] = true;
                    checkY[j][map[i][j]] = true;
                    checkZ[getIndexZ(i, j)][map[i][j]] = true;
                }
            }
        }

        sudoku(map, 0, 0);
        System.out.print(getStringBuilder(map));
    }

    private static StringBuilder getStringBuilder(int[][] map) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                result.append(map[i][j]);
            }
            result.append('\n');
        }
        return result;
    }

    static int getIndexZ(int i, int j) {
        return (i / 3 * 3) + (j / 3);
    }

    private static boolean sudoku(int[][] map, int x, int y) {
        for (int i = x; i < 9; i++) {
            for (int j = x == i ? y : 0; j < 9; j++) {
                if (map[i][j] != 0) {
                    continue;
                }

                for (int k = 1; k <= 9; k++) {
                    if (check(i, j, k)) {
                        setValue(map, i, j, k, true);
                        if (sudoku(map, i, j + 1)) {
                            return true;
                        }
                        setValue(map, i, j, k, false);
                    }
                }
                return false;
            }
        }

        return true;
    }

    private static void setValue(int[][] map, int x, int y, int value, boolean isSet) {
        map[x][y] = isSet ? value : 0;
        checkX[x][value] = isSet;
        checkY[y][value] = isSet;
        checkZ[getIndexZ(x, y)][value] = isSet;
    }

    private static boolean check(int x, int y, int value) {
        return !checkX[x][value] && !checkY[y][value] && !checkZ[getIndexZ(x, y)][value];
    }

}