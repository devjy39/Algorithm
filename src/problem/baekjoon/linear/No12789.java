package problem.baekjoon.linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No12789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stack = new int[n];
        int top = 0;
        int sequence = 1;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while (n-- > 0) {
            int number = Integer.parseInt(st.nextToken());

            if (number != sequence) {
                while (stack[top] == sequence) {
                    sequence++;
                    top--;
                }
                stack[++top] = number;
            } else {
                sequence++;
            }
        }

        while (stack[top] == sequence) {
            sequence++;
            top--;
        }

        System.out.println(top == 0 ? "Nice" : "Sad");
    }

}

