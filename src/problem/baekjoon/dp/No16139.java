package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No16139 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[][] array = accumulateSum(str);

        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ch = st.nextToken().charAt(0) - 97;
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            result.append(array[end + 1][ch] - array[start][ch]).append("\n");
        }
        br.close();

        System.out.print(result);
    }

    private static int[][] accumulateSum(String str) {
        int[][] array = new int[str.length() + 1][26]; // 97 ~ 122  [26]

        for (int i = 1; i <= str.length(); i++) {
            System.arraycopy(array[i - 1], 0, array[i], 0, 26);
            array[i][str.charAt(i - 1) - 97]++;
        }
        return array;
    }

}