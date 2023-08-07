package problem.baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17406 {
    static class Map {
        int[][] map;
        int[][] origins;
        int n, m;

        public Map(int[][] map, int n, int m) {
            this.origins = map;
            this.map = new int[n][m];
            this.n = n;
            this.m = m;
        }

        private void initMap() {
            for (int i = 0; i < n; i++) {
                System.arraycopy(origins[i], 0, map[i], 0, m);
            }
        }

        public int minRowSum() {
            int minSum = Integer.MAX_VALUE;

            for (int[] ints : map) {

                int rowSum = 0;
                for (int anInt : ints) {
                    rowSum += anInt;
                }
                minSum = Math.min(minSum, rowSum);
            }

            return minSum;
        }

        static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        public void rotate(int r, int c, int s) {
            for (int i = 1; i <= s; i++) {
                int x = r - i;
                int y = c - i;
                int size = i << 1;
                int prev = map[x][y];

                for (int[] dir : dirs) {
                    for (int j = 0; j < size; j++) {
                        x += dir[0];
                        y += dir[1];

                        int temp = map[x][y];
                        map[x][y] = prev;
                        prev = temp;
                    }
                }
            }

        }

        public int startRotate(int[][] rotates, int[] arr) {
            initMap();

            for (int i : arr) {
                int[] rotate = rotates[i];
                rotate(rotate[0] - 1, rotate[1] - 1, rotate[2]);
            }

            return minRowSum();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] input = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        map = new Map(input, n, m);

        int[][] rotates = new int[k][3];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            rotates[i][0] = Integer.parseInt(st.nextToken());
            rotates[i][1] = Integer.parseInt(st.nextToken());
            rotates[i][2] = Integer.parseInt(st.nextToken());
        }

        dfs(rotates, new int[k], new boolean[k], 0);

        System.out.println(result);
    }

    static Map map;
    static int result = Integer.MAX_VALUE;

    private static void dfs(int[][] rotates, int[] arr, boolean[] visited, int depth) {
        if (depth >= rotates.length) {
            result = Math.min(result, map.startRotate(rotates, arr));
            return;
        }

        for (int i = 0; i < rotates.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                dfs(rotates, arr, visited, depth + 1);
                visited[i] = false;
            }
        }

    }
}

