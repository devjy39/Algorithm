package problem.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11758 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] x = new int[3];
        int[] y = new int[3];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        int ccw = (x[0] * y[1] + x[1] * y[2] + x[2] * y[0])
                        - (x[0] * y[2] + x[1] * y[0] + x[2] * y[1]);

        /*  Counter Clock Wise 알고리즘, 세 점의 방향을 구한다.
        *   시작 점으로부터 두 점의 벡터를 구한 후 두 벡터를 외적하여 방향을 구한다.
        *   시계방향 음수, 직선 0 , 반시계 방향 양수
        * */

        System.out.println(Integer.compare(ccw, 0));
    }

}