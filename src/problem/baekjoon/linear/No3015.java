package problem.baekjoon.linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No3015 {
    static class Pair {
        int height;
        int count;

        public Pair(int height) {
            this.height = height;
            this.count = 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Pair> stack = new Stack<>();
        long pairs = 0;

        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(br.readLine());
            while (!stack.isEmpty() && stack.peek().height < height) {
                pairs += getSum(stack.pop().count); // 같은 수일 경우 1 ~ 개수 합
            }

            if (!stack.isEmpty() && stack.peek().height == height) {
                stack.peek().count++; // 같은 수 묶기 (최적화)
            } else {
                stack.push(new Pair(height));
            }

            if (stack.size() > 1) { // 왼쪽에 더 큰 수가 존재하면 height와 쌍
                pairs++;
            }
        }

        while (!stack.isEmpty()) { // 단조감소만 남은 스택
            pairs += getSum(stack.pop().count - 1);
        }

        System.out.println(pairs);
    }

    private static long getSum(int count) {
        return (long) count * (count + 1) >> 1;
    }

}