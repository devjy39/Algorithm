package problem.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class No1655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        PriorityQueue<Integer> lowQueue = new PriorityQueue<>((x, y) -> y - x);
        PriorityQueue<Integer> highQueue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            if (lowQueue.isEmpty() || number <= lowQueue.peek()) {
                lowQueue.add(number);
                if (lowQueue.size() > highQueue.size() + 1) {
                    highQueue.add(lowQueue.poll());
                }
            } else {
                highQueue.add(number);
                if (lowQueue.size() < highQueue.size()) {
                    lowQueue.add(highQueue.poll());
                }
            }

            result.append(lowQueue.peek()).append("\n");
        }

        System.out.print(result);
    }

}