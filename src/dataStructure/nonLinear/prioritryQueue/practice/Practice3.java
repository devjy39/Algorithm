package dataStructure.nonLinear.prioritryQueue.practice;
// Practice3
// nums 배열에 주어진 정수들 중에서 가장 많이 발생한 숫자들 순으로 k 번째 까지 출력하세요.
// 빈도가 같은 경우에는 값이 작은 숫자가 먼저 출력되도록 구현하세요.

// 입출력 예시
// 입력: 1, 1, 1, 2, 2, 3
// k: 2
// 출력: 1, 2

// 입력: 3, 1, 5, 5, 3, 3, 1, 2, 2, 1, 3
// k: 3
// 출력: 3, 1, 2


import java.util.*;

public class Practice3 {
    public static void solution1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(
                (e1, e2) -> e2.getValue() == e1.getValue() ? e1.getKey() - e2.getKey() : e2.getValue() - e1.getValue());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.add(entry);
        }

        for (int i = 0; i < k; i++) {
            System.out.print(priorityQueue.poll().getKey()+" ");
        }
        System.out.println();
    }

    public static void solution2(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort((Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2) -> m2.getValue() - m1.getValue());

        for (int i = 0; i < k; i++) {
            System.out.print(list.get(i).getKey()+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {1, 1, 1, 2, 2, 3};
        solution1(nums, 2);
        solution2(nums, 2);
        System.out.println();

        nums = new int[]{3, 1, 4, 4, 3, 3, 1, 2, 2, 1, 3};
        solution1(nums, 3);
        solution2(nums, 3);
    }
}
