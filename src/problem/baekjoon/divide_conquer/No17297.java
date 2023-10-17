package problem.baekjoon.divide_conquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No17297 {
    static final String[] messi = {"", "Messi", "Messi Gimossi"};
    static final String answer = "Messi Messi Gimossi";
    static final char SPACE = ' ';

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> sizes = getSizes(n);

        char word = getWord(sizes, n, sizes.size() - 1);
        System.out.println(word == SPACE ? answer : word);
    }

    private static List<Integer> getSizes(int n) {
        List<Integer> sizes = new ArrayList<>();
        sizes.add(0);
        sizes.add(messi[1].length());
        sizes.add(messi[2].length());

        while (sizes.get(sizes.size() - 1) < n) {
            sizes.add(sizes.get(sizes.size() - 1) + sizes.get(sizes.size() - 2) + 1);
        }

        return sizes;
    }

    private static char getWord(List<Integer> sizes, int n, int depth) {
        if (depth <= 2) {
            return messi[depth].charAt(n - 1);
        }

        int spaceIndex = sizes.get(depth - 1) + 1;

        if (n > spaceIndex) {
            return getWord(sizes, n - spaceIndex, depth - 2);
        } else if (n < spaceIndex) {
            return getWord(sizes, n, depth - 1);
        }

        return SPACE;
    }

}

