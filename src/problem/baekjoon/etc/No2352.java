package problem.baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No2352 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> connections = new ArrayList<>(n);
        connections.add(40_000);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());

            if (number > connections.get(connections.size() - 1)) {
                connections.add(number);
            } else {
                int idx = Collections.binarySearch(connections, number);
                connections.set(idx < 0 ? -(idx + 1) : idx, number);
            }
        }

        System.out.println(connections.size());
    }

}

