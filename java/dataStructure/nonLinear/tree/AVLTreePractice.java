package dataStructure.nonLinear.tree;

import java.util.LinkedList;
import java.util.Queue;

class AVLNode {
    int key;
    int height; // 노드의 자식 차수
    AVLNode left;
    AVLNode right;

    public AVLNode(int key, AVLNode left, AVLNode right) {
        this.key = key;
        this.height = 0;
        this.left = left;
        this.right = right;
    }
}

class AVLTree {
    AVLNode root;

    public int height(AVLNode node) {
        // 부모 노드의 h는 자식 노드의 max +1 이기
        // 때문에 null이면 -1이여야 부모노드 h는 0이 된다
        return node == null ? -1 : node.height;
    }

    public AVLNode ll(AVLNode node) {
        AVLNode lNode = node.left;
        node.left = lNode.right;
        lNode.right = node;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        lNode.height = Math.max(height(lNode.left), height(lNode.right)) + 1;

        return lNode;
    }
    public AVLNode rr(AVLNode node) {
        AVLNode rNode = node.right;
        node.right = rNode.left;
        rNode.left = node;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        rNode.height = Math.max(height(rNode.left), height(rNode.right)) + 1;

        return rNode;
    }

    public AVLNode lr(AVLNode node) {
        node.left = rr(node.left);
        return ll(node);
    }
    public AVLNode rl(AVLNode node) {
        node.right = ll(node.right);
        return rr(node);
    }

    public int getBalance(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    public void insert(int key) {
        this.root = insert(this.root, key);
    }

    public AVLNode insert(AVLNode node, int key) {
        if (node == null) {
            return new AVLNode(key, null, null);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key){
            node.right = insert(node.right, key);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int balance = getBalance(node);
        if (balance > 1) { //일단 l
            if (key < node.left.key) {
                node = ll(node);
                System.out.println("LL ROTATE");
            }
            else {
                node = lr(node);
                System.out.println("LR ROTATE");
            }
        } else if (balance < -1) { // r
            if (key < node.right.key){
                node = rl(node);
                System.out.println("RL ROTATE");
            }
            else {
                node = rr(node);
                System.out.println("RR ROTATE");
            }
        }

        return node;
    }

    public void leverOrder() {
        AVLNode node = this.root;
        /* 큐를 사용한다는 아이디어...!
         * */
        Queue<AVLNode> queue = new LinkedList();
        queue.add(node);
        int cnt = 0;
        int i = 1;

        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.print(node.key + "\t");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

            cnt++;
            if (cnt == i) {
                System.out.println();
                i = (i+1)*2-1;
            }
        }
        System.out.println("\n");
    }

    public void delete(int key) {
        this.root = delete(this.root, key);
    }

    private AVLNode delete(AVLNode node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                AVLNode lNode = node.left;
                AVLNode parent = node;

                while (lNode.right != null) {
                    parent = lNode;
                    lNode = node.right;
                }

                if (parent == node) {
                    parent.left = lNode.left;
                } else {
                    parent.right = null;
                }
                node.key = lNode.key;
            }
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int balance = getBalance(node);
        if (balance > 1) { //일단 l
            if (getBalance(node.left) > 0) {
                node = ll(node);
                System.out.println("LL ROTATE");
            }
            else {
                node = lr(node);
                System.out.println("LR ROTATE");
            }
        } else if (balance < -1) { // r
            if (getBalance(node.right) > 0){
                node = rl(node);
                System.out.println("RL ROTATE");
            }
            else {
                node = rr(node);
                System.out.println("RR ROTATE");
            }
        }

        return node;
    }
}

public class AVLTreePractice {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(10);
        tree.leverOrder();
        tree.delete(40);
        tree.leverOrder();

        tree.insert(40);
        tree.delete(10);
        tree.leverOrder();

        tree.insert(25);
        tree.delete(40);
        tree.leverOrder();

        tree.insert(27);
        tree.delete(20);
        tree.leverOrder();
    }
}
