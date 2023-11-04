package problem.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(getPoliomino(str));
    }

    private static String getPoliomino(String str) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'X') {
                count++;
            } else {
                result.append("A".repeat(count - (count % 4)));
                count %= 4;
                result.append("B".repeat(count - (count % 2)));
                count %= 2;
                if (count == 1) {
                    return "-1";
                }
                result.append('.');
            }
        }

        result.append("A".repeat(count - (count % 4)));
        count %= 4;
        result.append("B".repeat(count - (count % 2)));
        count %= 2;
        if (count == 1) {
            return "-1";
        }

        return result.toString();
    }

}

