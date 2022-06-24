package problem.baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main9184 {

    static int[][][] memory = new int[21][21][21];

    static int w(int a, int b, int c) {
        if (a<1 || b<1 || c<1)
            return 1;
        if (a>20 || b>20 || c>20)
            return w(20, 20, 20);
        if (memory[a][b][c]!=0)
            return memory[a][b][c];

        if (a<b && b<c)
            memory[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        else
            memory[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        return memory[a][b][c];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a==-1 && b==-1 && c==-1) break;

            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));
        }
        br.close();
    }
}