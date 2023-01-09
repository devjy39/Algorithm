package problem.baekjoon.linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class No17299 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        int[] counts = new int[max + 1];
        for (int num : arr) {
            counts[num]++;
        }

        System.out.print(getNFGToString(counts, arr));
    }

    private static String getNFGToString(int[] counts, int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            int ngf = counts[arr[i]];
            while (!stack.isEmpty() && counts[arr[stack.peek()]] < ngf) {
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }

        StringBuilder result = new StringBuilder();
        for (int num : arr) {
            result.append(num).append(" ");
        }

        return result.toString();
    }

}