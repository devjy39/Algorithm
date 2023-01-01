package problem.baekjoon.linear;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class No1725 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] height = new int[Integer.parseInt(br.readLine())];
        for (int i = 0; i < height.length; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }

        System.out.print(getMaxAreaByStack(height));
    }

    private static long getMaxAreaByStack(int[] height) {
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0L;

        for (int i = 0; i < height.length; i++) {

            // 스택에 단조 증가하는 높이만 남도록 감소하는 경우는 스택을 pop 하고 넓이계산
            while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
                int index = stack.pop();
                int minHeight = height[index];
                int length = stack.isEmpty() ? i : i - (stack.peek() + 1);
                // 스택이 빈 경우 여태까지중에 가장 작은 높이 이므로 길이는 인덱스가된다.
                // 스택이 존재하면 스택에 있는 높이 다음칸부터 ~ 현재 만난 칸 전까지가 현재 index에서 높이가 가장 큰 길이이다.

                maxArea = Math.max(maxArea, (long) minHeight * length);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) { // 단조 증가하는 높이만 스택에 남은 상태
            int index = stack.pop();
            int minHeight = height[index];
            int length = stack.isEmpty() ? height.length : height.length - (stack.peek() + 1);
            // 스택이 빈 경우 그 높이는 가장 작은 높이가 되므로 전체의길이가 너비가 된다.
            // 끝을 기준으로 가장 짧은 길이가 되므로 길이는 우측 끝부터 쟨다.

            maxArea = Math.max(maxArea, (long) minHeight * length);
        }

        return maxArea;
    }

}