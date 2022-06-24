package dataStructure.math.practice2;

public class Practice4 {

    static final int mod = 1000000007;

    public static int solution(int n) {
        return (int) ((pow(5, (n+1) / 2) * pow(4, n / 2)) % mod);
    }

    static long pow(int x, int n) { //pow를 이진으로 줄여가며 계산하는 아이디어
        if (n == 0) {
            return 1;
        }

        long p = pow(x, n / 2);
        return (p * p * ((n % 2 == 0 ? 1 : x))) % mod;
    }



    public static void main(String[] args) {
        // Test code
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(50));

        System.out.println(pow(5, 5));
    }
}
