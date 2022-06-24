package algorithm.devideandconquer;
// Practice1
// 정수형 배열 nums 가 주어졌다.
// 연속된 부분 배열의 합 중 가장 큰 값을 출력하세요.

// 입출력 예시
// nums: -5, 0, -3, 4, -1, 3, 1, -5, 8
// 출력: 10

// nums: -5, 4, 0, 7, 8
// 출력: 24

public class Practice1 {

    public static int solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return divideSubArray(nums, 0, nums.length - 1);
    }

    public static int divideSubArray(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        // 좌우측 분할
        int mid = left + (right - left) / 2;
        int maxLeft = divideSubArray(nums, left, mid);
        int maxRight = divideSubArray(nums, mid + 1, right);

        // Conquer
        int maxArr = getMaxSubArray(nums, left, mid, right);

        return Math.max(maxLeft, Math.max(maxRight, maxArr));
    }

    public static int getMaxSubArray(int[] nums, int left, int mid, int right) {
        int sumLeft = 0;
        int maxLeft = Integer.MIN_VALUE;

        for (int i = mid; i >= left; i--) {
            sumLeft += nums[i];
            maxLeft = Math.max(maxLeft, sumLeft);
        }

        int sumRight = 0;
        int maxRight = Integer.MIN_VALUE;

        for (int i = mid + 1; i <= right; i++) {
            sumRight += nums[i];
            maxRight = Math.max(maxRight, sumRight);
        }

        return maxLeft + maxRight;
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {-5, 0, -3, 4, -1, 3, 1, -5, 8};
        System.out.println(solution(nums));

        nums = new int[]{-1,-3,-2,-4,-13};
        System.out.println(solution(nums));
    }
}
