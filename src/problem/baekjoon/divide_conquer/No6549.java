package problem.baekjoon.divide_conquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No6549 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        String read;
        while (!(read = br.readLine()).equals("0")) {
            StringTokenizer st = new StringTokenizer(read);
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            result.append(divideConquer(arr, 0, n - 1)).append('\n');
        }

        System.out.print(result);
    }

    private static long divideConquer(int[] arr, int left, int right) {
        if (left >= right) {
            return left == right ? arr[left] : 0;
        }

        int mid = (left + right) >> 1;

        return Math.max(calculateMaxArea(arr, left, mid, right),
                Math.max(divideConquer(arr, left, mid - 1), divideConquer(arr, mid + 1, right)));
    }

    /*
        가운데가 포함된 케이스를 투포인터로 O(n)으로 처리하는게 핵심.
        그렇게 총 nlogn의 시간복잡도를 완성.
    * */
    private static long calculateMaxArea(int[] arr, int min, int mid, int max) {
        int height = arr[mid];
        long maxArea = height;
        long count = 1;
        int left = mid - 1;
        int right = mid + 1;

        while (left >= min && right <= max) {
            if (arr[left] > arr[right]) {
                height = Math.min(height, arr[left--]);
            } else {
                height = Math.min(height, arr[right++]);
            }

            maxArea = Math.max(maxArea, ++count * height);
        }

        while (left >= min) {
            height = Math.min(height, arr[left--]);
            maxArea = Math.max(maxArea, ++count * height);
        }

        while (right <= max) {
            height = Math.min(height, arr[right++]);
            maxArea = Math.max(maxArea, ++count * height);
        }

        return maxArea;
    }

}