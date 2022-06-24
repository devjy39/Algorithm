package dataStructure.nonLinear.tree;

import java.util.stream.IntStream;

class BinaryTree {
    char[] tree;

    public BinaryTree(char[] tree) {
        this.tree = tree;
    }

    public void preOrder(int idx) {
        int left = idx * 2 + 1;
        int right = idx * 2 + 2;

        System.out.print(tree[idx]);

        if (left < tree.length) {
            System.out.print(" -> ");
            preOrder(left);
        }

        if (right < tree.length) {
            System.out.print(" -> ");
            preOrder(right);
        }
    }

    public void inOrder(int idx) {
        int left = idx * 2 + 1;
        int right = idx * 2 + 2;

        if (left < tree.length) {
            inOrder(left);
            System.out.print(" -> ");
        }

        System.out.print(tree[idx]);

        if (right < tree.length) {
            System.out.print(" -> ");
            inOrder(right);
        }
    }

    public void postOrder(int idx) {
        int left = idx * 2 + 1;
        int right = idx * 2 + 2;

        if (left < tree.length) {
            postOrder(left);
            System.out.print(" -> ");
        }

        if (right < tree.length) {
            postOrder(right);
            System.out.print(" -> ");
        }

        System.out.print(tree[idx]);
    }

    public void leverOrder() {
        for (char c : tree) {
            System.out.print(c + " -> ");
        }
    }
}

public class TreePractice {
    public static void main(String[] args) {
        char[] tree = new char[10];
        IntStream.range(0, 10).forEach(i -> tree[i] = (char) ('A' + i));

        BinaryTree bt = new BinaryTree(tree);

        System.out.println("전위 순회");
        bt.preOrder(0);

        System.out.println("\n\n중위 순회");
        bt.inOrder(0);

        System.out.println("\n\n후위 순회");
        bt.postOrder(0);

        System.out.println("\n\n레벨 순회");
        bt.leverOrder();
    }
}
