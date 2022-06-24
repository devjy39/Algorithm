package algorithm.binarySearch;// 자바 기본 binarySearch

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60};

        System.out.println("자바에서 제공하는 binarySearch");
        System.out.println(Arrays.binarySearch(arr, 30));
        System.out.println("없는 값을 넣을 경우");
        System.out.println(Arrays.binarySearch(arr, 35)+" -> 있다면 있었을 인덱스의 -값으로 return");
    }
}
