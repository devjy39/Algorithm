package problem.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No9019 {
    static class Register {
        int number;
        String str;

        public Register(int number, String str) {
            this.number = number;
            this.str = str;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            sb.append(bfs(num, target)).append("\n");
        }

        System.out.println(sb);
    }

    private static String bfs(int num, int target) {
        // D : 2배 % 10000
        // S : -1 , -1 -> 9999
        // L : left rotate
        // R : right rotate

        boolean[] visited = new boolean[10000];
        visited[num] = true;

        Queue<Register> queue = new LinkedList<>();
        queue.add(new Register(num, ""));

        while (!queue.isEmpty()) {
            Register cur = queue.poll();

            if (addQueue((cur.number * 2) % 10000, visited, cur, "D", target, queue)) {
                return cur.str + "D";
            }

            if (addQueue(cur.number == 0 ? 9999 : cur.number - 1, visited, cur, "S", target, queue)) {
                return cur.str + "S";
            }

            if (addQueue((cur.number / 10) + (1000 * (cur.number % 10)), visited, cur, "R", target, queue)) {
                return cur.str + "R";
            }

            if (addQueue((cur.number * 10 % 10000) + (cur.number / 1000), visited, cur, "L", target, queue)) {
                return cur.str + "L";
            }
        }

        return "";
    }

    private static boolean addQueue(int num, boolean[] visited, Register cur, String command, int target, Queue<Register> queue) {
        if (num == target) {
            return true;
        }
        if (!visited[num]) {
            visited[num] = true;
            queue.add(new Register(num, cur.str + command));
        }

        return false;
    }

}