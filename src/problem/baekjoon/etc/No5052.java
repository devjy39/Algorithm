package problem.baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No5052 {
    static class Node {
        Node[] child = new Node[10];
        int size;
        boolean isTerminal;
    }

    static class Trie {
        Node head = new Node();

        public boolean add(String str) {
            Node node = head;

            for (int i = 0; i < str.length(); i++) {
                int number = str.charAt(i) - '0';

                if (node.child[number] == null) {
                    node.child[number] = new Node();
                    node.size++;
                }
                node = node.child[number];
                if (node.isTerminal) {
                    return true;
                }
            }

            node.isTerminal = true;
            return node.size > 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder results = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            String[] phoneNumbers = new String[n];
            for (int i = 0; i < n; i++) {
                phoneNumbers[i] = br.readLine();
            }

            Trie trie = new Trie();
            boolean result = true;

            for (String phoneNumber : phoneNumbers) {
                if (trie.add(phoneNumber)) {
                    result = false;
                    break;
                }
            }

            results.append(result ? "YES\n" : "NO\n");
        }

        System.out.print(results);
    }

}

