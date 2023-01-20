package problem.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No13913 {
    static class Point {
        int point;
        Point prev;

        public Point(int point) {
            this.point = point;
        }

        public Point(int point, Point prev) {
            this.point = point;
            this.prev = prev;
        }
    }

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/data.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        StringBuilder result = new StringBuilder();

        if (k <= n) {
            result.append(n - k).append("\n");
            for (int i = n; i >= k; i--) {
                result.append(i).append(" ");
            }
        } else {
            List<Integer> list = new ArrayList<>();
            Point bfs = bfs(n, k);
            while (bfs != null) {
                list.add(bfs.point);
                bfs = bfs.prev;
            }

            result.append(list.size() - 1).append("\n");
            for (int i = list.size() - 1; i >= 0; i--) {
                result.append(list.get(i)).append(" ");
            }
        }

        System.out.println(result);
    }

    static int MAX = 100_000;

    private static Point bfs(int n, int k) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(n));
        boolean[] visited = new boolean[MAX + 1];
        visited[n] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            visited[cur.point] = true;
            if (cur.point == k) {
                return cur;
            }

            if (cur.point < MAX && !visited[cur.point + 1]) {
                queue.add(new Point(cur.point + 1, cur));
            }

            if (cur.point > 0 && !visited[cur.point - 1]) {
                queue.add(new Point(cur.point - 1, cur));
            }

            if (cur.point * 2 <= MAX && !visited[cur.point * 2]) {
                queue.add(new Point(cur.point * 2, cur));
            }
        }

        return null;
    }

}