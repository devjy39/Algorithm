package dataStructure.nonLinear.trie;// 비선형 자료구조 - 트라이 (Trie)
/* 트라이 = 문자열을 저장,탐색 하기위한 정렬된 트리
*  메모리가 필요하지만 탐색이 O(N)
* */

import java.util.HashMap;

class Node {
    HashMap<Character,Node> child;
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
        Node node = root;
        for (char c : str.toCharArray()) {
            node.child.putIfAbsent(c, new Node());
            node = node.child.get(c);
        }

        node.isTerminal = true;
    }

    public boolean search(String str) {
        Node node = this.root;
        for (char c : str.toCharArray()) {
            if (!node.child.containsKey(c)) {
                return false;
            }
            node = node.child.get(c);
        }

        return node.isTerminal;
    }

    public void delete(String str) {
        delete(str, 0, root);
    }

    public boolean delete(String str, int idx, Node node) {
        if (idx == str.length()) {
            if (node.child.isEmpty()) {
                return true; // 야 나 지워
            } else {
                node.isTerminal = false;
                return false; //지우지맛 사람있다
            }
        }

        Node child = node.child.get(str.charAt(idx));
        if (child != null && delete(str, idx + 1, child)) {
            if (!node.isTerminal) {
                node.child.remove(str.charAt(idx));
                return node.child.isEmpty();
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        // Test code
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("april");
        trie.insert("app");
        trie.insert("ace");
        trie.insert("bear");
        trie.insert("best");
        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("april"));   // true
        System.out.println(trie.search("app"));      // true
        System.out.println(trie.search("ace"));     // true
        System.out.println(trie.search("bear"));    // true
        System.out.println(trie.search("best"));    // true
        System.out.println(trie.search("abc"));     // false

        System.out.println();
        trie.delete("apple");
        System.out.println(trie.search("apple"));   // false
        System.out.println(trie.search("april"));   // true
        System.out.println(trie.search("appl"));    // false
        trie.delete("apple");
    }
}
