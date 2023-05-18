package problem.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1963 {
    static final int MAX_PS = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        boolean[] primes = getPrimes();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int password = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            int count = getCount(primes, password, target);
            result.append(count >= 0 ? count : "Impossible").append("\n");
        }

        System.out.print(result);
    }

    private static int getCount(boolean[] primes, int password, int target) {
        boolean[] visited = new boolean[MAX_PS];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(password);
        visited[password] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            Queue<Integer> next = new LinkedList<>();

            while (!queue.isEmpty()) {
                Integer cur = queue.poll();
                if (cur == target) {
                    return count;
                }

                int unit = 1;
                for (int i = 0; i < 4; i++) {
                    addEdges(primes, visited, next, cur, unit);
                    unit *= 10;
                }

                if (visited[target]) {
                    return count + 1;
                }
            }

            queue = next;
            count++;
        }

        return -1;
    }

    private static void addEdges(boolean[] primes, boolean[] visited, Queue<Integer> queue, int cur, int unit) {
        int temp = (cur / (unit * 10) * (unit * 10)) + (cur % unit);

        for (int i = 0; i <= 9; i++) {
            int num = temp + i * unit;
            if (primes[num] && !visited[num]) {
                queue.add(num);
                visited[num] = true;
            }
        }
    }

    private static boolean[] getPrimes() {
        boolean[] primes = new boolean[MAX_PS];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;

        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                int mul = i;
                while (i * mul < primes.length) {
                    primes[i * mul] = false;
                    mul++;
                }
            }
        }

        for (int i = 0; i < 1000; i++) {
            primes[i] = false;
        }

        return primes;
    }

}


