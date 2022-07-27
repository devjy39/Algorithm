package problem.baekjoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String str = br.readLine();
        br.close();
        int answer = 0;
        int count = 0;

        int range = m - 1;
        for (int i = 0; i < range; i++) {
            if (str.charAt(i) == 'I') {
                if (str.charAt(i + 1) == 'O') {
                    count++;
                    i++;
                    continue;
                } else {
                    answer += Math.max(0, count - n + 1);
                }
            } else if (count > 0) {
                answer += Math.max(0, count - n);
            }
            count = 0;
        }

        if (str.charAt(range) == 'I') {
            answer += Math.max(0, count - n + 1);
        } else {
            answer += Math.max(0, count - n);
        }

        System.out.println(answer);
    }
}