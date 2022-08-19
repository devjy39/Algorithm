package problem.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class No15666 {
    static StringBuilder result;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> list = set.stream().sorted().collect(Collectors.toList());

        result = new StringBuilder();

        dfs(list, 0, 0, new StringBuilder());
        System.out.println(result);
    }

    private static void dfs(List<Integer> list, int idx, int count, StringBuilder str) {
        if (count == m) {
            result.append(str).append("\n");
            return;
        }

        for (int i = idx; i < list.size(); i++) {
            dfs(list, i, count + 1, new StringBuilder().append(str).append(list.get(i)).append(" "));
        }
    }
}