package problem.baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No3085 {
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] map = new char[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        System.out.println(getMaxCount(map, n));
    }

    private static int getMaxCount(char[][] map, int n) {
        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxCount = Math.max(maxCount, getCount(map, n, i, j));
            }
        }

        return maxCount;
    }

    private static int getCount(char[][] map, int n, int i, int j) {
        int maxCount = getEqualColor(map, n, i, j);

        for (int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;

            if (x < 0 || y < 0 || x >= n || y >= n || map[x][y] == map[i][j]) {
                continue;
            }

            char origin = map[i][j];
            char change = map[x][y];
            map[x][y] = origin;
            map[i][j] = change;
            maxCount = Math.max(maxCount, getEqualColor(map, n, i, j));
            map[i][j] = origin;
            map[x][y] = change;
        }

        return maxCount;
    }

    private static int getEqualColor(char[][] map, int n, int x, int y) {
        int count = 1;

        for (int row = x - 1; row >= 0; row--) {
            if (map[row][y] == map[x][y]) {
                count++;
            } else {
                break;
            }
        }
        for (int row = x + 1; row < n; row++) {
            if (map[row][y] == map[x][y]) {
                count++;
            } else {
                break;
            }
        }

        int maxCount = count;
        count = 1;

        for (int col = y - 1; col >= 0; col--) {
            if (map[x][col] == map[x][y]) {
                count++;
            } else {
                break;
            }
        }

        for (int col = y + 1; col < n; col++) {
            if (map[x][col] == map[x][y]) {
                count++;
            } else {
                break;
            }
        }

        return Math.max(maxCount, count);
    }

}

