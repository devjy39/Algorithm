package problem.baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No4158 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        String read;
        while (!(read = br.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(read);

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] arr1 = new int[n];
            int[] arr2 = new int[m];
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(br.readLine());
            }
            for (int i = 0; i < m; i++) {
                arr2[i] = Integer.parseInt(br.readLine());
            }

            result.append(getEqualNumberCount(arr1, arr2)).append("\n");
        }

        System.out.print(result);
    }

    private static int getEqualNumberCount(int[] arr1, int[] arr2) {
        int count = 0;
        int left = 0;
        int right = 0;

        while (left < arr1.length && right < arr2.length) {
            if (arr1[left] < arr2[right]) {
                left++;
            } else if (arr1[left] > arr2[right]) {
                right++;
            } else {
                count++;
                left++;
                right++;
            }
        }

        return count;
    }

}
