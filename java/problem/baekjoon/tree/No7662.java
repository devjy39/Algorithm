package problem.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class No7662 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                dualPriorityQueue(map, command, n);
            }

            if (map.size() == 0) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }
        br.close();

        System.out.println(sb);
    }

    private static void dualPriorityQueue(TreeMap<Integer, Integer> map, String command, int n) {
        if (command.equals("I")) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        } else {
            if (map.size() == 0) {
                return;
            }
            int removeNum;
            if (n == 1) {
                removeNum = map.lastKey();
            } else {
                removeNum = map.firstKey();
            }

            int count = map.get(removeNum);
            if (count > 1) {
                map.put(removeNum, count - 1);
            } else {
                map.remove(removeNum);
            }
        }
    }

}