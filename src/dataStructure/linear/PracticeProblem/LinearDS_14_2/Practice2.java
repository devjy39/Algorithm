package dataStructure.linear.PracticeProblem.LinearDS_14_2;

import java.util.Stack;

public class Practice2 {
    public static void solution(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int cnt = 1;
        boolean answer = true;

        for (int num : nums) {
            while (cnt <= num) {
                stack.push(cnt++);
                System.out.print("+");
            }
            if (stack.peek() == num) {
                stack.pop();
                System.out.print("-");
            } else {
                answer = false;
                break;
            }
        }

        System.out.println("\n"+answer);
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 6, 8, 7, 5, 2, 1};
        solution(nums);

        System.out.println("=====");
        nums = new int[]{1, 2, 5, 3, 4};
        solution(nums);
    }
}
