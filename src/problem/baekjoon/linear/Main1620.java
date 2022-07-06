package problem.baekjoon.linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] dict = new String[n + 1];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            map.put(dict[i] = br.readLine(), i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String quiz = br.readLine();
            if (Character.isDigit(quiz.charAt(0))) {
                sb.append(dict[Integer.parseInt(quiz)]).append("\n");
            } else {
                sb.append(map.get(quiz)).append("\n");
            }
        }
        br.close();
        System.out.println(sb);
    }

}