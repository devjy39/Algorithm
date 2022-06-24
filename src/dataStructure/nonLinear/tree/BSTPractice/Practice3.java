package dataStructure.nonLinear.tree.BSTPractice;// Practice3
// 주어진 BST 에서 두 노드의 합이 target 값이 되는 경우가 있는지 확인하세요.
// 있으면 true, 없으면 false 반환

// 입력 트리: 5, 3, 6, 2, 4, null, 7
// 결과: true

// 입력 트리: 5,3,6,2,4,null,7
// 결과: false

public class Practice3 {
    public static void solution(Integer[] data, int target) {
        BinarySearchTree bst = new BinarySearchTree();
        for (Integer d : data) {
            if(d!=null)
                bst.addNode(d);
        }

        for (Integer d : data) {
            if (d!=null && d < target && binSearch(bst.head, target - d)) {
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
    }

    public static boolean binSearch(Node node,int key) {
        if (node == null) {
            return false;
        }
        if (key < node.key) {
            return binSearch(node.left, key);
        } else if (key > node.key) {
            return binSearch(node.right, key);
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Integer[] data = {5, 3, 6, 2, 4, null, 7};
        int target = 9;
        solution(data, target);

        data = new Integer[]{5,3,6,2,4,null,7};
        target = 28;
        solution(data, target);

        data = new Integer[]{5,3,6,2,4,null,7,10,14,15,16,154,46};
        target = 200;
        solution(data, target);
    }
}
