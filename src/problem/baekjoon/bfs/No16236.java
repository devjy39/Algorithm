package problem.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No16236 {
    static int[][] map;
    static int n;
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static class Fish {
        int x;
        int y;
        int level;
        int huntingNumber;

        public Fish(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }

        public void Consume(Fish fish) {
            this.x = fish.x;
            this.y = fish.y;
            this.huntingNumber++;

            if (huntingNumber == level) {
                huntingNumber = 0;
                level++;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        Fish jaws = null;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    jaws = new Fish(i, j, 2);
                }
            }
        }

        int answer = 0;

        while (true) {
            List<Fish> huntingFishes = new ArrayList<>();
            answer += bfs(jaws, huntingFishes);

            if (huntingFishes.size() == 0) {
                break;
            } else if (huntingFishes.size() > 1) {
                huntingFishes.sort((f1, f2) -> f1.x == f2.x ? f1.y - f2.y : f1.x - f2.x);
            }

            map[jaws.x][jaws.y] = 0;
            jaws.Consume(huntingFishes.get(0));
        }

        System.out.println(answer);
    }

    /*  가장 가까운 위치 먹이들 반환
     * */
    private static int bfs(Fish jaws, List<Fish> result) {
        boolean[][] visited = new boolean[n][n];
        Queue<Fish> queue = new LinkedList<>();
        queue.add(jaws);
        visited[jaws.x][jaws.y] = true;

        for (int i = 1; !queue.isEmpty(); i++) {
            Queue<Fish> next = new LinkedList<>();
            boolean hunting = false;

            while (!queue.isEmpty()) {
                Fish cur = queue.poll();

                for (int[] dir : dirs) {
                    int x = dir[0] + cur.x;
                    int y = dir[1] + cur.y;

                    if (x < 0 || y < 0 || x >= n || y >= n || visited[x][y] || map[x][y] > jaws.level) {
                        continue;
                    }

                    Fish fish = new Fish(x, y, map[x][y]);
                    if (map[x][y] != 0 && map[x][y] < jaws.level) {
                        hunting = true;
                        result.add(fish);
                    }

                    visited[x][y] = true;
                    next.add(fish);
                }
            }

            if (hunting) {
                return i;
            }

            queue = next;
        }

        return 0;
    }

}