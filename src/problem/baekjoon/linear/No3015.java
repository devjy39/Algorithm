package problem.baekjoon.linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No3015 {
    static class NumberCount {
        int number;
        int count;

        public NumberCount(int number) {
            this.number = number;
            this.count = 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        long result = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            if (max < number) {
                result += getPopStackResult(stack, number);
                max = number;
            }
            stack.push(number);
        }

        System.out.println(result + getPopStackResult(stack, stack.pop()));
    }

    private static long getPopStackResult(Stack<Integer> outStack, int right) {
        long result = 0;
        Stack<NumberCount> inStack = new Stack<>();
        inStack.push(new NumberCount(right));

        while (!outStack.isEmpty()) { // 모든 수가 right 보다 작으니 다 뺀다.
            int left = outStack.pop(); // left 가 왼쪽 수 일 때 모든 페어 계산
            while (!inStack.isEmpty() && left > inStack.peek().number) {
                result += inStack.pop().count;
            }

            if (!inStack.isEmpty() && left == inStack.peek().number) {  // 같은 수가 있다면
                result += inStack.peek().count++ +(inStack.size() > 1 ? 1 : 0); // size check -> 맨 끝 수는 커도 포함이기 때문, 같은 수가 많을 수도 있기 때문에 객체로 카운트
            } else {
                if (!inStack.isEmpty()) {
                    result++;
                }
                inStack.push(new NumberCount(left)); // inStack 은 단조감소하는 형태가 된다.
            }
        }

        return result;
    }

}