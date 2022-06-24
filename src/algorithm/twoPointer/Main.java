package algorithm.twoPointer;
// 알고리즘 - 투 포인터
// for-loop vs two pointers
// 같은 배열에 pointer를 2개 다뤄서 2n 즉 O(n)으로 쇼부를 볼 수 있다.

import java.util.Arrays;

public class Main {
    public static int[] forLoop(int[] arr, int target) {
        int[] result = {-1, -1};

        loop:
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (sum == target) {
                    result[0] = i;
                    result[1] = j - 1;
                    break loop;
                } else if (sum > target) {
                    break;
                }
                sum += arr[j];
            }
        }

        return result;
    }

    public static int[] twoPointers(int[] arr, int target) {
        int[] result = {-1, -1};
        int p1 = 0;
        int p2 = 0;
        int sum = arr[0];

        while (p1 < arr.length) {
            if (sum > target) {
                sum -= arr[p1++];
            } else if (p2 == arr.length - 1) {
                break;
            } else {
                sum += arr[++p2];
            }

            if (sum == target) {
                result[0] = p1;
                result[1] = p2;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 3, 7, 2, 4, 3, 2};
        System.out.println(Arrays.toString(forLoop(arr, 9)));
        System.out.println(Arrays.toString(forLoop(arr, 14)));
        System.out.println();

        System.out.println(Arrays.toString(twoPointers(arr, 9)));
        System.out.println(Arrays.toString(twoPointers(arr, 14)));
    }
}
