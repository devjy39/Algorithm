package problem.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No11497 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            result.append(getMinLevel(arr)).append("\n");
        }

        System.out.println(result);
    }

    private static int getMinLevel(int[] arr) {
        int[] setArray = new int[arr.length];
        int left = 0;
        int right = arr.length - 1;
        int top = 0;
        while (left <= right) {
            setArray[top % 2 == 0 ? left++ : right--] = arr[top++];
        }

        int maxLevel = Math.abs(setArray[0] - setArray[arr.length - 1]);
        for (int i = 1; i < arr.length; i++) {
            maxLevel = Math.max(maxLevel, Math.abs(setArray[i] - setArray[i - 1]));
        }

        return maxLevel;
    }

}

