package algorithm.nlognSort;// 알고리즘 - 정렬_2
// 합병 정렬

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeSortStudy {
    
    public static void mergeSort(int[] arr, int[] tmp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, tmp, left, mid);
            mergeSort(arr, tmp, mid + 1, right);
            merge(arr, tmp, left, right, mid);
        }
    }

    // 정렬된 공간끼리 정렬한다가 핵심
    public static void merge(int[] arr, int[] tmp, int left, int right, int mid) {
        int p = left;
        int q = mid + 1;
        int idx = left;

        while (p <= mid || q <= right) { // 양쪽 포인트 둘 중 하나라도 범위 내
            if (arr[p] < arr[q]) {
                tmp[idx++] = arr[p++];
            } else {
                tmp[idx++] = arr[q++];
            }
            if (p > mid) {
                tmp[idx] = arr[q++];
            } else if (q > right) {
                tmp[idx] = arr[p++];
            }
        }

        IntStream.range(left, right + 1).forEach(i -> arr[i] = tmp[i]);
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
        System.out.println("합병 정렬: " + Arrays.toString(arr));
    }
}
