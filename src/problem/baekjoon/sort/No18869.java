package problem.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No18869 {
    static class Planet implements Comparable<Planet>{
        int idx;
        int num;

        public Planet(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }

        @Override
        public int compareTo(Planet o) {
            return this.num - o.num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        Map<String, Integer> univ = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String sequence = getSequence(br.readLine(), n);
            univ.put(sequence, univ.getOrDefault(sequence, 0) + 1);
        }

        System.out.println(getSumOfCases(univ));
    }

    private static int getSumOfCases(Map<String, Integer> univ) {
        int result = 0;
        for (Integer value : univ.values()) {
            if (value == 1) {
                continue;
            }
            result += (value * (value - 1)) >> 1;
        }
        return result;
    }

    private static String getSequence(String readLine, int n) {
        List<Planet> list = new ArrayList<>(n);
        StringTokenizer st = new StringTokenizer(readLine);
        for (int i = 0; i < n; i++) {
            list.add(new Planet(i, Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);

        int[] seq = new int[n];
        int prev = 0;
        int idx = 0;

        for (Planet planet : list) {
            seq[planet.idx] = prev == planet.num ? idx : ++idx;
            prev = planet.num;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : seq) {
            sb.append(i);
        }

        return sb.toString();
    }

}