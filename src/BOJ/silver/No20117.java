package BOJ.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No20117 {
    static int N;
    static int[] arr;

    private static int solution() {
        Arrays.sort(arr);
        int sum = N % 2 == 1 ? arr[N >> 1] : 0;
        int end = (N + 1) >> 1;

        for (int i = N - 1; i >= end; i--) {
            sum += arr[i] << 1;
        }

        return sum;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solution());
    }


}
