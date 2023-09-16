package problem.baekjoon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No10994 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()) - 1;
        int size = n * 4 + 1;
        boolean[][] stars = new boolean[size][size];
        isStar(stars, 0,size - 1);

        System.out.println(printStar(size, stars));
    }

    private static String printStar(int size, boolean[][] stars) {
        StringBuilder result = new StringBuilder(size * size + size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.append(stars[i][j] ? '*' : ' ');
            }
            result.append('\n');
        }

        return result.toString();
    }

    private static void isStar(boolean[][] stars, int start, int end) {
        if (start > end) {
            return;
        }

        for (int i = start; i <= end; i++) {
            stars[start][i] = stars[end][i] = true;
            stars[i][start] = stars[i][end] = true;
        }

        isStar(stars, start + 2, end - 2);
    }

}

