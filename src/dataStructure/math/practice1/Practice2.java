package dataStructure.math.practice1;

import java.util.Arrays;

public class Practice2 {
    // 1번의 스왑으로 그 수보단 작지만 가장 큰 수를 만들어라.
    // 불가능하면 그냥 입력값 출력
    public static void solution(int[] arr) {
        int target = 0;
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                target = i - 1;
                max = i;
            } else {
                if (arr[i] < arr[target])
                    max = i;
            }
        }

        if (target != 0) {
            int temp = arr[target];
            arr[target] = arr[max];
            arr[max] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 2, 1};
        solution(arr);

        arr = new int[]{5,1,2,3};
        solution(arr);

        arr = new int[]{1, 9, 4, 7, 6};
        solution(arr);

        arr = new int[]{1, 1, 2, 3};
        solution(arr);
    }
}
