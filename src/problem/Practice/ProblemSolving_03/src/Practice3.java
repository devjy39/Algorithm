package problem.Practice.ProblemSolving_03.src;

import java.util.PriorityQueue;

public class Practice3 {
    public static int solution(int[] stones, int maxJump) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < stones.length; i++) {
            if (pq.size() < maxJump) {
                pq.add(stones[i]);
            } else {
                pq.add(Math.min(pq.peek(), stones[i]));
                pq.remove(stones[i - maxJump]);
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        // Test code
        int[] stones = {1, 1, 2, 1, 1};
        System.out.println(solution(stones, 3));

        stones = new int[] {1, 2, 5, 3, 2, 2, 4, 2, 4, 3};
        System.out.println(solution(stones, 3));
    }
}
