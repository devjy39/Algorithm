package dataStructure.nonLinear.NonLinearDS_13_2.src;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

class Friend {
    int idx;
    int start;
    int end;
    int chair;

    public Friend(int idx, int start, int end) {
        this.idx = idx;
        this.start = start;
        this.end = end;
    }
}

public class Practice1 {
    public static int solution(int[][] times, int targetFriend) {
        PriorityQueue<Friend> friends = new PriorityQueue<>(
                Comparator.comparingInt(f -> f.start));
        for (int i = 0; i < times.length; i++) {
            friends.add(new Friend(i, times[i][0], times[i][1]));
        }
        PriorityQueue<Friend> bye = new PriorityQueue<>(
                Comparator.comparingInt(f -> f.end));

        PriorityQueue<Integer> chairs = new PriorityQueue<>();
        IntStream.range(0, times.length).forEach(chairs::add);

        while (!friends.isEmpty()) {
            while (!bye.isEmpty()) {
                if (bye.peek().end <= friends.peek().start) {
                    chairs.add(bye.poll().chair);
                } else {
                    break;
                }
            }

            Friend poll = friends.remove();
            poll.chair = chairs.poll();
            bye.add(poll);

            if (poll.idx == targetFriend) {
                return poll.chair;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // Test code
        int[][] times = {{1, 4}, {2, 3}, {4, 6}};
        System.out.println(solution(times, 1)); // 1

        times = new int[][]{{3, 10}, {1, 5}, {2, 6}};
        System.out.println(solution(times, 0)); // 2
    }
}
