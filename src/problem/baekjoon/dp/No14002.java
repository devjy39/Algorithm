package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14002 {
    static class Number {
        Number prev;
        int number;

        public Number(int number) {
            this.number = number;
        }

        public Number(int number, Number prev) {
            this.number = number;
            this.prev = prev;
        }
    }

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/data.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Number[] lis = new Number[n];
        int top = -1;
        lis[++top] = new Number(Integer.parseInt(st.nextToken()));

        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num > lis[top].number) {
                lis[++top] = new Number(num, lis[top - 1]);
            } else {
                int idx = binSearch(lis, top, num);
                if (lis[idx].number == num) {
                    continue;
                }

                if (idx > 0) {
                    lis[idx] = new Number(num, lis[idx - 1]);
                } else {
                    lis[idx] = new Number(num);
                }
            }
        }

        System.out.println(getResult(lis, top));
    }

    private static StringBuilder getResult(Number[] lis, int top) {
        StringBuilder result = new StringBuilder();
        result.append(top + 1).append("\n");

        Number node = lis[top];
        while (node != null) {
            lis[top--] = node;
            node = node.prev;
        }
        for (Number number : lis) {
            if (number != null) {
                result.append(number.number).append(" ");
            }
        }
        return result;
    }

    private static int binSearch(Number[] lis, int top, int num) {
        int low = 0;
        int high = top;

        while (low <= high) {
            int mid = (low + high) >> 1;

            if (num < lis[mid].number) {
                high = mid - 1;
            } else if (num > lis[mid].number) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return low;
    }

}