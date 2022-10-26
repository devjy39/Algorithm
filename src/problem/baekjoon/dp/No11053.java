package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No11053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>(n);
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        list.add(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (list.get(list.size() - 1) < num) {
                list.add(num);
            } else {
                list.set(binSearch(list, num), num);
            }
        }

        System.out.println(list.size());
    }

    private static int binSearch(List<Integer> list, int num) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;

            if (num < list.get(mid)) {
                high = mid - 1;
            } else if (num > list.get(mid)) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return low;
    }
}