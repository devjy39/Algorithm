package dataStructure.nonLinear.tree;

import java.util.LinkedList;
import java.util.Queue;

class BsNode {
    int key;
    BsNode left;
    BsNode right;

    public BsNode(int key, BsNode left, BsNode right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }
}

class BinarySearchTree {
    BsNode root;

    public BinarySearchTree() {
    }

    public BinarySearchTree(int key) {
        this.root = new BsNode(key, null, null);
    }

    public void recursiveAddNode(int key) {
        if (this.root == null) {
            this.root = new BsNode(key, null, null);
            return;
        }
        recurAdd(this.root, key);
    }

    public void recurAdd(BsNode node, int key) {
        if (key < node.key) {
            if(node.left==null)
                node.left = new BsNode(key, null, null);
            else
                recurAdd(node.left, key);
        } else if (key > node.key) {
            if(node.right==null)
                node.right = new BsNode(key, null, null);
            else
                recurAdd(node.right, key);
        }
    }

    public void addNode(int key) {
        if (this.root == null) {
            this.root = new BsNode(key, null, null);
            return;
        }
        BsNode newNode = new BsNode(key, null, null);
        BsNode node = this.root;

        while (node != null) {
            if (key < node.key) {
                if (node.left == null) {
                    node.left = newNode;
                    break;
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = newNode;
                    break;
                }
                node = node.right;
            }
        }
    }

    public void recursiveRemoveNode(int key) {
        this.root = recurRemove(this.root, key);
    }

    public BsNode recurRemove(BsNode node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.key) {
            node.left = recurRemove(node.left, key);
        } else if (key > node.key) {
            node.right = recurRemove(node.right, key);
        } else {
            System.out.println("key = "+node.key);
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                BsNode parentTemp = node;
                BsNode temp = node.left; // target의 left 자식

                while (temp.right != null) {
                    parentTemp = temp;
                    temp = temp.right;
                }

                if (parentTemp == node) { // 강의 코드에서 없는부분
                    parentTemp.left = temp.left;
                } else
                    parentTemp.right = temp.left;

                node.key = temp.key;
                //키 값만 바꾸는 방식으로 해결 가능
            }
        }

        return node;
    }

    public void removeNode(int key) {
        BsNode target = this.root;
        BsNode parent = null;
        BsNode replace = null;
        while (target != null) {
            if (key < target.key) {
                parent = target;
                target = target.left;
            } else if (key > target.key) {
                parent = target;
                target = target.right;
            } else {
                break;
            }
        }
        if (target == null) {
            System.out.println("not found key ");
            return;
        }

        if (target.left == null && target.right == null) { //leaf
            replace = null;
        } else if (target.left == null) {
            replace = target.right;
        } else if (target.right == null) {
            replace = target.left;
        } else { // 자식이 둘다 존재 -> left에서 max노드가 위로
            BsNode temp = target.left;
            BsNode parentTemp = null;
            while (temp.right != null) {
                parentTemp = temp;
                temp = temp.right;
            }

            if (parentTemp != null) {
                parentTemp.right = temp.left;
                temp.left = target.left;
            }
            temp.right = target.right;

            replace = temp;
        }

        if (parent == null) {
            this.root = replace;
        } else if (key < parent.key) {
            parent.left = replace;
        } else {
            parent.right = replace;
        }
    }

    public BsNode binarySearch(int key) {
        BsNode node = this.root;
        while (node != null) {
            if (key < node.key) {
                node = node.left;
            } else if (key > node.key) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }

    public void leverOrder(BsNode node) {
        /* 큐를 사용한다는 아이디어...!
         * */
        Queue<BsNode> queue = new LinkedList();
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
}

public class BinarySearchTreePractice {
    public static void main(String[] args) {
        int[] arr = {10,30,1,15,25,13,35,27,40,12,16};
        BinarySearchTree bst = new BinarySearchTree(20);
        for (int i : arr) {
            bst.recursiveAddNode(i);
        }
        bst.leverOrder(bst.root);

        bst.recursiveRemoveNode(40);
        bst.leverOrder(bst.root);
        bst.recursiveRemoveNode(25);
        bst.leverOrder(bst.root);
        bst.recursiveRemoveNode(15);
        bst.leverOrder(bst.root);

    }
}