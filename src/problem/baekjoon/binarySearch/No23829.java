package problem.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No23829 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.print(getPictureScoreSum(br, n, q, arr));
    }

    private static String getPictureScoreSum(BufferedReader br, int n, int q, int[] arr) throws IOException {
        Arrays.sort(arr);
        long[] leftSum = new long[n + 2];
        long[] rightSum = new long[n + 2];
        for (int i = 1; i <= n; i++) {
            leftSum[i] = leftSum[i - 1] + arr[i - 1];
        }
        for (int i = n; i > 0; i--) {
            rightSum[i] = rightSum[i + 1] + arr[i - 1];
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < q; i++) {
            int x = Integer.parseInt(br.readLine());
            int index = Arrays.binarySearch(arr, x);
            index = index < 0 ? -(index + 1) : index;

            result.append((long) x * index - leftSum[index] +
                    rightSum[index + 1] - (long) x * (n - index)).append('\n');
        }

        return result.toString();
    }

}

