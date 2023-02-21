package problem.programmerse;

import java.util.LinkedList;
import java.util.Queue;

public class No118667 {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0, sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        for (int i : queue1) {
            q1.add(i);
            sum1 += i;
        }
        Queue<Integer> q2 = new LinkedList<>();
        for (int i : queue2) {
            q2.add(i);
            sum2 += i;
        }

        return getMinCount(queue1, sum1, sum2, q1, q2);
    }

    private int getMinCount(int[] queue1, long sum1, long sum2, Queue<Integer> q1, Queue<Integer> q2) {
        int maxCount = queue1.length * 3;
        int count = 0;
        while (count < maxCount) {
            if (sum1 < sum2) {
                sum1 += q2.peek();
                sum2 -= q2.peek();
                q1.add(q2.poll());
            } else if (sum1 > sum2) {
                sum2 += q1.peek();
                sum1 -= q1.peek();
                q2.add(q1.poll());
            } else {
                return count;
            }
            count++;
        }

        return -1;
    }
}