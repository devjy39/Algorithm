package algorithm.binarySearch.binSearchProblem;// Practice
// 원형 정렬 상태 배열에서의 이진 탐색
// nums 배열에 원형 상태로 데이터가 정렬되어 있을 때,
// 이진 탐색으로 데이터를 찾는 프로그램을 작성하세요.
// O(log n) 유지
// 배열을 재 정렬하지 않고 풀기

// 입출력 예시
// arr: 4, 5, 6, 7, 8, 0, 1, 2

// target: 0
// 출력: 5

// target: 3
// 출력: -1

public class Practice2 { // **
    public static int solution(int[] arr, int target) {
        int right = arr.length - 1;
        int left = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.printf("%d %d %d\n", left, mid, right);
            System.out.printf("%d %d %d\n", arr[left], arr[mid], arr[right]);

            if (target == arr[mid]) {
                return mid;
            }
            if (arr[left] <= arr[mid]) { //적어도 왼쪽은 정렬이 정확한 상황
                if (target >= arr[left] && target < arr[mid]) { //확실히 왼쪽
                    right = mid - 1;
                } else { //아닌경우로 잡아주기
                    left = mid + 1;
                }
            } else { //적어도 오른쪽은 정렬이 정확한 상황
                if (target > arr[mid] && target <= arr[right]) { // 확실히 오른쪽
                    left = mid + 1;
                } else { // 아닌경우로 잡아주기
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {7, 0, 1, 2, 3, 4, 5, 6}; // 5  4
        System.out.println(solution(nums, 0));  // 5
        System.out.println(solution(nums, 3));  // -1
    }
}
