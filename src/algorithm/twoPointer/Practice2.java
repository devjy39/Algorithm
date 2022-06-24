package algorithm.twoPointer;
// Practice
// nums1 과 nums2 두 배열이 주어졌을 때
// 두 배열의 공통 원소를 배열로 반환하는 프로그램을 작성하세요.
// 결과 배열의 원소에는 중복 값이 없도록 하며 순서는 상관 없다.

// 입출력 예시
// nums1: 1, 2, 2, 1
// nums2: 2, 2
// 출력: 2

// nums1: 4, 9, 5
// nums2: 9, 4, 9, 8, 4
// 출력: 4, 9 (or 9, 4)

import java.util.*;

public class Practice2 {
    public static int[] solution(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> result = new HashSet<>();
        int left = 0;
        int right = 0;

        while (left < nums1.length && right < nums2.length) {
            if (nums1[left] == nums2[right]) {
                result.add(nums1[left]);
            }
            if (nums1[left] < nums2[right]) {
                left++;
            } else {
                right++;
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        // Test code
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(solution(nums1, nums2)));

        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(solution(nums1, nums2)));

        nums1 = new int[]{1, 7, 4, 9};
        nums2 = new int[]{7, 9};
        System.out.println(Arrays.toString(solution(nums1, nums2)));
    }
}
