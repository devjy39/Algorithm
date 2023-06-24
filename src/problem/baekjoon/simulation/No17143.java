package problem.baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No17143 {
    static class Shark {
        int r;
        int c;
        int move;
        boolean isVertical;
        int size;

        public Shark(int r, int c, int speed, int direction, int size, int n, int m) {
            this.r = r;
            this.c = c;
            this.move = speed;
            this.isVertical = direction == 1 || direction == 2;
            if (isVertical) {
                move %= 2 * (n - 1);
            } else {
                move %= 2 * (m - 1);
            }
            this.move = (direction == 2 || direction == 3) ? move : -move;
            this.size = size;
        }

        public void move(int n, int m) {
            if (isVertical) { // 위 아래
                r = movePoint(r, n);
            } else {
                c = movePoint(c, m);
            }

        }

        private int movePoint(int p, int n) {
            p += move;

            if (p < 0) {
                p *= -1;
                if (p >= n) {
                    p = 2 * (n - 1) - p;
                } else {
                    move *= -1;
                }
            } else if (p >= n) {
                p = 2 * (n - 1) - p;
                if (p < 0) {
                    p *= -1;
                } else {
                    move *= -1;
                }
            }

            return p;
        }

    }

    static class SharkFishing {
        Shark[] sharks;
        int n;
        int m;
        Shark[][] map;
        Shark[][] newMap;

        public SharkFishing(Shark[] sharks, int n, int m) {
            this.sharks = sharks;
            this.n = n;
            this.m = m;
            this.map = new Shark[n][m];
            this.newMap = new Shark[n][m];
            for (Shark shark : sharks) {
                map[shark.r][shark.c] = shark;
            }
        }

        int getFishingSharkSize() {
            int totalShakeSize = 0;

            for (int i = 0; i < m; i++) {
                totalShakeSize += huntShark(i);
                moveShark();
            }

            return totalShakeSize;
        }

        private void moveShark() {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == null) {
                        continue;
                    }

                    Shark shark = map[i][j];
                    shark.move(n, m);

                    if (newMap[shark.r][shark.c] != null) {
                        shark = newMap[shark.r][shark.c].size > shark.size ? newMap[shark.r][shark.c] : shark;
                    }
                    newMap[shark.r][shark.c] = shark;
                }
            }

            makeNewMap();
        }

        private void makeNewMap() {
            Shark[][] temp = map;
            map = newMap;
            newMap = temp;

            for (Shark[] value : newMap) {
                Arrays.fill(value, null);
            }
        }

        private int huntShark(int col) {
            int size = 0;
            for (int i = 0; i < n; i++) {
                if (map[i][col] != null) {
                    size = map[i][col].size;
                    map[i][col] = null;
                    break;
                }
            }

            return size;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Shark[] sharks = new Shark[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            sharks[i] = new Shark(x, y, s, d, z, r, c);
        }

        System.out.println(new SharkFishing(sharks, r, c).getFishingSharkSize());
    }

}

