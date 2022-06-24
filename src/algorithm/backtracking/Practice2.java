package algorithm.backtracking;
// Practice2
// 숫자 7193 은 7193 도 소수이고,
// 719, 71, 7 도 각각 소수이다.
// n 이 주어졌을 때, n 자리 수 중에 위와 같은 소수를 찾는 프로그램을 작성하세요.

// 입출력 예시
// 입력 n: 3
// 출력: 233, 239, 293, 311, 313, 317, 373, 379, 593, 599, 719, 733, 739, 797


import java.util.ArrayList;

public class Practice2 {
    public static ArrayList<Integer> result;
    static int[] PRIME = {1, 3, 7, 9};

    public static ArrayList<Integer> solution(int n) {
        result = new ArrayList<>();
        int[] d = {2, 3, 5, 7};

        for (int i : d) {
            prime(n, 1, i);
        }

        return result;
    }

    public static void prime(int n, int depth, int num) {
        if (depth == n) {
            result.add(num);
            return;
        }

        for (int i : PRIME) {
            int temp = num * 10 + i;
            if (isPrimeNbr(temp)) {
                prime(n, depth + 1, temp);
            }
        }
    }

    public static boolean isPrimeNbr(int num) {
        int max = (int) Math.sqrt(num);
        for (int i = 3; i <= max; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(3));
        System.out.println();
        System.out.println(solution(4));
    }
}
