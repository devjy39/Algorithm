package problem.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class No11652 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long key = Long.parseLong(br.readLine());
            int count = map.getOrDefault(key, 0) + 1;
            map.put(key, count);
        }

        long number = Long.MAX_VALUE;
        int maxCount = 0;
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                number = entry.getKey();
                maxCount = entry.getValue();
            } else if (entry.getValue() == maxCount) {
                number = Math.min(number, entry.getKey());
            }
        }

        System.out.println(number);
    }

}

