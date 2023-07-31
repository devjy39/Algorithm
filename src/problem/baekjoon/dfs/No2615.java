package problem.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2615 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[19][19];

        for (int i = 0; i < map.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        getWinner(map);
    }

    private static void getWinner(int[][] map) {
        int[][][] visited = new int[19][19][4];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                for (int dir = 0; dir < 3; dir++) {
                    if (map[i][j] > 0 && visited[i][j][dir] == 0) {
                        if (dfs(map, visited, dir, i, j) == 5) {
                            System.out.println(map[i][j] + "\n" + (i + 1) + " " + (j + 1));
                            return;
                        }
                    }
                }
            }
        }


        // 위로 대각선 처리
        for (int i = map.length - 1; i >= 0; i--) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] > 0 && visited[i][j][3] == 0) {
                    if (dfs(map, visited, 3, i, j) == 5) {
                        System.out.println(map[i][j] + "\n" + (i + 1) + " " + (j + 1));
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }

    private static int dfs(int[][] map, int[][][] visited, int dir, int x, int y) {
        if (visited[x][y][dir] > 0) {
            return visited[x][y][dir];
        }

        switch (dir) {
            case 0: // 아래
                if (x + 1 < map.length && map[x + 1][y] == map[x][y]) {
                    return visited[x][y][dir] = dfs(map, visited, dir, x + 1, y) + 1;
                }
                break;
            case 1: // 아래대각선
                if (x + 1 < map.length && y + 1 < map.length && map[x + 1][y + 1] == map[x][y]) {
                    return visited[x][y][dir] = dfs(map, visited, dir, x + 1, y + 1) + 1;
                }
                break;
            case 2: // 우로
                if (y + 1 < map.length && map[x][y + 1] == map[x][y]) {
                    return visited[x][y][dir] = dfs(map, visited, dir, x, y + 1) + 1;
                }
                break;
            default: // 위 대각선
                if (x - 1 >= 0 && y + 1 < map.length && map[x - 1][y + 1] == map[x][y]) {
                    return visited[x][y][dir] = dfs(map, visited, dir, x - 1, y + 1) + 1;
                }
        }

        return visited[x][y][dir] = 1;
    }


}
