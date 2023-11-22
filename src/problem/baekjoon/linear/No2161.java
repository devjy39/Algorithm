package problem.baekjoon.linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class No2161 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new ArrayDeque<>(n);
        queue.add(n);
        for (int i = 1; i < n; i++) {
            queue.add(i);
        }

        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {
            queue.add(queue.poll());
            result.append(queue.poll()).append(' ');
        }

        System.out.println(result);
    }

}
