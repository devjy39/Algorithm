package problem.baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No1965 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getLISLength(arr));
    }

    private static int getLISLength(int[] arr) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > list.get(list.size() - 1)) {
                list.add(arr[i]);
            } else {
                int idx = Collections.binarySearch(list, arr[i]);
                if (idx < 0) {
                    idx = -idx - 1;
                }

                list.set(idx, arr[i]);
            }
        }
        
        return list.size();
    }

}

