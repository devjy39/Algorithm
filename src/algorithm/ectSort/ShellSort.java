package algorithm.ectSort;
/* 셸 정렬
*  삽입정렬의 약점 : 역순으로 정렬 되어있을 때 최악의 N^2 시간복잡도
*  이 약점을 보완한 방식
*  간격을 두고 일부 데이터와 비교하는 방식.
*  O(n^2) -> 일반적인 산포 데이터에서 삽입정렬보단 빠름
* */

import java.util.Arrays;

public class ShellSort {

    public static void shellSort(int[] arr) {
        int gap = arr.length / 2;

        for (int g = gap; g > 0; g /= 2) {
            for (int i = g; i < arr.length; i++) {
                int temp = arr[i];

                int j = 0;
                for (j = i - g; j >= 0; j -= g) {
                    if (arr[j] > temp) {
                        arr[j + g] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j + g] = temp;
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {10, 32, 52, 27, 35, 22, 25, 33, 48, 17, 99, 56};
        shellSort(arr);
        System.out.println("셸 정렬: " + Arrays.toString(arr));
    }
}
