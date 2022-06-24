package algorithm.binarySearch;
/*  알고리즘 - 이진 탐색
*   선 정렬 필요, O(logn)
* */

public class Main {
    // 반복문 구조
    public static int binarySearch(int arr[], int target) {
        int mid = arr.length / 2;
        int left = 0;
        int right = arr.length - 1;

        while (arr[mid] != target) {
            if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }

        return mid;
    }
    
    // 재귀 호출 구조
    public static int binarySearch2(int[] arr, int target, int left, int right) {
        int mid = (left + right) / 2;

        if (target < arr[mid]) {
            return binarySearch2(arr, target, left, mid - 1);
        } else if (target > arr[mid]) {
            return binarySearch2(arr, target, mid + 1, right);
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60};

        System.out.println("Index: " + binarySearch(arr, 30));
        System.out.println();

        System.out.println("Index: " + binarySearch2(arr, 30, 0, arr.length - 1));
    }
}
