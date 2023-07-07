package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No1351 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        dp.put(0L, 1L);
        System.out.println(dfs(n));
    }

    static Map<Long, Long> dp = new HashMap<>();
    static int p,q;

    static long dfs(long n) {
        if (dp.containsKey(n)) {
            return dp.get(n);
        }

        long result = dfs(n / q) + dfs(n / p);
        dp.put(n, result);
        return result;
    }

}

