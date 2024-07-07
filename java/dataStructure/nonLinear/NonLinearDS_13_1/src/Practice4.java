package dataStructure.nonLinear.NonLinearDS_13_1.src;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Practice4 {
    public static int solution(String[] deadends, String target) {
        HashSet<String> visited = new HashSet<>(Arrays.asList(deadends));

        String pw = "0000";
        int cnt = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(pw);
        visited.add(pw);

        while (!queue.isEmpty()) {
            Queue<String> next = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.remove();

                for (String num : getNextNum(poll.toCharArray())) {
                    if (!visited.contains(num)) {
                        if (num.equals(target)) {
                            return cnt + 1;
                        }
                        next.offer(num);
                        visited.add(num);
                    }
                }
            }

            cnt++;
            if (cnt == 8) {
                break;
            }
            queue = next;
        }

        return -1;
    }

    private static LinkedList<String> getNextNum(char[] array) {
        LinkedList<String> result = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            char origin = array[i];
            array[i] = origin == '9' ? '0' : (char) (origin + 1);
            result.add(String.valueOf(array));
            array[i] = origin == '0' ? '9' : (char) (origin - 1);
            result.add(String.valueOf(array));
            array[i] = origin;
        }
        return result;
    }

    public static void main(String[] args) {
        // Test code
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        System.out.println(solution(deadends, "0202"));

        deadends = new String[] {"8888"};
        System.out.println(solution(deadends, "0009"));

    }
}
