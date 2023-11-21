package problem.baekjoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class No7785 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeSet<String> names = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String behavior = st.nextToken();

            if (behavior.equals("enter")) {
                names.add(name);
            } else {
                names.remove(name);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String s : names) {
            result.append(s).append('\n');
        }
        System.out.print(result);
    }

}
