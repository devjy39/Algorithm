package algorithm.practice.practice2.src;

import java.util.ArrayList;
import java.util.List;

public class Practice2 {
    public static void solution(int n) {
        int p1 = 1; // 예상한 무게
        int p2 = 1; // 실제 무게 (더 큼)
        List<Integer> result = new ArrayList<>();

        while (p1 <= p2) {
            int hint = p2 * p2 - p1 * p1;
            if (hint > 1000) {
                break;
            }

            if (hint < n) { // 차이값을 늘려주기 위해 p2 증가
                p2++;
            } else { // 줄이기 위해 p1을 증가
                if (hint == n) {
                    result.add(p2);
                }
                p1++;
            }
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        // Test code
        solution(20);
    }
}
