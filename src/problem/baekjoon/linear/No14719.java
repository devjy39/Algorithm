package problem.baekjoon.linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14719 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] stack = new int[w];
        int top = -1;
        int leftHeight = 0;
        int amount = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            int height = Integer.parseInt(st.nextToken());

            if (height >= leftHeight) {
                while (top >= 0) {
                    amount += leftHeight - stack[top--];
                }
                leftHeight = height;
            } else {
                stack[++top] = height;
            }
        }

        int rightHeight = 0;
        while (top >= 0) {
            int height = stack[top--];
            if (height >= rightHeight) {
                rightHeight = height;
            } else {
                amount += rightHeight - height;
            }
        }

        System.out.println(amount);
    }

}

