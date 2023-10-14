package problem.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10867 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] exist = new boolean[2001];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            exist[Integer.parseInt(st.nextToken()) + 1000] = true;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < exist.length; i++) {
            if (exist[i]) {
                result.append(i - 1000).append(" ");
            }
        }
        System.out.println(result);
    }

}
