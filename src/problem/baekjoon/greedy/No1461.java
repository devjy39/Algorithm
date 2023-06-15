package problem.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1461 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        int zeroIdx = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] < 0) {
                zeroIdx++;
            }
        }

        System.out.println(getMinSteps(n, m, arr, zeroIdx));
    }

    private static int getMinSteps(int n, int m, int[] arr, int zeroIdx) {
        Arrays.sort(arr);
        int result = 0;

        for (int i = 0; i < zeroIdx; i += m) {
            result += Math.abs(arr[i]) * 2;
        }
        for (int i = n; i > zeroIdx; i -= m) {
            result += arr[i] * 2;
        }

        return result - Math.max(Math.abs(arr[0]), Math.abs(arr[n]));
    }

}

