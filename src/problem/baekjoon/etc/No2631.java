package problem.baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No2631 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(getMinMove(arr));
    }

    private static int getMinMove(int[] arr) {
        List<Integer> list = new ArrayList<>();
        list.add(arr.length); // 무시됨

        for (int number : arr) {
            if (list.get(list.size() - 1) < number) {
                list.add(number);
            } else {
                int idx = Collections.binarySearch(list, number);
                if (idx < 0) {
                    list.set(-idx - 1, number);
                }
            }
        }

        return arr.length - list.size(); // 무조건 옮겨야 되는 수, 증가하는 순서가 아니므로
    }

}
