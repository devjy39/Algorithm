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
        String[] part = star(n >> 1);

        System.arraycopy(part, 0, result, 0, part.length);

        int space = part[part.length - 1].length();
        for (int i = part.length; i < n; i++) {
            result[i] = part[i - part.length] +
                    " ".repeat(space - (i - part.length) * 2) +
                    part[i - part.length];
        }

        return result;
    }

}