package problem.baekjoon.linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No1935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] number = new double['Z' - 'A' + 1];
        String str = br.readLine();
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(br.readLine());
        }

        System.out.printf("%.2f", formulaCalculation(number, str));
    }

    private static double formulaCalculation(double[] number, String str) {
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isAlphabetic(c)) {
                stack.add(number[c - 'A']);
            } else {
                double b = stack.pop();
                double a = stack.pop();
                switch (c) {
                    case '+':
                        stack.add(a + b);
                        break;
                    case '-':
                        stack.add(a - b);
                        break;
                    case '*':
                        stack.add(a * b);
                        break;
                    case '/':
                        stack.add(a / b);
                }
            }

        }

        return stack.pop();
    }
}

