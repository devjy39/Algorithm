package problem.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No10610 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] numbers = new int[str.length()];
        boolean containZero = false;
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            numbers[i] = str.charAt(i) - '0';
            sum += numbers[i];
            if (numbers[i] == 0) {
                containZero = true;
            }
        }

        if (!containZero || sum % 3 != 0) {
            System.out.println(-1);
        } else {
            Arrays.sort(numbers);
            intReverseOrder(numbers);

            StringBuilder result = new StringBuilder(numbers.length);
            for (int number : numbers) {
                result.append(number);
            }
            System.out.println(result);
        }
    }

    private static void intReverseOrder(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        int temp = 0;
        while (left < right) {
            temp = numbers[left];
            numbers[left++] = numbers[right];
            numbers[right--] = temp;
        }
    }

}