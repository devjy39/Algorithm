package problem.baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No12100 {
    static class Game2048 {
        int[][] originMap;
        int n;
        int maxScore;
        int[][] map;

        public Game2048(int[][] map) {
            this.originMap = map;
            this.n = map.length;
        }

        public int getMaxScore(int moveCount) {
            int[] arr = new int[moveCount];
            map = new int[n][n];
            cases(arr, 0);

            return maxScore;
        }

        private void cases(int[] arr, int depth) {
            if (depth >= arr.length) {
                maxScore = Math.max(maxScore, play(arr));
                return;
            }

            for (int i = 0; i < 4; i++) {
                arr[depth] = i;
                cases(arr, depth + 1);
            }
        }

        private int play(int[] moves) {
            initMap();
            // move 시나리오 대로 플레이
            for (int move : moves) {
                switch (move) {
                    case 0: // 상
                        moveVertical(1);
                        break;
                    case 1: // 하
                        moveVertical(-1);
                        break;
                    case 2: // 좌
                        moveHorizon(1);
                        break;
                    default: // 우
                        moveHorizon(-1);
                }

            }

            return getMaxScore(map);
        }

        private int getMaxScore(int[][] map) {
            int maxPoint = 0;

            for (int[] points : map) {
                for (int point : points) {
                    maxPoint = Math.max(maxPoint, point);
                }
            }

            return maxPoint;
        }

        private void moveHorizon(int dir) {
            int initValue = dir > 0 ? 0 : n - 1;
            int cond = dir > 0 ? n : -1;

            for (int i = 0; i < n; i++) {
                int col = initValue;
                int number = 0;

                for (int c = initValue; c != cond; c += dir) {
                    if (map[i][c] == 0) {
                        continue;
                    }

                    if (number == 0) {
                        number = map[i][c];
                    } else if (map[i][c] == number) {
                        map[i][col] = number * 2;
                        col += dir;
                        number = 0;
                    } else {
                        map[i][col] = number;
                        col += dir;
                        number = map[i][c];
                    }
                }

                if (number != 0) {
                    map[i][col] = number;
                    col += dir;
                }

                while (col != cond) {
                    map[i][col] = 0;
                    col += dir;
                }
            }
        }

        private void moveVertical(int dir) {
            int initValue = dir > 0 ? 0 : n - 1;
            int cond = dir > 0 ? n : -1;

            for (int i = 0; i < n; i++) {
                int row = initValue;
                int number = 0;

                for (int r = initValue; r != cond; r += dir) {
                    if (map[r][i] == 0) {
                        continue;
                    }

                    if (number == 0) {
                        number = map[r][i];
                    } else if (map[r][i] == number) {
                        map[row][i] = number * 2;
                        row += dir;
                        number = 0;
                    } else {
                        map[row][i] = number;
                        row += dir;
                        number = map[r][i];
                    }
                }

                if (number != 0) {
                    map[row][i] = number;
                    row += dir;
                }

                while (row != cond) {
                    map[row][i] = 0;
                    row += dir;
                }
            }
        }

        private void initMap() {
            for (int i = 0; i < n; i++) {
                System.arraycopy(originMap[i], 0, map[i], 0, n);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(new Game2048(map).getMaxScore(5));
    }

}

