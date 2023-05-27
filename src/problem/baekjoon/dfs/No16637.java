package problem.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No16637 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int[] number = new int[n / 2 + 1];
        char[] operator = new char[n / 2];

        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) {
                number[i / 2] = str.charAt(i) - '0';
            } else {
                operator[i / 2] = str.charAt(i);
            }
        }

        System.out.println(getMaxResult(number, operator, 1, number[0]));
    }

    private static int getMaxResult(int[] number, char[] operator, int depth, int result) {
        if (depth >= operator.length) {
            if (depth == operator.length) {
                return calculate(result, number[depth], operator[depth - 1]);
            } else {
                return result;
            }
        }

        // 괄호 미사용
        int maxResult = getMaxResult(number, operator, depth + 1,
                calculate(result, number[depth], operator[depth - 1]));

        // 괄호 사용
        maxResult = Math.max(maxResult, getMaxResult(number, operator, depth + 2,
                calculate(result, calculate(number[depth], number[depth + 1], operator[depth]), operator[depth - 1])));

        return maxResult;
    }

    private static int calculate(int a, int b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            default:
                return a * b;
        }
    }

}
