package dataStructure.linear.PracticeProblem.LinearDS_14_2;

import java.util.*;
import java.util.stream.IntStream;

public class Practice1 {
    public static void solution(int docs, int target, int[] priority) {
        Queue<Integer> queue = new LinkedList<>();
        IntStream.range(0, priority.length).forEach(i -> queue.add(i));
        Stack<Integer> stack = new Stack<>();
        //오름차순 순 대로 제거할 때 스택을 사용하는 아이디어 (mine)
        Arrays.stream(priority).sorted().forEach(i -> stack.add(i));
        int cnt = 0;

        while (!queue.isEmpty()) {
            int index = queue.poll();
            if (priority[index] == stack.peek()) {
                cnt++;
                stack.pop();
                if (index == target) {
                    System.out.println("answer = "+cnt);
                    return;
                }
            } else {
                queue.add(index);
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        int docs = 1;
        int target = 0;
        int[] priority = {5};
        solution(docs, target, priority);

        docs = 4;
        target = 2;
        priority = new int[]{1, 2, 3, 4};
        solution(docs, target, priority);

        docs = 6;
        target = 0;
        priority = new int[]{1, 1, 9, 1, 1, 1};
        solution(docs, target, priority);
    }
}
