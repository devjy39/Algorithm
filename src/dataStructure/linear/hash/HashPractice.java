package dataStructure.linear.hash;

import java.util.Arrays;
import java.util.Hashtable;

public class HashPractice {
    public static void main(String[] args) {
        int[] nums = {7, 11, 5, 3};
        System.out.println(Arrays.toString(solution(nums, 10)));

        nums = new int[]{8, 3, -2};
        System.out.println(Arrays.toString(solution(nums,6)));

        nums = new int[]{1,2,3};
        System.out.println(Arrays.toString(solution(nums,12)));

        nums = new int[]{4,2,40,20,6,7};
        System.out.println(Arrays.toString(solution(nums,10)));

    }
    // 못 푼 문제, 차이값을 해싱 한다는 발상. 덧셈 특성상 양방향성이 성립해서 O(n)에 가능한듯.

    private static int[] solution(int[] nums, int target) {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashtable.containsKey(nums[i])) {
                return new int[]{hashtable.get(nums[i]),i};
            }

            hashtable.put(target - nums[i], i);
        }

        return null;
    }
}
