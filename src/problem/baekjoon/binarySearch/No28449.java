package problem.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No28449 {
    static class Number {
        int number;
        int count;
        int countSum;

        public Number(int number, int count) {
            this.number = number;
            this.count = count;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        List<Number> list1 = getNumbers(n, st);
        st = new StringTokenizer(br.readLine(), " ");
        List<Number> list2 = getNumbers(m, st);

        long draw = 0;
        long win = 0;

        for (Number number : list1) {
            int idx = Collections.binarySearch(list2, number, Comparator.comparingInt(num -> num.number));
            if (idx >= 0) {
                draw += (long) number.count * list2.get(idx).count;
                if (idx - 1 >= 0) {
                    win += (long) list2.get(idx - 1).countSum * number.count;
                }
            } else if (-idx - 2 >= 0) {
                win += (long) list2.get(-idx - 2).countSum * number.count;
            }
        }

        System.out.println(win + " " + ((long) n * m - win - draw) + " " + draw);
    }

    private static List<Number> getNumbers(int n, StringTokenizer st) {
        int[] arr1 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);

        List<Number> list = new ArrayList<>();
        list.add(new Number(arr1[0], 1));
        for (int i = 1; i < n; i++) {
            if (list.get(list.size() - 1).number == arr1[i]) {
                list.get(list.size() - 1).count++;
            } else {
                list.add(new Number(arr1[i], 1));
            }
        }

        list.get(0).countSum = list.get(0).count;
        for (int i = 1; i < list.size(); i++) {
            list.get(i).countSum += list.get(i).count + list.get(i - 1).countSum;
        }
        return list;
    }

}

