package problem.baekjoon.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        br.close();

        System.out.println(recursion(0, x, y, (int) Math.pow(2, n)));
    }

    private static int recursion(int min, int x, int y, int size) {
        if (size == 1) {
            return min;
        }
        size >>= 1;
        int position = 0;

        if (x >= size) {
            position += 2;
            x -= size;
        }
        if (y >= size) {
            position += 1;
            y -= size;
        }

        return recursion(min + position * size * size, x, y, size);
    }
}