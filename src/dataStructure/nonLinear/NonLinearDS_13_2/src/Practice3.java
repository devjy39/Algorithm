package dataStructure.nonLinear.NonLinearDS_13_2.src;

import java.util.PriorityQueue;

// (target -> {1,1,1} ) 거꾸로 가는 아이디어 (결국엔 dfs 바텀업이랑 같다.)..... 어렵다
public class Practice3 {
    public static boolean solution(int[] target) {
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        // max값을 매번 뽑아내야 됨 -> PriorityQueue 사용

        for (int i : target) {
            sum += i;
            pq.add(i);
        }


        while (pq.peek() != 1) {
            int maxValue = pq.poll();
            int diff = sum - maxValue;

            if (maxValue > diff) {
                pq.add(maxValue - diff);
                sum -= diff;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Test code
        int[] target = {9, 3, 5};
        System.out.println(solution(target));

        target = new int[]{8, 5};
        System.out.println(solution(target));

        target = new int[]{1, 1, 1, 2};
        System.out.println(solution(target));
    }
}
