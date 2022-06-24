package dataStructure.nonLinear.heap;
// 비선형자료구조 - 힙
// ArrayList 로 최소 힙 구현
// 힙은 완전 이진트리 구조이기 때문에 배열로 구현해도 공간 효율성이 충분하다.

import java.util.ArrayList;

class MinHeap {
    ArrayList<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
        this.heap.add(0); // 인덱스를 1부터 쓸 예정
    }


    public void insert(int data) {
        this.heap.add(data);

        int cur = heap.size() - 1;

        while (cur > 1) {
            int par = cur >> 1;
            if (heap.get(cur) < heap.get(par)) {
                heap.set(cur, heap.get(par));
                heap.set(par, data);
                cur = par;
            } else {
                break;
            }
        }
    }

    public void printTree() {
        for (int i = 1; i < heap.size(); i++) {
            System.out.print(heap.get(i)+" ");
        }
        System.out.println();
    }

    public Integer delete() {
        if (heap.size() == 1) {
            System.out.println("Heap is empty!");
            return null;
        } else if (heap.size() == 2) {
            return heap.remove(1);
        }
        int cur = 1;
        int result = heap.get(cur);

        int data = heap.remove(heap.size() - 1);
        heap.set(cur, data);

        while ((cur << 1) < heap.size()) {
            int left = cur << 1;
            int right = (cur << 1) + 1; //연산자 우선순위 + , '<<'
            int child = 0;
            if (right < heap.size()) {
                child = heap.get(left) < heap.get(right) ? left : right;
            } else {
                child = left;
            }

            if (heap.get(child) < data) {
                heap.set(cur, heap.get(child));
                heap.set(child, data);
                cur = child;
            } else {
                break;
            }
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        // Test code
        MinHeap minHeap = new MinHeap();
        System.out.println("== 데이터 삽입 ==");
        minHeap.insert(30);
        minHeap.insert(40);
        minHeap.insert(10);
        minHeap.printTree();
        minHeap.insert(50);
        minHeap.insert(60);
        minHeap.insert(70);
        minHeap.printTree();
        minHeap.insert(20);
        minHeap.printTree();
        minHeap.insert(30);
        minHeap.printTree();

        System.out.println();
        System.out.println("== 데이터 삭제 ==");
        System.out.println("삭제: " + minHeap.delete());
        minHeap.printTree();
        System.out.println("삭제: " + minHeap.delete());
        minHeap.printTree();
        System.out.println("삭제: " + minHeap.delete());
        minHeap.printTree();
    }

}
