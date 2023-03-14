package problem.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No6603 {
    static StringBuilder result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String read;
        result = new StringBuilder();

        while (!(read = br.readLine()).equals("0")) {
            StringTokenizer st = new StringTokenizer(read);
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }


            dfs(arr, new boolean[n], 0, 0);
            result.append("\n");
        }

        System.out.print(result);
    }

    private static void dfs(int[] arr, boolean[] check, int idx, int count) {
        if (count >= 6) {
            for (int i = 0; i < check.length; i++) {
                if (check[i]) {
                    result.append(arr[i]).append(" ");
                }
            }
            result.append("\n");
            return;
        } else if (idx >= check.length) {
            return;
        }

        check[idx] = true;
        dfs(arr, check, idx + 1, count + 1);
        check[idx] = false;
        dfs(arr, check, idx + 1, count);
    }

}
