package problem.baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17435 {
    static final int MAX_N = (int) (Math.log(500_000) / Math.log(2));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[][] sparse = generateSparseTable(arr, N);
        StringBuilder result = new StringBuilder();

        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            result.append(getFunctionResult(sparse, n, x)).append("\n");
        }

        System.out.print(result);
    }

    private static int getFunctionResult(int[][] sparse, int n, int x) {
        for (int i = 0; i <= MAX_N; i++) {
            if ((n & (1 << i)) > 0) {
                x = sparse[i][x];
            }
        }
        return x;
    }

    private static int[][] generateSparseTable(int[] arr, int N) {
        int[][] sparse = new int[MAX_N + 1][N + 1];
        System.arraycopy(arr, 0, sparse[0], 1, N);

        for (int i = 1; i <= MAX_N; i++) {
            for (int j = 1; j <= N; j++) {
                sparse[i][j] = sparse[i - 1][sparse[i - 1][j]];
            }
        }

        return sparse;
    }

}