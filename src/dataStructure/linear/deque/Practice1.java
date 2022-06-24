package dataStructure.linear.deque;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Practice1 {
    /*
    *   input data = 1 2 3 4 5
    *   output data = 1 5 2 4 3
    * */
    static void reorder(int[] arr) {
        Deque<Integer> deque = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.stream(arr).forEach(i -> deque.add(i));

        while (!deque.isEmpty()) {
            result.add(deque.removeFirst());
            if(!deque.isEmpty())
                result.add(deque.removeLast());
        }

        System.out.println(result);
    }

    static boolean palindrome(String str) {
        Deque<Character> deque = new ArrayDeque();
        for (char c : str.toCharArray()) {
            deque.add(c);
        }

        while (!deque.isEmpty()) {
            char front = deque.removeFirst();
            char back = deque.size() == 0 ? 0 :deque.removeLast();
            if (front != back && back != 0) {
                return false;
            }
        }
        return true;
    }


    static char ch;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reorder(arr);

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        reorder(arr2);

        System.out.println(palindrome("a"));
        System.out.println(palindrome("aba"));
        System.out.println(palindrome("abba"));
        System.out.println(palindrome("abab"));
        System.out.println(palindrome("abcba"));
        System.out.println(palindrome("abccba"));
        System.out.println(palindrome("madam"));

    }
}
