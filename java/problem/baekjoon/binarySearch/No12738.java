package problem.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No12738 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt(st.nextToken()));

        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num > list.get(list.size() - 1)) {
                list.add(num);
            } else {
                int idx = Collections.binarySearch(list, num);
                if (idx < 0) {
                    list.set(-idx - 1, num);
                }
            }
        }

        System.out.println(list.size());
    }

}