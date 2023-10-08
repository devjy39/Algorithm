package problem.baekjoon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No16719 {
    static final StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        boolean[] visited = new boolean[arr.length];

        appendZOAC(arr, visited, 0, arr.length - 1);
        System.out.print(result);
    }

    private static void appendZOAC(char[] arr, boolean[] visited, int start, int end) {
        if (start > end) {
            return;
        }

        int index = -1;
        char c = 'Z' + 1;
        for (int i = start; i <= end; i++) {
            if (arr[i] < c) {
                c = arr[i];
                index = i;
            }
        }
        visited[index] = true;

        appendResult(arr, visited);

        appendZOAC(arr, visited, index + 1, end);
        appendZOAC(arr, visited, start, index - 1);
    }

    private static void appendResult(char[] arr, boolean[] visited) {
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                result.append(arr[i]);
            }
        }
        result.append('\n');
    }

}

