package dataStructure.nonLinear.heap;
// Practice 3
// 정수들을 힙 자료구조에 추가하고 n번 삭제 후 절대값이 큰 값부터 출력하세요.

// 입력: 3 0 -2 -5 9 6 -11, 20, -30
// 삭제 횟수: 1
// 출력: 20, -11 9 6 -5 3 -2 0

import java.util.ArrayList;
import java.util.Arrays;

class MaxHeap2{
    ArrayList<Integer> heap;

    public MaxHeap2() {
        this.heap = new ArrayList<>();
        this.heap.add(0);
    }

    public void insert(int data) {
        heap.add(data);

        int cur = heap.size() - 1;
        while (cur > 1 && Math.abs(heap.get(cur / 2)) < Math.abs(heap.get(cur))) {
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
                targetIdx =  Math.abs(heap.get(leftIdx)) >  Math.abs(heap.get(rightIdx)) ? leftIdx : rightIdx;
            } else if (leftIdx < heap.size()) {
                targetIdx = cur * 2;
            } else {
                break;
            }

            if ( Math.abs(heap.get(cur)) >  Math.abs(heap.get(targetIdx))) {
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

public class Practice3 {
    public static void solution(int[] nums, int deleteCnt) {
        MaxHeap2 maxHeap = new MaxHeap2();
        Arrays.stream(nums).forEach(x -> maxHeap.insert(x));
        maxHeap.printTree();

        while (maxHeap.heap.size() != 1) {
            int num = maxHeap.delete();
            if (deleteCnt-- < 1) {
                System.out.print(num+" ");
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        int nums[] = {3, 0, -2, -5, 9, 6, -11, 20, -30};
        int deleteCnt = 1;
        solution(nums, deleteCnt);
    }
}
