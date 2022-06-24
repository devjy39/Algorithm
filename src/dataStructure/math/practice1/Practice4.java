package dataStructure.math.practice1;

public class Practice4 {
    public static boolean solution(int n) {
        int firstNum = n = happyNum(n);

        do {
            n = happyNum(n);
        } while (n != 1 && n != firstNum);

        return n == 1 ? true : false;
    }

    static int happyNum(int n) {
        int sum=0;
        while (n != 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(19));
        System.out.println(solution(2));
        System.out.println(solution(61));
    }
}
