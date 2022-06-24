package dataStructure.nonLinear.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

class Node {
    char data;
    Node left;
    Node right;

    public Node(char data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class LinkedBinaryTree {
    Node root;

    public LinkedBinaryTree(char[] arr) {
        Node[] nodes = new Node[arr.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(arr[i], null, null);
        }

        for (int i = 0; i < arr.length; i++) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;

            if (left < arr.length) {
                nodes[i].left = nodes[left];
            }

            if (right < arr.length) {
                nodes[i].right = nodes[right];
            }
        }

        this.root = nodes[0];
    }

    public void preOrder(Node node) {
        System.out.print(node.data + " -> ");

        if (node.left != null) {
            preOrder(node.left);
        }

        if (node.right != null) {
            preOrder(node.right);
        }
    }

    public void inOrder(Node node) {
        if (node.left != null) {
            inOrder(node.left);
        }

        System.out.print(node.data + " -> ");

        if (node.right != null) {
            inOrder(node.right);
        }
    }
    public void postOrder(Node node) {
        if (node.left != null) {
            postOrder(node.left);
        }

        if (node.right != null) {
            postOrder(node.right);
        }

        System.out.print(node.data + " -> ");
    }

    public void leverOrder(Node node) {
        /* 큐를 사용한다는 아이디어...!
        * */
        Queue<Node> queue = new LinkedList();
        queue.add(node);

        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.print(node.data + " -> ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

}

public class LinkedTree {
    public static void main(String[] args) {
        char[] tree = new char[10];
        IntStream.range(0, 10).forEach(i -> tree[i] = (char) ('A' + i));

        LinkedBinaryTree lbt = new LinkedBinaryTree(tree);

        System.out.println("전위 순회");
        lbt.preOrder(lbt.root);
        System.out.println("\n\n중위 순회");
        lbt.inOrder(lbt.root);
        System.out.println("\n\n후위 순회");
        lbt.postOrder(lbt.root);
        System.out.println("\n\n레벨 순회");
        lbt.leverOrder(lbt.root);
    }
}
