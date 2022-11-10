package problem.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2448 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        String[] star = star(n);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String blank = " ".repeat(n - i - 1);
            result.append(blank)
                    .append(star[i])
                    .append(blank)
                    .append("\n");
        }
        System.out.print(result);
    }

    private static String[] star(int n) {
        if (n == 3) {
            return new String[]{"*", "* *", "*****"};
        }

        String[] result = new String[n];
        String[] parts = star(n >> 1);

        System.arraycopy(parts, 0, result, 0, parts.length);

        for (int i = parts.length; i < n; i++) {
            result[i] = parts[i - parts.length] +
                    " ".repeat(4 * parts.length - 2 * i - 1) +
                    parts[i - parts.length];
        }

        return result;
    }

}