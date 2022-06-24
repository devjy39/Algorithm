package etcAlgorithm;

import java.util.Arrays;

public class CumulativeSum {
    // 구간합을 메모리제이션으로 O(1)로 !!
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 3, 4, 1, 2, 3, 4, 51, 2, 1};
        int[] cumSum = new int[arr.length]; // 누적합 배열
        cumSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            cumSum[i] = cumSum[i - 1] + arr[i];
        }
        System.out.println("original arr => " + Arrays.toString(arr));
        System.out.println("CumulativeSum = > " + Arrays.toString(cumSum));

        int start = 5;
        int end = 10;
        System.out.printf("구간 %d ~ %d 합: %d", start, end,
                cumSum[end] - (start == 0 ? 0 : cumSum[start - 1]));



    }
}
