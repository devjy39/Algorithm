package dataStructure.nonLinear.NonLinearDS_13_1.src;

import java.util.*;
import java.util.stream.Collectors;

public class Practice5 {
    public static int solution(int[] forbidden, int a, int b, int x) {
        HashSet<Integer> visited = new HashSet<>(Arrays.stream(forbidden).boxed().collect(Collectors.toList()));
        Queue<int[]> queue = new LinkedList<>(List.of(new int[]{0, 0}));
        int cnt = 0;
        visited.add(0);
        int MAX = x + a + b;

        while (!queue.isEmpty()) {
            Queue<int[]> next = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] q = queue.remove();

                int[][] moves = {{q[0] + a, 1}, q[1] == -1 ? new int[]{0, 0} : new int[]{q[0] - b, -1}};
                for (int[] move : moves) {
                    if (move[0] >= 0 && move[0]<=MAX &&!visited.contains(move[0])) {
                        if (move[0] == x) {
                            return cnt + 1;
                        }
                        next.add(move);
                        visited.add(move[0]);
                    }
                }
            }
            queue = next;
            cnt++;
        }

        return -1;
    }

    public static void main(String[] args) {
        // Test code
        int[] forbidden = {14, 4, 18, 1, 15};
        System.out.println(solution(forbidden, 3, 15, 9));

        forbidden = new int[]{1, 6, 2, 14, 5, 17, 4};
        System.out.println(solution(forbidden, 16, 9, 7));

        forbidden = new int[]{8, 3, 16, 6, 12, 20};
        System.out.println(solution(forbidden, 15, 13, 11));
    }
}
