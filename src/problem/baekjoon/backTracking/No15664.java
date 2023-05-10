package problem.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No15664 {
    static StringBuilder result;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        result = new StringBuilder();
        dfs(arr, 0, -1, new int[m]);

        System.out.print(result);
    }

    private static void dfs(int[] arr, int depth, int prev, int[] answer) {
        if (depth >= m) {
            for (int i : answer) {
                result.append(i).append(" ");
            }
            result.append("\n");
            return;
        }

        for (int i = prev + 1; i < arr.length; i++) {
            if (i > prev + 1 && arr[i] == arr[i - 1]) {
                continue;
            }
            answer[depth] = arr[i];
            dfs(arr, depth + 1, i, answer);
        }
    }

}

