package problem.baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No14499 {
    static class Dice {
        int x;
        int y;
        int[][] map;
        static int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        List<Integer> horizontal = new ArrayList<>(List.of(0, 0, 0, 0));
        List<Integer> vertical = new ArrayList<>(List.of(0, 0, 0, 0));

        public Dice(int x, int y, int[][] map) {
            this.x = x;
            this.y = y;
            this.map = map;
        }

        public boolean move(int command) {
            int moveX = x + dirs[command][0];
            int moveY = y + dirs[command][1];

            if (moveX < 0 || moveY < 0 || moveX >= map.length || moveY >= map[0].length) {
                return false;
            }
            x = moveX;
            y = moveY;

            switch (command) {
                case 0:
                    moveDice(horizontal, vertical, -1);
                    break;
                case 1:
                    moveDice(horizontal, vertical, 1);
                    break;
                case 2:
                    moveDice(vertical, horizontal, -1);
                    break;
                case 3:
                    moveDice(vertical, horizontal, 1);
            }

            if (map[x][y] == 0) {
                map[x][y] = horizontal.get(0);
            } else {
                horizontal.set(0, map[x][y]);
                vertical.set(0, map[x][y]);
                map[x][y] = 0;
            }
            return true;
        }

        private void moveDice(List<Integer> moveLine, List<Integer> oppositeLine, int dir) {
            Collections.rotate(moveLine, dir);
            oppositeLine.set(0, moveLine.get(0));
            oppositeLine.set(2, moveLine.get(2));
        }

        public int getTop() {
            return horizontal.get(2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Dice dice = new Dice(x, y, map);
        StringBuilder result = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int command = Integer.parseInt(st.nextToken());
            if (dice.move(command - 1)) { // 이동가능
                result.append(dice.getTop()).append("\n");
            }
        }

        System.out.print(result);
    }

}
