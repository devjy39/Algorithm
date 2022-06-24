package dataStructure.math.practice2;

import java.util.Arrays;

public class Practice3 {
    public static String solution(String equation) {
        String result = "";
        String[] split = equation.split("=");

        int[] a = evaluate(split[0]);
        int[] b = evaluate(split[1]);

        int x = b[0] - a[0];
        int c = a[1] - b[1];

        return x == 0 ? (c==0?"Infinite solutions":"No solution") : "x=" + c / x;
    }

    public static int[] evaluate(String str) {
        int xcnt = 0;
        int ccnt = 0;
        int sign = 1;
        int num = 1;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '+') {
                sign = 1;
                num = 1;
            } else if (c == '-') {
                sign = -1;
                num = 1;
            } else {
                if (c == 'x') {
                    if (num != 1)
                        ccnt -= num * sign;
                    xcnt += num * sign;
                } else {
                    num = c - '0';
                    ccnt += num * sign;
                }
            }
        }

        return new int[]{xcnt, ccnt};
    }

    // # 2 정규표현식 사용
    public static int[] evaluate2(String str) {
        String[] arr = str.split("(?=[-+])"); // +,-  regular expression
        System.out.println("정규표현식으로 분해 : "+Arrays.toString(arr));



        return null;
    }

    public static void main(String[] args) {
        // Test code
        String equation = "x+5-3+x=6+x-2";
        evaluate2(equation);
        System.out.println(solution(equation));

        equation = "x=x";
        evaluate2(equation);
        System.out.println(solution(equation));

        equation = "2x=x";
        evaluate2(equation);
        System.out.println(solution(equation));
    }
}
