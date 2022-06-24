package algorithm.binarySearch.binSearchProblem;// Practice1
// 이진 탐색 추가 구현
// target 값이 arr 내에 있으면 해당 인덱스 반환
// 없으면 해당 값이 있을 경우의 위치에 -1을 곱하고 1을 뺀 값을 반환

// 입출력 예시
// 입력 arr: 1, 2, 5, 10, 20, 30, 40, 50, 60

// target: 30
// 출력: 5

// target: 3
// 출력: -3

public class Practice1 {
    public static int solution(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left <= right) {
            //mid = (left + right) / 2;
            mid = left + (right - left) / 2; // *** overflow 피하는 계산 방법 ***

            if (target < arr[mid]) {
                right = mid - 1;
            } else if (target > arr[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -left-1;
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60};
        System.out.println(solution(arr, 30));  // 5
        System.out.println(solution(arr, 3));   // -3
        System.out.println(solution(arr, 11));  // -5
        System.out.println(solution(arr, 35));  // -7
    }
}
