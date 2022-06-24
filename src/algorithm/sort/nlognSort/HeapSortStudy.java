package algorithm.sort.nlognSort;// 힙 정렬

import java.util.Arrays;

public class HeapSortStudy {
    
    public static void heapSort(int[] arr) { // heap sort -> O(nlogn)
        for (int n = 0; n < arr.length-1; n++) {
            int size = arr.length - n;
            for (int i = size / 2 - 1; i >= 0; i--) { //자식이 1개라도 있는 노드
                heapify(arr, i, size); //배열을 힙으로 O(logn)
            }
            swap(arr, 0, size - 1); // 루트만 끝으로 이동 O(n)
        }
    }

    // 자식들이랑 부모와 비교해서 교환하는 메서드
    public static void heapify(int[] arr, int parentIdx, int size) {
        int left = parentIdx * 2;
        int right = parentIdx * 2 + 1;
        int maxIdx = parentIdx;

        if (left < size && arr[maxIdx] < arr[left]) {
            maxIdx = left;
        }
        if (left < size && arr[maxIdx] < arr[right]) {
            maxIdx = right;
        }

        if(maxIdx!=parentIdx){ swap(arr, maxIdx, parentIdx);}
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        heapSort(arr);
        System.out.println("힙 정렬: " + Arrays.toString(arr));
    }
}
