package algorithm.practice.practice2.src;

public class Practice1 {
    public static int solution(int[] rocks, int goal, int n) {
        if (rocks == null || rocks.length == 0) {
            return -1;
        }

        return 0;
    }

    public static void main(String[] args) {
        // Test code
        int[] rocks = {11, 2, 14, 21, 17};
        int goal = 25;
        int n = 2;
        System.out.println(solution(rocks, goal, n));
    }
}
