package algorithm.ectSort;
/* 계수 정렬
*  카운트로 일일이 세서 정렬하는 방식 - 범위가 매우 짧을 때 유효
*  카운팅 메모리 필요
*  O(n + k) k: 데이터의 최대 값
*  */
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class CountingSort {
    public static void countingSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt(); //O(n)
        int[] count = new int[max + 1];
        Arrays.stream(arr).forEach(i -> count[i]++); //O(n)

        int idx = 0;
        for (int i = 0; i < count.length; i++) { // O(K)
            if (count[i]-- > 0) {
                arr[idx++] = i--;
            }
        }

        // ----------------- map으로 구현 -> 공간복잡도와 max값 찾는 비용을 줄임
        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        Arrays.stream(arr).forEach(i -> countMap.put(i, countMap.getOrDefault(i, 0) + 1));
        //O(n)
        idx = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {// O(k)
            for (int i = 0; i < entry.getValue(); i++) {
                arr[idx++] = entry.getKey();
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {10, 32, 10, 27, 32, 17, 99, 56};
        countingSort(arr);
        System.out.println("계수 정렬: " + Arrays.toString(arr));
    }
}
