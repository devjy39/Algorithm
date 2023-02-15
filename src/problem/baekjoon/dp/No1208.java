package problem.baekjoon.dp;
import java.io.*;
import java.util.*;

public class No1208 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();
        dfs(list, N / 2, 0, 0);

        Map<Integer, Integer> map = new HashMap<>();
        mapping(map, N, N / 2, 0);

        long count = S == 0 ? -1 : 0;
        for (Integer i : list) {
            count += map.getOrDefault(S - i, 0);
        }

        System.out.println(count);
    }

    private static void mapping(Map<Integer, Integer> map, int end, int idx, int sum) {
        if (idx >= end) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            return;
        }

        mapping(map, end, idx + 1, sum + arr[idx]);
        mapping(map, end, idx + 1, sum);
    }

    private static void dfs(List<Integer> list, int end, int idx, int sum) {
        if (idx >= end) {
            list.add(sum);
            return;
        }

        dfs(list, end, idx + 1, sum + arr[idx]);
        dfs(list, end, idx + 1, sum);
    }

}