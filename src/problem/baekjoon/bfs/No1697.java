package problem.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1697 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        br.close();

        if (n >= k) {
            System.out.println(n - k);
        } else {
            System.out.println(bfs(n, k));
        }
    }

    private static int bfs(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[k * 2];

        queue.add(n);
        visited[n] = true;

        for (int i = 1; i <= k; i++) {
            Queue<Integer> next = new LinkedList<>();
            while (!queue.isEmpty()) {
                int cur = queue.poll();

                if (checkNext(visited, cur - 1, k, next)) {
                    return i;
                }

                if (checkNext(visited, cur + 1, k, next)) {
                    return i;
                }

                if (checkNext(visited, cur * 2, k, next)) {
                    return i;
                }
            }
            queue = next;
        }

        return -1;
    }

    private static boolean checkNext(boolean[] visited, int cur, int k, Queue<Integer> next) {
        if (cur < 0 || cur >= visited.length) {
            return false;
        } else if (cur == k) {
            return true;
        }

        if (!visited[cur]) {
            visited[cur] = true;
            next.add(cur);
        }
        return false;
    }

}