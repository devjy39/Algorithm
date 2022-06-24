package algorithm.practice.practice1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Practice2 {

    public static int solution(int n, int[] plates, int types, int coupon) {
        if (plates == null || plates.length == 0) {
            return -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        for (int i = plates.length - n; i < plates.length; i++) {
            queue.add(plates[i]);
            set.add(plates[i]);
        }
        set.add(coupon);

        int maxSum = 0;

        for (int plate : plates) {
            queue.add(plate);
            set.add(plate);
            maxSum = Math.max(maxSum, set.size() + (set.contains(coupon) ? 0 : 1));

            set.remove(queue.poll());
        }

        return maxSum;
    }

    public static void main(String[] args) {
        // Test code
        int n = 4;
        int[] plates = {7, 9, 7, 30, 2, 7, 9, 25};
        int types = 30;
        int coupon = 30;
        System.out.println(solution(n, plates, types, coupon));
    }
}
