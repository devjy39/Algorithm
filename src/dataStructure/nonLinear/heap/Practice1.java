package dataStructure.nonLinear.heap;
// Practice 1
// 최소 힙에서 특정 값을 변경하는 코드를 작성하세요.
// 특정 값이 여러개라면 모두 바꿔주세요.

class MinHeap2 extends MinHeap {
    public void checkChild(int cur) {
        int left = cur << 1;
        int right = (cur << 1) + 1;
        int target = 0;

        if (right < heap.size()) {
            target = heap.get(left) < heap.get(right) ? left : right;
        } else if (left < heap.size()){
            target = left;
        } else
            return;

        if (heap.get(target) < heap.get(cur)) {
            int curValue = heap.get(cur);
            heap.set(cur, heap.get(target));
            heap.set(target, curValue);
            checkChild(target);
        }
    }

    public void checkParent(int cur) {
        int parent = cur >> 1;

        if (parent > 0 && heap.get(cur) < heap.get(parent)) {
            int curValue = heap.get(cur);
            heap.set(cur, heap.get(parent));
            heap.set(parent, curValue);
            checkParent(parent);
        }
    }
}

public class Practice1 {
    public static void solution(MinHeap2 minHeap, int from, int to) {
        for (int i = 1; i < minHeap.heap.size(); i++) {
            if (minHeap.heap.get(i) == from) {
                minHeap.heap.set(i, to);
                minHeap.checkParent(i);
                minHeap.checkChild(i);
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        MinHeap2 minHeap = new MinHeap2();
        minHeap.insert(30);
        minHeap.insert(40);
        minHeap.insert(10);
        minHeap.insert(50);
        minHeap.insert(60);
        minHeap.insert(70);
        minHeap.insert(20);
        minHeap.insert(30);
        System.out.println("== 데이터 변경 전 ==");
        minHeap.printTree();

        System.out.println("== 데이터 변경 후 ==");
        solution(minHeap, 30, 100);
        minHeap.printTree();

        solution(minHeap, 60, 1);
        minHeap.printTree();
    }
}
