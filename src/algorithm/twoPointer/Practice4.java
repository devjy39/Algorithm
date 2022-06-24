package algorithm.twoPointer;
// Practice
// 주어진 nums 배열에서 3 개의 합이 0이 되는 모든 숫자들을 출력하세요.
// 중복된 숫자 셋은 제외하고 출력하세요.

// 입출력 예시
// nums: {-1, 0, 1, 2, -1, -4};
// 출력: [[-1, -1, 2], [-1, 0, 1]]

// nums: {1, -7, 6, 3, 5, 2}
// 출력: [[-7, 1, 6], [-7, 2, 5]]


import java.util.*;

public class Practice4 {
    public static List<List<Integer>> solution(int[] nums) {
        if (nums.length < 3) {
            return null;
        }
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int p1 = i + 1;
            int p2 = nums.length - 1;

            while (p1 < p2) {
                int sum = nums[p1] + nums[p2] + nums[i];

                if (sum > 0) {
                    p2--;
                } else if (sum < 0) {
                    p1++;
                } else {
                    set.add(List.of(nums[i], nums[p1], nums[p2]));
                    p1++;
                    p2--;
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {-1, 0, 1, 2, -1, -4};     // [[-1, -1, 2], [-1, 0, 1]]
        System.out.println(solution(nums));

        nums = new int[] {1, -7, 6, 3, 5, 2};   // [[-7, 1, 6], [-7, 2, 5]]
        System.out.println(solution(nums));
    }
}
