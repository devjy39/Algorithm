package algorithm.binarySearch.binSearchProblem;// Practice3
// 2차원 행렬에서 이진 탐색으로 데이터 찾기
// row x col 행렬 데이터가 주어졌을 때, target 을 이진 탐색으로 찾는 프로그램을 작성하세요.
// 각 행의 데이터는 오름차순으로 정렬 상태

// 입출력 예시
// 행렬: {{1, 3, 7, 8}, {10, 11, 15, 20}, {21, 30, 35, 60}}

// target: 3
// 출력: true

// target: 13
// 출력: false

public class Practice3 { // 이차원 배열을 1차원처럼 쓰기. 아이디어
    public static boolean solution(int[][] matrix, int target) {
        int col = matrix[0].length;
        int row = matrix.length;
        int left = 0;
        int right = col * row - 1;

        while (left <= right) {
            int mid = (right + left) >> 1;
            if (target < matrix[mid / col][mid % row]) {
                right = mid - 1;
            } else if (target > matrix[mid / col][mid % row]) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Test code
        int[][] matrix = {{1, 3, 7, 8}, {10, 11, 15, 20}, {21, 30, 35, 60}};
        System.out.println(solution(matrix, 3));    // true
        System.out.println(solution(matrix, 13));   // false
        System.out.println(solution(matrix, 35));   // true
    }
}
