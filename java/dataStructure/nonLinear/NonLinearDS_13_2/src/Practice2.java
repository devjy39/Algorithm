package dataStructure.nonLinear.NonLinearDS_13_2.src;

import java.util.Arrays;
import java.util.Comparator;

public class Practice2 {
    public static int[] solution(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> (i[1] - i[0])));

        query:
        for (int i = 0; i < queries.length; i++) {
            for (int[] interval : intervals) {
                if (queries[i] >= interval[0] && queries[i] <= interval[1]) {
                    queries[i] = interval[1] - interval[0] + 1;
                    continue query;
                }
            }

            queries[i] = -1;
        }

        return queries;
    }

    public static void main(String[] args) {
        // Test code
        int[][] intervals = {{1, 4}, {2, 4}, {3, 6}, {4, 4}};
        int[] queries = {2, 3, 4, 5};
        System.out.println(Arrays.toString(solution(intervals, queries)));

        intervals = new int[][]{{2, 3}, {2, 5}, {1, 8}, {20, 25}};
        queries = new int[]{2, 19, 5, 22};
        System.out.println(Arrays.toString(solution(intervals, queries)));
    }
}
