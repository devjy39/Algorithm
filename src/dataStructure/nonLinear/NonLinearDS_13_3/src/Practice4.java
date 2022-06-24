package dataStructure.nonLinear.NonLinearDS_13_3.src;

import java.util.HashMap;

class Node {
    HashMap<Character, Node> child;
    boolean isTerminal;

    public Node() {
        this.child = new HashMap<>();
        this.isTerminal = false;
    }
}

class Trie {
    Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String str) {
        Node cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            cur.child.putIfAbsent(c, new Node());
            cur = cur.child.get(c);

            if (i == str.length() - 1) {
                cur.isTerminal = true;
                return;
            }
        }
    }

    public boolean search(String str) {
        Node cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!cur.child.containsKey(c)) {
                return false;
            }
            cur = cur.child.get(c);
            if (cur.isTerminal) {
                return true;
            }
        }

        return true;
    }
}

public class Practice4 {
    public static boolean solution(String[] nums) {
        Trie trie = new Trie();
        trie.insert(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (trie.search(nums[i])) {
                return false;
            } else {
                trie.insert(nums[i]);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Test code
        String[] nums = {"911", "123456789", "911234"};
        System.out.println(solution(nums)); // false

        nums = new String[]{"113", "12345", "12344", "98765"};
        System.out.println(solution(nums)); // true

    }
}
