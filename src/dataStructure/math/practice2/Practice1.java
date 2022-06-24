package dataStructure.math.practice2;

public class Practice1 {

    static int[] c;

    public static int solution(int n) { // dp
        if (c[n] != 0) {
            return c[n];
        }
        int result = 0;

        for (int i = 0; i < n; i++) {
            result += solution(i) * solution(n-1 - i);
        }

        return c[n] = result;
    }


    public static void main(String[] args) {
        c = new int[10];
        c[0] = 1;
        // Test code
        System.out.println(solution(0));
        System.out.println(solution(2));
        System.out.println(solution(5));
        System.out.println(solution(7));
    }
}
