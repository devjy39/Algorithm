package problem.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No1464 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(getAnswer(str));
    }

    private static String getAnswer(String str) {
        char[] answer = new char[str.length()];
        int left = 0;
        int right = answer.length - 1;

        loop:
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            for (int j = 0; j < i; j++) {
                if (str.charAt(j) < c) {
                    answer[right--] = c;
                    continue loop;
                }
            }

            answer[left++] = c;
        }

        return String.valueOf(answer);
    }

}

