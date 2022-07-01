package problem.Practice.ProblemSolving_01.src;

public class Practice1 {
    public static int solution(int[] appleTrees, int a, int b) {
        int result = appleTrees.length;

        for (int appleTree : appleTrees) {
            appleTree = Math.max(0, appleTree - a);

            result += (appleTree + b - 1) / b;
        }

        return result;
    }

    public static void main(String[] args) {
        // Test code
        int[] appleTrees = new int[] {1, 2, 3};
        System.out.println(solution(appleTrees, 1, 1));

        System.out.println();
        appleTrees = new int[]{10, 10, 20, 20, 30, 30};
        System.out.println(solution(appleTrees, 5, 3));
    }
}
