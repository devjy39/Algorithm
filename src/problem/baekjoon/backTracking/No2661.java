package problem.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2661 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];

        dfs(numbers, 0);

        StringBuilder result = new StringBuilder();
        for (int number : numbers) {
            result.append(number);
        }

        System.out.println(result);
    }

    private static boolean dfs(int[] numbers, int depth) {
        if (depth >= numbers.length) {
            return true;
        }

        for (int i = 1; i <= 3; i++) {
            numbers[depth] = i;
            if (!equal(numbers, depth)) {
                if (dfs(numbers, depth + 1)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean equal(int[] numbers, int depth) {
        int size = 1;

        for (int left = depth - 1; left >= 0; left -= 2) {

            int right = left + size;
            boolean equal = true;
            for (int j = 0; j < size; j++) {
                if (numbers[left + j] != numbers[right + j]) {
                    equal = false;
                    break;
                }
            }

            size++;
            if (equal) {
                return true;
            }
        }

        return false;
    }


}

