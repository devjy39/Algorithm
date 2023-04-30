package problem.baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10451 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder result = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            result.append(getCycle(n, arr)).append("\n");
        }

        System.out.print(result);
    }

    private static int getCycle(int n, int[] arr) {
        int cycle = 0;

        for (int i = 1; i <= n; i++) {
            if (arr[i] > 0) {
                cycle++;
                int node = i;
                int next;
                while (arr[node] > 0) {
                    next = arr[node];
                    arr[node] = -1;
                    node = next;
                }
            }
        }
        return cycle;
    }

}

