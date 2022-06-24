package dataStructure.nonLinear.tree;

import java.util.LinkedList;
import java.util.Queue;

class RBNode {
    int key;
    int color;
    RBNode left;
    RBNode right;
    RBNode parent;

    public RBNode(int key, int color, RBNode left, RBNode right, RBNode parent) {
        this.key = key;
        this.color = color;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}

class RedBlackTree {
    static final int BLACK = 0;
    static final int RED = 1;

    RBNode head;

    public void insert(int key) {
        RBNode checkRBNode = null;
        if (this.head == null) {
            // 처음 헤드는 Black
            this.head = new RBNode(key, BLACK, null, null, null);
        } else {
            RBNode cur = this.head;

            // 추가할 위치 찾아 추가하는 부분
            while (true) {
                RBNode pre = cur;

                if (key < cur.key) {
                    // 왼쪽 자식 노드 쪽으로 추가
                    cur = cur.left;
                    if (cur == null) {
                        // 추가할 때는 우선 Red
                        pre.left = new RBNode(key, RED, null, null, pre);
                        // 추가한 노드를 re-balancing 대상의 노드로 짚어줌
                        checkRBNode = pre.left;
                        break;
                    }
                } else {
                    cur = cur.right;

                    if (cur == null) {
                        pre.right = new RBNode(key, RED, null, null, pre);
                        checkRBNode = pre.right;
                        break;
                    }
                }
            }
            // 추가 후 re-balancing
            reBalance(checkRBNode);
        }
    }

    public void reBalance(RBNode RBNode) {
        // 추가한 노드의 부모가 있고 그 부모가 red 일 때 조정 필요
        while (RBNode.parent != null && RBNode.parent.color == RED) {
            RBNode sibling = null;

            // 부모 노드의 형제 노드 찾기
            if (RBNode.parent == RBNode.parent.parent.left) {
                sibling = RBNode.parent.parent.right;
            } else {
                sibling = RBNode.parent.parent.left;
            }

            // 부모 노드의 형제 노드가 Red 일 때 re-coloring
            if (sibling != null && sibling.color == RED) {
                // 부모 노드 black 으로 변경
                RBNode.parent.color = BLACK;
                // 부모 노드의 형제 노드 black 으로 변경
                sibling.color = BLACK;
                // 부모의 부모 노드는 red 로 변경
                RBNode.parent.parent.color = RED;

                // 부모 노드가 root 인 경우는 다시 black 으로 바꾸고 break
                if (RBNode.parent.parent == this.head) {
                    RBNode.parent.parent.color = BLACK;
                    break;
                } else { // 부모 노드가 root 가 아닌 경우는 double red 재발생 할 수 있으므로 반복 검사
                    RBNode = RBNode.parent.parent;
                    continue;
                }
            } else { // 부모 노드의 형제 없거나 black 일 때, re-structuring
                if (RBNode.parent == RBNode.parent.parent.left) {
                    // lr case 인 경우 우선 ll case 가 되도록 회전
                    if (RBNode == RBNode.parent.right) {
                        RBNode = RBNode.parent;
                        leftRotate(RBNode);
                    }
                    // 부모 노드는 black 으로 변경
                    RBNode.parent.color = BLACK;
                    // 부모의 부모 노드는 red 로 변경
                    RBNode.parent.parent.color = RED;
                    rightRotate(RBNode.parent.parent);
                } else if (RBNode.parent == RBNode.parent.parent.right) {
                    // rl case 인 경우 rr case 가 되도록 회전
                    if (RBNode == RBNode.parent.left) {
                        RBNode = RBNode.parent;
                        rightRotate(RBNode);
                    }
                    RBNode.parent.color = BLACK;
                    RBNode.parent.parent.color = RED;
                    leftRotate(RBNode.parent.parent);
                }
                break;
            }
        }
    }

    public void leftRotate(RBNode RBNode) {
        // node 가 head 인 경우 회전 후 head 교체
        if (RBNode.parent == null) {
            RBNode rRBNode = this.head.right;
            this.head.right = rRBNode.left;
            rRBNode.left.parent = this.head;
            this.head.parent = rRBNode;
            rRBNode.left = this.head;
            rRBNode.parent = null;
            this.head = rRBNode;
        } else {
            // 회전하기 전 자식 노드있는 경우 이동하는 작업
            if (RBNode == RBNode.parent.left) {
                RBNode.parent.left = RBNode.right;
            } else {
                RBNode.parent.right = RBNode.right;
            }
            RBNode.right.parent = RBNode.parent;
            RBNode.parent = RBNode.right;

            if (RBNode.right.left != null) {
                RBNode.right.left.parent = RBNode;
            }
            RBNode.right = RBNode.right.left;
            RBNode.parent.left = RBNode;
        }
    }

    public void rightRotate(RBNode RBNode) {
        // node 가 head 인 경우 회전 후 head 교체
        if (RBNode.parent == null) {
            RBNode lRBNode = this.head.left;
            this.head.left = lRBNode.right;
            lRBNode.right.parent = this.head;
            this.head.parent = lRBNode;
            lRBNode.right = this.head;
            lRBNode.parent = null;
            this.head = lRBNode;
        } else {
            if (RBNode == RBNode.parent.left)
                RBNode.parent.left = RBNode.left;
            else
                RBNode.parent.right = RBNode.left;

            RBNode.left.parent = RBNode.parent;
            RBNode.parent = RBNode.left;

            if (RBNode.left.right != null)
                RBNode.left.right.parent = RBNode;

            RBNode.left = RBNode.left.right;
            RBNode.parent.right = RBNode;
        }
    }

    public void levelOrder(RBNode RBNode) {
        char[] color = {'B', 'R'};

        Queue<RBNode> queue = new LinkedList();
        queue.add(RBNode);
        while (!queue.isEmpty()) {
            RBNode cur = queue.poll();

            System.out.print("[" + color[cur.color] + "]" + cur.key + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }

            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        System.out.println();
    }
}

public class RedBlackTreePractice {
    public static void main(String[] args) {
        // Test code
        RedBlackTree rbTree = new RedBlackTree();
        rbTree.insert(20);
        rbTree.insert(10);
        rbTree.insert(30);
        rbTree.levelOrder(rbTree.head);
        rbTree.insert(25);
        rbTree.levelOrder(rbTree.head);
        rbTree.insert(5);
        rbTree.insert(7);
        rbTree.levelOrder(rbTree.head);
        rbTree.insert(20);
        rbTree.levelOrder(rbTree.head);
    }
}