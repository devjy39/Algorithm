package dataStructure.linear.stack;

import java.util.Stack;

public class StackPractice {
    public static void main(String[] args) {

        System.out.println(solution("2 2 +"));
        System.out.println(solution("2 2 -"));
        System.out.println(solution("2 2 *"));
        System.out.println(solution("2 2 /"));
        System.out.println(solution("1 1 + 2 * 3 * 2 / 5 -"));//1
        System.out.println(solution("5 2 * 3 - 8 * 4 /"));//14
        
    }

    private static int solution(String s) {
        Stack<Integer> stack = new Stack<>();

        for (String str : s.split(" ")) {
            char i = str.charAt(0);
            switch (i) {
                case '+':
                    stack.add(stack.pop()+stack.pop());
                    break;
                case '-':
                    stack.add(-stack.pop()+stack.pop());
                    break;
                case '*':
                    stack.add(stack.pop()*stack.pop());
                    break;
                case '/':
                    stack.add((int) ((float)1/stack.pop()*stack.pop()));
                    break;
                default:
                    stack.add(i - '0');
            }
        }
        return stack.pop();
    }
}