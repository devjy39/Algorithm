package dataStructure.linear.arrayPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class practice1 {
    public static void main(String[] args) {
        int[] arr = IntStream.range(1,10).toArray();
        double oddAverage = 0;
        double evenAverage = 0;

        evenAverage = Arrays.stream(arr).filter(i -> i % 2 == 0).average().getAsDouble();
        oddAverage = Arrays.stream(arr).filter(i -> i % 2 == 1).average().getAsDouble();

        System.out.println("evenAverage = " + evenAverage);
        System.out.println("oddAverage = " + oddAverage);

        arr = new int[]{1,1,100,1,1,1,100};
        int lastTargetIndex = 0;
        int target = 100;
        int[] finalArr = arr;
        lastTargetIndex = IntStream.range(0, arr.length)
                .filter(i-> finalArr[i]==target)
                .max().getAsInt();
        System.out.println("lastTargetIndex = " + lastTargetIndex);
        
        arr = new int[]{1,3,5,7,9};
        int first = 0;
        int last = arr.length-1;
        while (first < last) {
            swap(arr, first++, last--);
        }

        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));

        arr = new int[]{3, 1, 2, 6, 2, 2, 5, 1, 9, 10, 1, 11};
        ArrayList<Integer> peek = new ArrayList<>(); // 바로 주변보다 큰 값

        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || arr[i] > arr[i - 1]) {
                if (i == arr.length - 1 || arr[i] > arr[i + 1]) {
                    peek.add(arr[i]);
                }
            }
        }
        System.out.println(peek);

        int[][] arr2 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        };

        for (int i = 0; i < arr2[0].length; i++) {
            for (int j = arr2.length-1; j >= 0 ; j--) {
                System.out.print(arr2[j][i]+" ");
            }
            System.out.println();
        }

    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
