package problem.baekjoon.tree;

import java.io.*;

class Node {
    int key;
    Node next;

    public Node(int key, Node next) {
        this.key = key;
        this.next = next;
    }
}

class Tree {
    Node[] nodes;
    int size;

    public Tree(int size) {
        this.nodes = new Node[size + 1];
        this.size = size + 1;
    }

    public void addEdge(int x, int y) {
        this.nodes[x] = new Node(y, this.nodes[x]);
        this.nodes[y] = new Node(x, this.nodes[y]);
    }

}

public class Main11725 {
    static int[] result;
    static boolean[] visited;
    static Tree tree;

    public static void recursive(int key, Node node) {
        if (visited[key]) {
            return;
        }
        visited[key] = true;
        while (node != null) {
            if (!visited[node.key]) {
                result[node.key] = key;
                recursive(node.key, tree.nodes[node.key]);
            }
            node = node.next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        result = new int[n+1];
        visited = new boolean[n+1];
        tree = new Tree(n);
        for (int i = 0; i < n - 1; i++) {
            String str = br.readLine();
            String[] strArr = str.split(" ");
            tree.addEdge(Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1]));
        }
        br.close();
        recursive(1, tree.nodes[1]);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < result.length; i++) {
            sb.append(result[i] + "\n");
        }
        System.out.print(sb);
    }
}