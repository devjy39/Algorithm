package algorithm.sort.ectSort;
// 알고리즘 - 정렬_3
/* 기수 정렬
*  낮은 자리 수부터 정렬하는 방식 - 인덱싱방식이랑 비슷
*  비교연산이 없어 빠르고, 기수 테이블 공간 메모리 필요
*  O(dn) d:최대 자릿수
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class RadixSort {
    public static void radixSort(int[] arr) {
        ArrayList<Queue<Integer>> radix = new ArrayList<>();
        IntStream.range(0, 10).forEach(i->radix.add(new LinkedList<>()));
        int maxRadix = (int) Math.log10(Arrays.stream(arr).max().getAsInt()) + 1;

        int div = 1;
        for (int n = 0; n < maxRadix; n++) {
            for (int i : arr) {
                radix.get(i / div % 10).add(i);
            }
            System.out.println(radix);

            int idx = 0;
            for (int i = 0; i < 10; i++) {
                Queue<Integer> q = radix.get(i);
                while (!q.isEmpty()) {
                    arr[idx++] = q.poll();
                }
            }
            div *= 10;
        }
    }


    public static void main(String[] args) {
        // Test code
        int[] arr = {10, 32, 52, 27, 48, 17, 99, 56};
        radixSort(arr);
        System.out.println("기수 정렬: " + Arrays.toString(arr));
    }
}
