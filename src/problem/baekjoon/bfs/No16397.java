package problem.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No16397 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        System.out.println(getMinButtonCount(n, t, target));
    }

    static final int MAX_NUMBER = 99_999, MAX_HALF = 50_000, MAX_DIV = 10_000;

    private static String getMinButtonCount(int n, int t, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int[] visited = new int[MAX_NUMBER + 1];
        visited[n] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (visited[current] > t) {
                break;
            }

            if (current < MAX_NUMBER && visited[current + 1] == 0) {
                queue.add(current + 1);
                visited[current + 1] = visited[current] + 1;
            }

            if (current != 0 && current < MAX_HALF) {
                int B = getB(current);
                if (visited[B] == 0) {
                    visited[B] = visited[current] + 1;
                    queue.add(B);
                }
            }

            if (visited[target] > 0) {
                return String.valueOf(visited[target] - 1);
            }
        }

        return "ANG";
    }

    private static int getB(int current) {
        current *= 2;
        int div = MAX_DIV;

        for (int i = 0; i < 5; i++) {
            if (current >= div) {
                break;
            }
            div /= 10;
        }

        return current - div;
    }

}


