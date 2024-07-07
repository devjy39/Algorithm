package problem.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No9205 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distance(Point point) {
            return Math.abs(x - point.x) + Math.abs(y - point.y);
        }
    }
    static final String SUCCESS = "happy\n", FAIL = "sad\n";
    static final int MOVE = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine()); // 편의점
            Point house = getPoint(br);
            List<Point> stores = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                stores.add(getPoint(br));
            }
            Point destination = getPoint(br);

            result.append(isArrival(house, stores, destination) ? SUCCESS : FAIL);
        }

        System.out.print(result);
    }

    private static boolean isArrival(Point house, List<Point> stores, Point destination) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(house);

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if (cur.distance(destination) <= MOVE) {
                return true;
            }

            for (int j = 0; j < stores.size(); j++) {
                if (stores.get(j).distance(cur) <= MOVE) {
                    queue.add(stores.remove(j));
                }
            }
        }

        return false;
    }

    private static Point getPoint(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        return new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

}

