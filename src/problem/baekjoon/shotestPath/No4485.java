package problem.baekjoon.shotestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No4485 {
    static class Zelda {
        int x;
        int y;
        int price;

        public Zelda(int x, int y, int price) {
            this.x = x;
            this.y = y;
            this.price = price;
        }
    }

    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder result = new StringBuilder();
        String read;
        int problem = 1;
        while (!(read = br.readLine()).equals("0")) {
            int n = Integer.parseInt(read);
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result.append("Problem ").append(problem++).append(": ").append(getMinPrice(map, n)).append("\n");
        }

        System.out.print(result);
    }

    private static int getMinPrice(int[][] map, int n) {
        PriorityQueue<Zelda> pq = new PriorityQueue<>((z1, z2) -> z1.price - z2.price);
        pq.add(new Zelda(0, 0, map[0][0]));
        int[][] visitedPrices = new int[n][n];
        for (int[] visitedPrice : visitedPrices) {
            Arrays.fill(visitedPrice, Integer.MAX_VALUE);
        }
        visitedPrices[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            Zelda cur = pq.poll();
            if (cur.x == n - 1 && cur.y == n - 1) {
                return cur.price;
            }

            for (int[] dir : dirs) {
                int x = dir[0] + cur.x;
                int y = dir[1] + cur.y;
                if (x < 0 || y < 0 || x >= n || y >= n) {
                    continue;
                }

                int price = cur.price + map[x][y];
                if (price < visitedPrices[x][y]) {
                    pq.add(new Zelda(x, y, price));
                    visitedPrices[x][y] = price;
                }
            }

        }

        return -1;
    }

}

