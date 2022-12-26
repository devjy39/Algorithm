package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10986 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int mod = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] count = new int[mod];
        int[] sumMods = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            sumMods[i] = (sumMods[i - 1] + Integer.parseInt(st.nextToken())) % mod;
            count[sumMods[i]]++;
        } // 누적합의 나머지 개수 저장

        long result = count[0];
        for (int i = 0; i < mod; i++) {
            result += ((long) count[i] * (count[i] - 1)) / 2;
            // nC2 : 나머지가 같은 두 개를 선택하면 b-a는 나머지가 0이 되므로 나머지 0을 만들 수 있음.
        }

        System.out.println(result);
    }

}