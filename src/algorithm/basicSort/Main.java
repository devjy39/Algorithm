package algorithm.basicSort;
// 알고리즘 - 정렬_1

import java.util.Arrays;

public class Main {
    // 오름차순 기준 정렬 알고리즘

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    // 버블 정렬
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j-1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }
    
    // 삽입 정렬
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                } else
                    break;
            }
        }
    }

    // 선택 정렬
    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            if(i!=minIdx){ swap(arr, i, minIdx);}
        }
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 5, 2, 7, 1, 4};
        System.out.println("원시 배열 : "+Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("버블 정렬: " + Arrays.toString(arr));

        arr = new int[]{3, 5, 2, 7, 1, 4};
        insertionSort(arr);
        System.out.println("삽입 정렬: " + Arrays.toString(arr));

        arr = new int[]{3, 5, 2, 7, 1, 4};
        selectionSort(arr);
        System.out.println("선택 정렬: " + Arrays.toString(arr));

    }
}
