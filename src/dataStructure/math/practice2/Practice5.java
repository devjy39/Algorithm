package dataStructure.math.practice2;

public class Practice5 {

    public static void solution(int n) {
        hanoi(n, 1, 2, 3);
    }

    /*
    *   재귀적인 움직임으로 표현하면
    *   1. 한 칸 작은 원판은 무조건 1에서 2로
    *   2. 가장 큰 원판은 무조건 1에서 3으로
    *   3. 한 칸 작은 원판은 1.에서 간 곳에서 3으로
    *   4. 1인 탈출문은 n에따라 번갈아가며 2또는 3으로
     */
    static void hanoi(int n, int start, int mid, int end) {
        if (n == 1) {
            System.out.println(n+" 1출력 -> "+start+" "+end);
            return;
        }

        hanoi(n - 1, start, end, mid); // 하나 작은 원판 1 -> 2 이동
        System.out.println(n+" 2출력 -> "+start + " " + end); // 가장 큰 원판 1 -> 3 이동
        hanoi(n - 1, mid, start, end); // 하나 작은 2로간 원판 2 -> 3 이동
    }

    public static void main(String[] args) {
        // Test code
        solution(1);
        System.out.println();

        solution(2);
        System.out.println();

        solution(3);
        System.out.println();

        solution(4);
    }
}
