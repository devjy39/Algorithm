package problem.baekjoon.linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No2346 {
    static class Balloon {
        int idx;
        int number;

        public Balloon(int idx, int number) {
            this.idx = idx;
            this.number = number;
        }

        @Override
        public String toString() {
            return String.valueOf(idx);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Balloon> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            list.add(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        StringBuilder result = new StringBuilder();
        while (!list.isEmpty()) {
            Balloon balloon = list.remove(0);
            result.append(balloon.idx).append(" ");
            balloon.number = balloon.number > 0 ? balloon.number - 1 : balloon.number;
            Collections.rotate(list, -balloon.number);
        }

        System.out.println(result);
    }

}
