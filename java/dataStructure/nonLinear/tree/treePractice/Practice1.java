package dataStructure.nonLinear.tree.treePractice;// Practice1
// 종이 접기
// 종이를 반으로 접었을 때, 안으로 파인 부분은 0, 볼록 튀어나온 부분은 1이라고 하자.
// 종이를 접을 때는 오른쪽에서 왼쪽으로 접는다.
// 종이를 N번 접었을 때의 접힌 상태를 출력하는 문제를 작성하세요.

// 입출력 예시
// 입력: 1
// 출력: 0

// 입력: 2
// 출력: 0, 0, 1

// 입력: 3
// 출력: 0, 0, 1, 0, 0, 1, 1


public class Practice1 {
    public static void solution(int n) {
        int[] tree = new int[(int) (Math.pow(2, n) - 1)];
        tree[0] = 0;
        for (int i = 0; i < Math.pow(2, n - 1) - 1; i++) {
            tree[i * 2 + 1] = 0;
            tree[i * 2 + 2] = 1;
        }

        inOder(tree, 0);
        System.out.println();
    }

    public static void inOder(int[] tree, int idx) {
        int left = idx * 2 + 1;
        int right = idx * 2 + 2;
        if (left < tree.length) {
            inOder(tree,left);
        }
        System.out.print(tree[idx]+" ");
        if (right< tree.length) {
            inOder(tree,right);
        }
    }

    public static void main(String[] args) {
        // Test code
        solution(1);
        solution(2);
        solution(3);
    }
}
