package problem.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No16928 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> up = new HashMap<>();
        Map<Integer, Integer> down = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            up.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            down.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        br.close();

        System.out.println(bfs(up, down));
    }

    private static int bfs(Map<Integer, Integer> up, Map<Integer, Integer> down) {
        boolean[] visited = new boolean[100];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        for (int i = 1; i <= 100; i++) {
            Queue<Integer> next = new LinkedList<>();

            while (!queue.isEmpty()) {
                Integer cur = queue.poll();

                for (int j = 1; j <= 6; j++) {
                    int move = cur + j;
                    if (up.containsKey(move)) {
                        addIfNotVisit(visited, up.get(move), next);
                    } else if (down.containsKey(move)) {
                        addIfNotVisit(visited, down.get(move), next);
                    } else {
                        if (move >= 100) {
                            return i;
                        }
                        addIfNotVisit(visited, move, next);
                    }
                }

            }
            queue = next;
        }

        return -1;
    }

    private static void addIfNotVisit(boolean[] visited, int move, Queue<Integer> next) {
        if (!visited[move]) {
            next.add(move);
            visited[move] = true;
        }
    }
}