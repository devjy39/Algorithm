package dataStructure.nonLinear.prioritryQueue.practice;
// Practice4
// 문자열 s 가 주어졌을 때, 문자열 내에 동일한 알파벳이 연속적으로 배치되지 않도록 재배치 하세요.
// 재배치가 가능한 경우 재정렬한 문자열을 반환하고 불가능한 경우 null 을 반환하세요.

// 입출력 예시
// 입력: "aabb"
// 출력: "abab"

// 입력: "aaca"
// 출력: null


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Practice4 {
    public static String solution(String s) {
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>(
                (m1, m2) -> m2.getValue() - m1.getValue());
        HashMap<String, Integer> map = new HashMap<>();
        for (String s1 : s.split("")) {
            map.put(s1, map.getOrDefault(s1, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            priorityQueue.add(entry);
        }
        StringBuilder result = new StringBuilder();

        Map.Entry<String, Integer> prev = null;

        while (!priorityQueue.isEmpty()) {
            Map.Entry<String, Integer> cur = priorityQueue.poll();

            if (prev!=null &&prev.getValue() > 0) {
                priorityQueue.add(prev);
            }

            result.append(cur.getKey());
            cur.setValue(cur.getValue() - 1);

            prev = cur;
        }


        return prev.getValue() > 0 ? null : result.toString();
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution("aabb"));
        System.out.println(solution("aaaaabccd"));
        System.out.println(solution("aaca"));
    }
}