package algorithm.practice.practice1;

import java.util.HashSet;
import java.util.Set;

public class Practice3 {

    public static int solution(int n, int[] items) {
        if (items == null || items.length == 0) {
            return -1;
        }

        int cnt = 0;
        Set<Integer> oldSet = new HashSet<>(n);
        Set<Integer> newSet = new HashSet<>(n);

        for (int item : items) {
            if (oldSet.size() < n) {
                oldSet.add(item);
            } else {
                if (!(oldSet.contains(item) || newSet.contains(item))) {
                    cnt++;
                }
                newSet.add(item);

                if (newSet.size() == n) {
                    oldSet = newSet;
                    newSet = new HashSet<>();
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        // Test code
        int n = 2;
        int[] items = {2, 3, 2, 3, 1, 2, 7};
        System.out.println(solution(n, items));
    }
}
