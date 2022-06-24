package dataStructure.nonLinear.NonLinearDS_13_3.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice5 {
    public static double solution(String[] words) {
        List<Integer> list = new ArrayList<>();
        Trie trie = new Trie();
        Arrays.stream(words).forEach(trie::insert);
        Arrays.stream(words).forEach(word -> list.add(auto(trie, word)));
        System.out.println(list);
        return list.stream().mapToInt(i->i).average().getAsDouble();
    }

    public static int auto(Trie trie,String str) {
        int cnt = 1;
        Node cur = trie.root.child.get(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (cur.child.size() > 1 || cur.isTerminal) {
                cnt++;
            }
            cur = cur.child.get(c);
        }
        return cnt;
    }

    public static void main(String[] args) {
        // Test code
        String[] words = {"hell", "hello", "heaven", "java"};
        System.out.printf("%.2f\n", solution(words));   // (2 + 3 + 2 + 1) / 4 = 2.00

        words = new String[] {"abca", "abcb", "abcc"};  // (2 + 2 + 2) / 3 = 2.00
        System.out.printf("%.2f\n", solution(words));

        words = new String[] {"cloud", "cloudy", "rain", "rainy", "sun", "sunny"};
        System.out.printf("%.2f\n", solution(words));   // (1 + 2 + 1 + 2 + 1 + 2) / 6 = 1.50
    }
}
