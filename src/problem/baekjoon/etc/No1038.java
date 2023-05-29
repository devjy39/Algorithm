package problem.baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No1038 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] number = getNumberArray(n);

        System.out.println(getNumberString(number));
    }

    private static int[] getNumberArray(int n) {
        int[] number = new int[10];
        Arrays.fill(number, 10);
        number[0] = 0;

        while (n-- > 0) {
            boolean check = false;
            for (int i = 1; i < 10; i++) {
                if (number[i - 1] + 1 < number[i]) { // 올림가능
                    number[i - 1]++;
                    for (int j = 0; j < i - 1; j++) {
                        number[j] = j;
                    }
                    check = true;
                    break;
                } else if (number[i] == 10) {
                    for (int j = 0; j <= i; j++) {
                        number[j] = j;
                    }
                    check = true;
                    break;
                }
            }

            if (!check) {
                number[0] = 10;
                break;
            }
        }

        return number;
    }

    private static String getNumberString(int[] number) {
        if (number[0] == 10) {
            return "-1";
        }

        StringBuilder result = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (number[i] < 10) {
                result.append(number[i]);
            }
        }
        return result.toString();
    }

}

