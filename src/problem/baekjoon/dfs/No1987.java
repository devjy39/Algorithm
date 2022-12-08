package problem.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1987 {

    static int[][] map;
    static int r,c;
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        visited = new int[r][c];

        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = row.charAt(j) - 'A';
            }
        }

        System.out.println(dfs(0, 0, 0));
    }

    private static int dfs(int row, int col, int bits) {
        bits |= 1 << map[row][col];

        if (visited[row][col] == bits) { // 중복 bit 제거, backtracking
            return 0;
        }
        visited[row][col] = bits;
        int count = 0;

        for (int[] dir : dirs) {
            int x = row + dir[0];
            int y = col + dir[1];

            if (x < 0 || y < 0 || x >= r || y >= c || ((1 << map[x][y]) & bits) != 0 ) { // and 시 겹치는 부분이 있는가?
                continue;
            }

            count = Math.max(count, dfs(x, y, bits));
        }

        return count + 1;
    }

}