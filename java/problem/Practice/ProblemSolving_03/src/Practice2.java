package problem.Practice.ProblemSolving_03.src;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Practice2 {
    public static String[] solution(int n, int[] memo1, int[] memo2) {
        return IntStream.range(0, n).mapToObj(i ->
                        String.format("%" + n + "s", Integer.toBinaryString(memo1[i] | memo2[i])
                                .replaceAll("1", "#")
                                .replaceAll("0", " ")))
                .toArray(String[]::new);
    }

    public static void main(String[] args) {
        // Test code
        int n = 3;
        int [] memo1 = {3, 4, 7};
        int [] memo2 = {4, 1, 3};
        System.out.println(Arrays.toString(solution(n, memo1, memo2)));

        n = 5;
        memo1 = new int[]{15, 21, 17, 18, 11};
        memo2 = new int[]{30, 1, 21, 19, 28};
        System.out.println(Arrays.toString(solution(n, memo1, memo2)));
    }
}
