package problem.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No6443 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        while (t-- > 0) {
            char[] chars = br.readLine().toCharArray();
            Arrays.sort(chars);

            dfs(chars, new boolean[chars.length], result, new char[chars.length], 0);
        }

        System.out.print(result);
    }

    private static void dfs(char[] chars, boolean[] visited, StringBuilder result, char[] arr, int depth) {
        if (depth >= arr.length) {
            for (char c : arr) {
                result.append(c);
            }
            result.append("\n");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                if (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]) {
                    continue;
                }
                arr[depth] = chars[i];
                visited[i] = true;
                dfs(chars, visited, result, arr, depth + 1);
                visited[i] = false;
            }
        }
    }

}

