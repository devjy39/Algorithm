package problem.baekjoon.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No4779 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String read;

        StringBuilder result = new StringBuilder();
        while ((read = br.readLine()) != null) {
            int n = Integer.parseInt(read);
            n = (int) Math.pow(3, n);

            char[] chars = new char[n];
            Arrays.fill(chars, '-');
            dfs(chars, 0, n - 1, n);

            for (int i = 0; i < n; i++) {
                result.append(chars[i]);
            }
            result.append("\n");
        }

        System.out.print(result);
    }

    private static void dfs(char[] chars, int left, int right, int length) {
        if (length <= 1) {
            return;
        }

        length /= 3;
        for (int i = 0; i < length; i++) {
            chars[left + length + i] = ' ';
        }

        dfs(chars, left, right - length, length);
        dfs(chars, left + length * 2, right, length);
    }

}
