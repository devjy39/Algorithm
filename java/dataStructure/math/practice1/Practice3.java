package dataStructure.math.practice1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;

public class Practice3 {
    // # 1 기본 permutation 방법  nPn +  nPn * m
    public static boolean solution(String s1, String s2) {
        ArrayList<String> list = new ArrayList<>();
        myPermutation(s1.toCharArray(), 0, list);

        for (int i = 0; i < list.size(); i++) {
            if (s2.contains(list.get(i))) {
                return true;
            }
        }

        return false;
    }

    static void myPermutation(char[] arr,int depth,ArrayList<String> list) {
        if (depth == arr.length) {
            list.add(new String(arr));
            return;
        }

        for (int i = depth; i < arr.length; i++) {
            swap(arr, depth, i);
            myPermutation(arr, depth + 1, list);
            swap(arr, depth, i);
        }
    }

    static void swap(char[] arr, int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void permutation(char[] arr, int depth, int n, int r, boolean[] visited, char[] out, ArrayList<String> list) {
        if (depth == r) {
            list.add(new String(out));
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, depth + 1, n, r, visited, out, list);
                visited[i] = false;
            }
        }
    }


    // # 2 문제 규칙 찾아 해결   n + m*26
    // 숫자나 char는 메모리에 인덱스로 쓸 수 있기에 카운팅이 가능하다. 유용한 메모리제이션 방법 **
    public static boolean solution2(String s1, String s2) {
        int[] count = new int['z' - 'a' + 1];
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }
        int l=s1.length();

        for (int i = 0; i < s2.length(); i++) {
            count[s2.charAt(i)-'a']--;
            if (i >= l) {
                count[s2.charAt(i-l)-'a']++;
            }
            OptionalInt any = Arrays.stream(count).filter(x -> x != 0).findFirst();
            System.out.println(Arrays.toString(count));
            if(any.isEmpty())
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        // Test code
        String s1 = "ab";
        String s2 = "adbak";
        System.out.println(solution(s1, s2));
        System.out.println(solution2(s1, s2));
        System.out.println();

        s1 = "ac";
        s2 = "car";
        System.out.println(solution(s1, s2));
        System.out.println(solution2(s1, s2));
        System.out.println();

        s1 = "ak";
        s2 = "aabbkk";
        System.out.println(solution(s1, s2));
        System.out.println(solution2(s1, s2));
        System.out.println();

        s1 = "akz";
        s2 = "aabbzakkk";
        System.out.println(solution(s1, s2));
        System.out.println(solution2(s1, s2));
    }
}
