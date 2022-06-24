package dataStructure.nonLinear.tree.BSTPractice;// Practice2
// 주어진 BST 에서 노드 간의 차이값 중 최소 값을 구하세요.

// 입력 트리: 4, 2, 6, 1, 3
// 출력: 1

// 입력 트리: 5, 1, 48, null, null, 12, 51
// 출력: 3

import java.util.LinkedList;
import java.util.Queue;

public class Practice2 {

    public static void solution(Integer[] data) {
        BinarySearchTree bst = new BinarySearchTree();
        for (Integer d : data) {
            if (d != null) {
                bst.addNode(d);
            }
        }

        Queue<Node> q = new LinkedList();
        int min = Integer.MAX_VALUE;
        q.add(bst.head);

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.left != null) {
                min = Math.min(min, node.key - node.left.key);
                q.add(node.left);
            }
            if (node.right != null) {
                min = Math.min(min, node.right.key - node.key);
                q.add(node.right);
            }
        }
        System.out.println("min = "+min);
    }

    public static void main(String[] args) {
        // Test code
        Integer[] data = {3, 1, 4, null, 2};
        solution(data);

        data = new Integer[]{5, 1, 48, null, null, 12, 51};
        solution(data);
    }
}
