package problem.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No2529 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        char[] signs = new char[k];
        String str = br.readLine();
        int idx = 0;
        for (int i = 0; i < k; i++) {
            signs[i] = str.charAt(idx);
            idx += 2;
        }

        System.out.println(getResult(signs, k));
    }

    private static String getResult(char[] signs, int k) {
        int[] minNum = new int[k + 1];
        int[] maxNum = new int[k + 1];
        boolean[] visited = new boolean[10];

        for (int i = 0; i < 10; i++) {
            minNum[0] = i;
            visited[i] = true;
            if (minNumber(signs, minNum, visited, 1, 0)) {
                break;
            }
            visited[i] = false;
        }

        Arrays.fill(visited, false);
        for (int i = 9; i >= 0; i--) {
            maxNum[0] = i;
            visited[i] = true;
            if (maxNumber(signs, maxNum, visited, 1, 0)) {
                break;
            }
            visited[i] = false;
        }

        return getResult(minNum, maxNum);
    }

    private static String getResult(int[] minNum, int[] maxNum) {
        StringBuilder result = new StringBuilder();
        for (int i : maxNum) {
            result.append(i);
        }
        result.append("\n");
        for (int i : minNum) {
            result.append(i);
        }
        return result.toString();
    }

    private static boolean minNumber(char[] signs, int[] minNum, boolean[] visited, int depth, int idx) {
        if (depth >= minNum.length) {
            return true;
        }

        int min = signs[idx] == '<' ? minNum[depth - 1] + 1 : 0;
        int max = signs[idx] == '<' ? 10 : minNum[depth - 1];

        for (int i = min; i < max; i++) {
            if (visited[i]) {
                continue;
            }
            minNum[depth] = i;
            visited[i] = true;
            if (minNumber(signs, minNum, visited, depth + 1, idx + 1)) {
                return true;
            }
            visited[i] = false;
        }

        return false;
    }

    private static boolean maxNumber(char[] signs, int[] minNum, boolean[] visited, int depth, int idx) {
        if (depth >= minNum.length) {
            return true;
        }

        int min = signs[idx] == '<' ? minNum[depth - 1] + 1 : 0;
        int max = signs[idx] == '<' ? 10 : minNum[depth - 1];

        for (int i = max - 1; i >= min; i--) {
            if (visited[i]) {
                continue;
            }
            minNum[depth] = i;
            visited[i] = true;
            if (maxNumber(signs, minNum, visited, depth + 1, idx + 1)) {
                return true;
            }
            visited[i] = false;
        }

        return false;
    }


}

