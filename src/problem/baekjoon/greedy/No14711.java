package problem.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No14711 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] prev = new boolean[n + 2];
        boolean[] cur = new boolean[n + 2];
        String str = br.readLine();
        for (int i = 1; i <= str.length(); i++) {
            cur[i] = str.charAt(i - 1) == '#';
        }

        System.out.println(getTile(n, cur, prev));
    }

    private static String getTile(int n, boolean[] cur, boolean[] prev) {
        StringBuilder result = new StringBuilder();
        for (int j = 1; j <= n; j++) {
            result.append(cur[j] ? '#' : '.');
        }
        result.append('\n');
        boolean[] pressed = new boolean[cur.length];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                prev[j] = cur[j - 1] ^ prev[j] ^ cur[j + 1];
            }

            boolean[] temp = cur; // swap
            cur = pressed;
            pressed = temp;

            for (int j = 1; j <= n; j++) {
                cur[j] = prev[j];
                result.append(cur[j] ? '#' : '.');
            }
            result.append('\n');

            prev = pressed;
        }

        return result.toString();
    }

}

