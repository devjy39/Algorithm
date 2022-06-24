package dataStructure.linear.PracticeProblem.LinearDS_14_1.src;

import java.util.Arrays;

public class Practice1 {

    public static int[] solution(int[] arr){
        int[] arrNew = new int[arr.length];
        int idx = 0;

        for (int num : arr) {
            while (arrNew[idx] != 0) {
                idx = (idx + 1) % arrNew.length;
            }
            arrNew[idx] = num;
            idx = (idx + num) % arr.length;
        }

        return arrNew;
    }

    public static int[] modification(int[] arr) {
        int[] arrNew = new int[arr.length];

        int idx = 0;
        int cnt = 0;
        int val = arr[idx];

        while (cnt < arr.length) {
            while (val == 0) {
                idx = (idx + 1) % arr.length;
                val = arr[idx];
            }
            arrNew[cnt++] = val;
            arr[idx] = 0;
            idx = (val + idx) % arr.length;
            val = arr[idx];
        }
        return arrNew;
    }


    public static void main(String[] args) {
        // Test code
        // Modification test
        int[] arr = {1, 3, 7, 9, 5}; //  1 3 5 7 9
        int[] arrNew = modification(arr);
        System.out.println(Arrays.toString(arrNew));

        // Revert data
        arr = new int[]{1, 3, 5, 7, 9};
        int[] arrOrigin = solution(arr);
        System.out.println(Arrays.toString(arrOrigin));

        arr = new int[]{3, 2, 6, 8};
        arrOrigin = solution(arr);
        System.out.println(Arrays.toString(arrOrigin));

        arr = new int[]{4,2,3,5,1};
        arrOrigin = solution(arr);
        System.out.println(Arrays.toString(arrOrigin));
    }
}
