package problem.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1439 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char prev = str.charAt(0);
        int count = 1;
        int amount = 1;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != prev) {
                amount++;
                if (str.charAt(0) == str.charAt(i)) {
                    count++;
                }
                prev = str.charAt(i);
            }
        }

        System.out.println(Math.min(count, amount - count));
    }

}

