package problem.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1182 {
    static int N, S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dfs(arr, 0, 0) + (S == 0 ? -1 : 0));
    }

    private static int dfs(int[] arr, int sum, int idx) {
        if (idx == N) {
            if (sum == S) {
                return 1;
            }
            return 0;
        }

        return dfs(arr, sum + arr[idx], idx + 1) + dfs(arr, sum, idx + 1);
    }

}
