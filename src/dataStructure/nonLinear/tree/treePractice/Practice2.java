package dataStructure.nonLinear.tree.treePractice;// Practice2
// 각각의 에지에 가중치가 있는 포화 이진 트리가 있다.
// 루트에서 각 리프까지의 경로 길이를 모두 같게 설정하고,
// 이 때, 모든 가중치들의 총합이 최소가 되도록 하는 프로그램을 작성하세요.


public class Practice2 {
    static int[] arr;
    static int total;
    static int hh;

    public static void solution(int h, int[] w) {
        arr = new int[(int) Math.pow(2, h + 1) - 1];
        // 트리구조는 재귀로 순회할 때 반드시 루트가 필요해서 +1 함
        for (int i = 0; i < w.length; i++) {
            arr[i + 1] = w[i];
        }
        hh = h;
        dfs(0, 0);
        System.out.println(total);
        total = 0;
    }

    static int dfs(int idx,int h) {
        if (h == hh) {
            total += arr[idx];
            return arr[idx];
        }

        int left = dfs(idx * 2 + 1, h + 1);
        int right = dfs(idx * 2 + 2, h + 1);
        total += arr[idx] + Math.abs(left - right);
        return arr[idx] + Math.max(left, right);
    }

    public static void main(String[] args) {
        // Test code
        int h = 2;
        int[] w = {2, 2, 2, 1, 1, 3};
        // 1 -> 3,4  2 -> 5,6 /3->7,8 4-> 9,10 5-> 11,12 6-> 13,14  ,
        // 0 -> 2,3  1 -> 4,5 /2->6,7 3->8,9 4-> 10,11 5-> 12,13
        solution(h, w);
        System.out.println();

        h = 3;
        w = new int[]{1, 2, 1, 3, 2, 4, 1, 1, 1, 1, 1, 1, 1, 1};
        solution(h, w);
    }
}
