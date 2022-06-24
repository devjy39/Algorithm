package dataStructure;

import java.util.stream.IntStream;

public class Recursion {

    static void permutation(int[] arr, int depth, int r) {
        if (depth == r) {
            IntStream.range(0, 3).forEach(i -> System.out.print(arr[i] + " "));
            System.out.println();
            return;
        }

        for (int i = depth; i < arr.length; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, r);
            swap(arr, depth, i);
        }
    }

    static void combination(int[] arr, int depth, int r, int pre) {
        if (depth == r) {
            IntStream.range(0, 3).forEach(i -> System.out.print(arr[i] + " "));
            System.out.println();
            return;
        }

        for (int i = pre; i < arr.length; i++) {
            swap(arr, depth, i);
            combination(arr, depth + 1, r, i + 1);
            swap(arr, depth, i);
        }
    }

    //visited 사용 방식
    static void combinationT(int[] arr, boolean[] visited, int depth, int n, int r) {
        if (r == 0) {
            IntStream.range(0, 4).forEach(i -> {
                if (visited[i])
                    System.out.print(arr[i] + " ");
            });
            System.out.println();
            return;
        }

        if (depth == n) {
            return;
        }

        visited[depth] = true;
        combinationT(arr, visited, depth + 1, n, r - 1);
        visited[depth] = false;

        combinationT(arr, visited, depth + 1, n, r);
    }

    /* 유클리드호제법
     * ``큰 수와 작은 수의 최대배수 차이``가 구하는 약수의 배수 일 것이다.
     * 그럼 또 작은 수와 ``구한 수의 최대배수 차이``가 구하는 약수의 배수이다. 이것 반복
     * ex) (35, 28) -> 두 수의 차이 7은 구하는 어떠한 약수의 배수가 되어야 한다. (본인인 7이 약수)
     *  결국 두 수의 나머지가 0인 수가 나오는길 구하는 과정
     * */
    static int gcd(int a, int b) {
        System.out.printf("%d %% %d = %d\n", a, b, a % b);
        if (a % b == 0) {
            return b;
        }
        return (gcd(b, a % b));
    }

    static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    /*  바빌로니아 법
        sqrt 루트 구현 -> sqrt(n) = Xn + E -> 전개한다. E는 아주 작은 소수
        Xn+1 = 1/2 * (Xn + n/Xn) 을 반복해서 근사치에 가깝게
    * */
    static double sqrt(int n) {
        double result = 1;
        int iter = 10;  // 높을수록 근사치가 정확해짐.
        for (int i = 0; i < iter; i++) {
            result = (result + (n / result)) / 2;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        //permutation(arr,0,3);
        //combination(arr, 0, 3, 0);
        //combinationT(arr, new boolean[4], 0, 4, 3);
        //System.out.println(gcd(18, 96));
        System.out.println(sqrt(90));

    }
}
