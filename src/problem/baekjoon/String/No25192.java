package problem.baekjoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class No25192 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.equals("ENTER")) {
                count += set.size();
                set.clear();
            } else {
                set.add(str);
            }
        }

        count += set.size();
        System.out.println(count);
    }

}

