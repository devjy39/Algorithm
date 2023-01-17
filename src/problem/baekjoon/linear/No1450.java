package problem.baekjoon.linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No1450 {
    static int[] arr;
    static int target;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/data.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        int capacity = (int) Math.pow(2, n % 2 == 0 ? n / 2 : n / 2 + 1); // 메모리 최적화
        List<Integer> list1 = new ArrayList<>(capacity);
        List<Integer> list2 = new ArrayList<>(capacity);
        numberOfCases(list1, 0, n / 2 - 1, 0);
        numberOfCases(list2, n / 2, n - 1, 0);
        Collections.sort(list2);

        int count = 0;
        for (Integer num : list1) {
            count += upperBound(list2, target - num);
        }

        System.out.println(count);
    }

    static int upperBound(List<Integer> list, int value) { // value 보다 작거나 같은 수 개수
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;

            if (list.get(mid) <= value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private static void numberOfCases(List<Integer> list, int left, int right, int sum) { // 경우의 수 세기
        if (left > right) {
            list.add(sum);
            return;
        }
        if (sum > target) {
            return;
        }

        numberOfCases(list, left + 1, right, sum);
        numberOfCases(list, left + 1, right, sum + arr[left]);
    }

}