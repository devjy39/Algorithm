package algorithm.greedy;
// Practice
// 정수형 nums 배열이 주어졌다.
// 각 원소의 값은 해당 위치에서 오른쪽으로 이동할 수 있는 최대 값이다.
// 첫 번째 위치에서 시작해서 가장 끝까지 이동이 가능한지 판별하는 프로그램을 작성하세요.
// 이동이 가능하면 true, 불가능하면 false 를 반환하세요.

// 입출력 예시
// nums: 2, 3, 0, 1, 4
// 출력: true

// nums: 3, 0, 0, 1, 1
// 출력: true

// nums: 3, 2, 1, 0, 4
// 출력: false

public class Practice1 {
    public static boolean solution(int[] nums) {
        int p = 0;

        for (int i = 0; i < nums.length; i++) { //어차피 한 칸씩 이동하므로 for문
            if (p < i) {
                return false;
            } else if (p >= nums.length - 1) {
                return true;
            }

            p = Math.max(p, i + nums[i]);
        }

        return true;
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {2, 3, 0, 1, 4};
        System.out.println(solution(nums));

        nums = new int[]{3, 0, 0, 1, 1};
        System.out.println(solution(nums));

        nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(solution(nums));
    }
}
