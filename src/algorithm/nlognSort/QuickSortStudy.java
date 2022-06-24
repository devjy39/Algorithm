package algorithm.nlognSort;// 퀵 정렬

import java.util.Arrays;

public class QuickSortStudy {

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(arr, left, right);// 반갈 후 중간값

        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = left++;

        while (left <= right) {
            while (left < arr.length && arr[left] < arr[pivot]) {
                left++;
            }
            while (right > 0 && arr[right] > arr[pivot]) {
                right--;
            }
            if (left < right) swap(arr, left, right);
        }
        swap(arr, pivot, right);
        return right;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 7, 9, 4, 5, 8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("퀵 정렬: " + Arrays.toString(arr));
    }
}
