package problem.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class No1431 {

    static class CustomComparator implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            if (s1.length() == s2.length()) {
                int sum1 = getSum1(s1);
                int sum2 = getSum1(s2);
                if (sum1 == sum2) {
                    return s1.compareTo(s2);
                }

                return sum1 - sum2;
            }

            return s1.length() - s2.length();
        }

        private static int getSum1(String s1) {
            int sum = 0;

            for (int i = 0; i < s1.length(); i++) {
                if (Character.isDigit(s1.charAt(i))) {
                    sum += s1.charAt(i) - '0';
                }
            }

            return sum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words, new CustomComparator());

        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word).append('\n');
        }
        System.out.print(result);
    }

}

