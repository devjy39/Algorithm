package problem.baekjoon.divide_conquer;

import java.util.Scanner;

/* 분할정복 문제
*  */
public class Main1992 {
    static String[] image;
    static String answer = "";

    static void di_con(int x, int y, int l) {
        int num = count(x,y,l);
        if (num != -1) {
            answer+=num;
            return;
        }
        answer += "(";
        l/=2;
        for (int i=0;i<4;i++)
            di_con(x + ((i % 2) * l), y + ((i / 2) * l), l);
        answer += ")";
    }

    static int count(int x, int y, int l) {
        char value = image[y].charAt(x);
        for (int i = x; i < x+l; i++) {
            for (int j = y; j < y+l; j++) {
                if(image[j].charAt(i) !=value)
                    return -1;
            }
        }
        return value-'0';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        image = new String[n];
        for (int i = 0; i < n; i++) {
            image[i] = sc.next();
        }

        di_con(0,0,n);
        System.out.println(answer);
        sc.close();
    }
}