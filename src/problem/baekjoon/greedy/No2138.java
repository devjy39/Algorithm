package problem.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No2138 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String str = br.readLine();
        boolean[] bulbs = new boolean[n];
        for (int i = 0; i < n; i++) {
            bulbs[i] = str.charAt(i) == '1';
        }
        str = br.readLine();
        boolean[] target = new boolean[n];
        for (int i = 0; i < n; i++) {
            target[i] = str.charAt(i) == '1';
        }

        int count = getMinCount(Arrays.copyOf(bulbs, bulbs.length), target);
        bulbs[0] = !bulbs[0];
        bulbs[1] = !bulbs[1];
        count = Math.min(count, getMinCount(bulbs, target) + 1);

        System.out.println(count >= MAX ? -1 : count);
    }

    static final int MAX = 1_000_000;

    private static int getMinCount(boolean[] bulbs, boolean[] target) {
        int count = 0;

        for (int i = 1; i < bulbs.length - 1; i++) {
            if (bulbs[i - 1] != target[i - 1]) {
                count++;
                bulbs[i] = !bulbs[i];
                bulbs[i + 1] = !bulbs[i + 1];
            }
        }

        if (bulbs[bulbs.length - 2] != target[target.length - 2]) {
            bulbs[bulbs.length - 1] = !bulbs[bulbs.length - 1];
            count++;
        }

        return bulbs[bulbs.length - 1] == target[target.length - 1] ? count : MAX;
    }

}

