package problem.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No3109 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        boolean[][] isHouse = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                isHouse[i][j] = str.charAt(j) == 'x';
            }
        }

        int count = 0;
        for (int i = 0; i < r; i++) {
            if (dfs(isHouse, r - 1, c - 1, i, 0)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean dfs(boolean[][] isHouse, int r, int c, int row, int col) {
        if (col == c) {
            return true;
        }
        isHouse[row][col] = true;

        if (row > 0 && !isHouse[row - 1][col + 1]) {
            if (dfs(isHouse, r, c, row - 1, col + 1)) {
                return true;
            }
        }

        if (!isHouse[row][col + 1] && dfs(isHouse, r, c, row, col + 1)) {
            return true;
        }

        return row < r && !isHouse[row + 1][col + 1] && dfs(isHouse, r, c, row + 1, col + 1);
    }

}

