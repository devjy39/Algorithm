package algorithm.sort.basicSort.sortProblem;// Practice3
// intervals 라는 구간으로 이루어진 배열이 주어졌을 때,
// 오버랩 되는 구간을 합치는 프로그램을 작성하세요.

// 입출력 예시
// 입력: [2, 6], [1, 3], [15, 18], [8, 10]
// 출력: [1, 6] [8, 10] [15, 18]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Practice3 {

    public static ArrayList<int[]> solution(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        ArrayList<int[]> result = new ArrayList<>();

        int right = 0;
        for (int[] interval : intervals) {
            if (interval[0] <= right) {
                result.get(result.size() - 1)[1] = interval[1];
            } else {
                result.add(interval);
            }
            right = interval[1];
        }
        return result;
    }

    public static void sort(int[][] intervals) {

    }

    public static void main(String[] args) {
        // Test code
        int[][] intervals = {{2, 6}, {1, 3}, {15, 18}, {8, 10}};

        for (int[] item: solution(intervals)) {
            System.out.print(Arrays.toString(item) + " ");
        }
        System.out.println();

    }
}
