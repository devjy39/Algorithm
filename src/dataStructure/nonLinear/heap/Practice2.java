package dataStructure.nonLinear.heap;
// Practice 2
// 최소 힙, 최대 힙을 이용하여 데이터를 오름차순, 내림차순으로 출력해보세요.

import java.util.ArrayList;

class MaxHeap{
    ArrayList<Integer> heap;

    public MaxHeap() {
        this.heap = new ArrayList<>();
        this.heap.add(0);
    }

    public void insert(int data) {
        heap.add(data);

        int cur = heap.size() - 1;
        while (cur > 1 && heap.get(cur / 2) < heap.get(cur)) {
            int parentVal = heap.get(cur / 2);
            heap.set(cur / 2, data);
            heap.set(cur, parentVal);

            cur /= 2;
        }
    }

    public Integer delete() {
        if (heap.size() == 1) {
            System.out.println("Heap is empty!");
            return null;
        }

        int target = heap.get(1);

        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int cur = 1;
        while (true) {
            int leftIdx = cur * 2;
            int rightIdx = cur * 2 + 1;
            int targetIdx = -1;

            if (rightIdx < heap.size()) {
                targetIdx = heap.get(leftIdx) > heap.get(rightIdx) ? leftIdx : rightIdx;
            } else if (leftIdx < heap.size()) {
                targetIdx = cur * 2;
            } else {
                break;
            }

            if (heap.get(cur) > heap.get(targetIdx)) {
                break;
            } else {
                int parentVal = heap.get(cur);
                heap.set(cur, heap.get(targetIdx));
                heap.set(targetIdx, parentVal);
                cur = targetIdx;
            }
        }

        return target;
    }

    public void printTree() {
        for (int i = 1; i < this.heap.size(); i++) {
            System.out.print(this.heap.get(i) + " ");
        }
        System.out.println();
    }
}

public class Practice2 {
    public static void solution(MinHeap minHeap) {
        MaxHeap maxHeap = new MaxHeap();

        System.out.println("오름차순");
        while (minHeap.heap.size() != 1) {
            int num = minHeap.delete();
            maxHeap.insert(num);
            System.out.print(num + " ");
        }
        System.out.println("\n내림차순");
        while (maxHeap.heap.size() != 1) {
            System.out.print(maxHeap.delete()+" ");
        }
    }

    public static void main(String[] args) {
        // Test code
        MinHeap minHeap = new MinHeap();
        minHeap.insert(30);
        minHeap.insert(40);
        minHeap.insert(10);
        minHeap.insert(50);
        minHeap.insert(60);
        minHeap.insert(70);
        minHeap.insert(20);
        minHeap.insert(30);
        minHeap.printTree();

        solution(minHeap);
    }
}
