package dataStructure.nonLinear.NonLinearDS_13_3.src;

import java.util.*;

public class Practice3 {

    public static ArrayList<Integer> solution(int k, int[][] customers) {
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> usingCounter = new PriorityQueue<>(
                (x, y) -> x[1] == y[1] ? y[2] - x[2] : x[1] - y[1]);
        PriorityQueue<Integer> emptyCounter = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            emptyCounter.add(i);
        }

        int curTime = 0; // 공용시간을 사용해서 for(O(k))문 하나 줄이는 아이디어
        for (int[] customer : customers) {
            if (emptyCounter.isEmpty()) {
                System.out.println(usingCounter.peek()[1]+" cur->"+ curTime);
                curTime = Math.max(usingCounter.peek()[1], curTime);
                while (!usingCounter.isEmpty() && usingCounter.peek()[1] <= curTime) {
                    int[] out = usingCounter.poll();
                    result.add(out[0]);
                    emptyCounter.add(out[2]);
                }
            }
            usingCounter.add(new int[]{customer[0], customer[1] + curTime, emptyCounter.poll()});
        }

        while (!usingCounter.isEmpty()) {
            result.add(usingCounter.poll()[0]);
        }

        return result;
    }

    public static void main(String[] args) {
        // Test code
        int[][] customers = {{1, 4}, {2, 5}, {3, 14}, {4, 1}, {5, 7}, {6, 5}, {7, 7}, {8, 5}, {9, 10}, {10, 3}};
        System.out.println(solution(3, customers));
    }
}
