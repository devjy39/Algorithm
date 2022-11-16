package algorithm.binarySearch;
/*  알고리즘 - 이진 탐색
*   선 정렬 필요, O(logn)
*   max 값을 찾을 때 -> right 출력   1 2 /3/ 4 5  3에서 left==right 일 때 3이 답일땐 left=4 right=3 으로 right가 답, 3이 답이 아닌경우도 left = 3, right = 2로 답이 출력됨
*   min 값을 찾을 때 -> left 출력
* */

public class Main {
    // 반복문 구조
    public static int binarySearch(int[] arr, int target) {
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
