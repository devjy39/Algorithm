package problem.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(findCnt(Integer.parseInt(br.readLine())));
        br.close();
    }

    static int findCnt(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i < n; i++) {
            Queue<Integer> next = new LinkedList<>();

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                for (int j = 2; j <= 3; j++) {
                    if (cur % j == 0) {
                        int value = cur / j;
                        if (!visited[value]) {
                            if (value == 1) {
                                return i;
                            }

                            visited[value] = true;
                            next.add(value);
                        }
                    }
                }
                int value = cur - 1;
                if (value == 0) {
                    return i;
                } else if (!visited[value]) {
                    next.add(value);
                }
            }
            queue = next;
        }

        return 0;
    }
}