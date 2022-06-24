package dataStructure.nonLinear.NonLinearDS_13_2.src;

import java.util.ArrayList;

class Node {
    Character character;
    Node next;

    public Node(Character child,boolean isUpper) {
        this.character = child;
    }
    public Node() {
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

            cur.next = new Node(c, Character.isUpperCase(c));
            cur = cur.next;

            if (i == str.length() - 1) {
                return;
            }
        }
    }

    public boolean search(String str) {
        Node cur = this.root.next;
        boolean end = false;
        for (char c : str.toCharArray()) {
            if (cur.character == c) {
                if (cur.next == null) {
                    end = true;
                } else {
                    cur = cur.next;
                }
            } else {
                if (Character.isUpperCase(c)) {
                    return false;
                } else if(Character.isLowerCase(cur.character) && !end){
                    return false;
                }
            }
        }

        return end;
    }
}

public class Practice5 {
    public static ArrayList<Boolean> solution(String[] queries, String pattern) {
        Trie trie = new Trie();
        trie.insert(pattern);
        ArrayList<Boolean> result = new ArrayList<>();

        for (String query : queries) {
            result.add(trie.search(query));
        }

        return result;
    }

    public static void main(String[] args) {
        // Test code
        String[] queries = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack","FaoBa"};
        String pattern = "FB";
        System.out.println(solution(queries, pattern));

        pattern = "FoBa";
        System.out.println(solution(queries, pattern));

        pattern = "FoBaT";
        System.out.println(solution(queries, pattern));
    }
}
