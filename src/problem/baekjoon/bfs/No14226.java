package problem.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class No14226 {
    static class Emoji {
        int number;
        int clipboard;

        public Emoji(int number, int clipboard) {
            this.number = number;
            this.clipboard = clipboard;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(bfs(n));
    }

    private static int bfs(int n) {
        Queue<Emoji> queue = new ArrayDeque<>();
        queue.add(new Emoji(1, 0));
        boolean[][] visited = new boolean[n*2][n*2];
        visited[1][0] = true;
        int move = 0;

        loop:
        while (!queue.isEmpty()) {
            Queue<Emoji> next = new ArrayDeque<>();
            move++;

            while (!queue.isEmpty()) {
                Emoji cur = queue.poll();

                if (cur.number < n) {
                    if (!visited[cur.number + cur.clipboard][cur.clipboard]) {
                        int newNumber = cur.number + cur.clipboard;
                        next.add(new Emoji(newNumber, cur.clipboard));
                        visited[newNumber][cur.clipboard] = true;
                        if (newNumber == n) {
                            break loop;
                        }
                    }

                    if (cur.number != cur.clipboard && !visited[cur.number][cur.number]) {
                        next.add(new Emoji(cur.number, cur.number));
                        visited[cur.number][cur.number] = true;
                    }
                }

                if (cur.number > 1 && !visited[cur.number - 1][cur.clipboard]) {
                    next.add(new Emoji(cur.number - 1, cur.clipboard));
                    visited[cur.number - 1][cur.clipboard] = true;
                    if (cur.number - 1 == n) {
                        break loop;
                    }
                }
            }

            queue = next;
        }

        return move;
    }

}

