package problem.baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    사분면 - bit, 구현

    1,2,3,4 분면으로 표현된 좌표를 각 숫자들의 사분면 순서를 가지고 bit로 표현하고 그 비트로 몇번째 위치한 좌표인지를 구할 수 있다.

    예를들어 x축 기준으로 보자, 2 또는 3 이면 0, 1 또는 4이면 1로 표현하면 비트로 왼쪽부터 몇번째 위치인지를 구할 수 있다.

    y축도 똑같이 진행하면
    x축에서 몇번째, y축에서 몇번째인 좌표인지를 구할 수 있고, 이동해야 하는만큼 이동 후 범위에서 벗어나면 -1을 반환하고 아니라면
    더해서 몇번째인지 좌표를 구한 후 다시 규칙에 맞춰 사분면 숫자로 변환하면 된다.

     이 때 나는 배열로 만들어서
     x: 0, y: 0  => 2
     x: 0, y: 1  => 3
     x: 1, y: 0  => 1
     x: 1, y: 1  => 4
     이런식으로 저장해놓고 변환하였다.

    t.c = O(d)
    https://www.acmicpc.net/problem/1891
* */

public class No1891 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int d = Integer.parseInt(st.nextToken());
        String number = st.nextToken();

        st = new StringTokenizer(br.readLine(), " ");
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());

        System.out.println(movePoint(number, d, x, -y));
    }

    /** 2 3 -> 0, 1 4 -> 1 */
    static final char[] X_BIT = {0, '1', '0', '0', '1'};
    /** 1 2 -> 0, 3 4 -> 1 */
    static final char[] Y_BIT = {0, '0', '0', '1', '1'};
    /** 00 -> 2, 01 -> 3, 10 -> 1, 11 -> 4 */
    static final char[] PARSE = {'2', '3', '1', '4'};

    private static String movePoint(String number, int d, long x, long y) {
        long maxSize = 1L << d;
        char[] xBit = new char[d];
        long xCount = getCount(xBit, X_BIT, number, x);
        if (xCount < 0 || xCount >= maxSize) {
            return "-1";
        }

        extractBit(xBit, xCount);

        // y
        char[] yBit = new char[d];
        long yCount = getCount(yBit, Y_BIT, number, y);
        if (yCount < 0 || yCount >= maxSize) {
            return "-1";
        }

        extractBit(yBit, yCount);

        return parseToPoint(d, xBit, yBit);
    }

    /** 비트를 사분면 좌표로 */
    private static String parseToPoint(int d, char[] xBit, char[] yBit) {
        char[] result = new char[d];
        for (int i = 0; i < result.length; i++) {
            int bitX = xBit[i] - '0';
            int bitY = yBit[i] - '0';

            result[i] = PARSE[bitX * 2 + bitY];
        }

        return String.valueOf(result);
    }

    private static long getCount(char[] bit, char[] parse, String number, long delta) {
        for (int i = 0; i < bit.length; i++) {
            bit[i] = parse[number.charAt(i) - '0'];
        }

        return Long.parseLong(String.valueOf(bit), 2) + delta;
    }

    private static void extractBit(char[] bit, long count) {
        Arrays.fill(bit, '0');
        String bitString = Long.toBinaryString(count);
        int idx = bit.length - 1;

        for (int i = bitString.length() - 1; i >= 0; i--) {
            bit[idx--] = bitString.charAt(i);
        }
    }
}
