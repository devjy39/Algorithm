package dataStructure.nonLinear.prioritryQueue;
// 비선형 자료구조 - 우선순위 큐
// 연결 리스트를 이용한 우선순위 큐
// 자바 기본 PriorityQueue

import java.util.*;

public class Main {
    public static void enqueue(LinkedList<Integer> list, int data) {
        int idx = 0;
        for (; idx < list.size(); idx++) {
            if (data < list.get(idx)) {
                break;
            }
        }
        list.add(idx, data);
    }

    public static Integer dequeue(LinkedList<Integer> list) {
        if (list.size() == 0) {
            return null;
        }
        return list.removeFirst();
    }

    public static void main(String[] args) {
        // 연결리스트를 이용한 우선순위 큐
        System.out.println("== 연결리스트 방식의 우선순위 큐 ==");
        LinkedList<Integer> pqList = new LinkedList();
        enqueue(pqList, 5);
        enqueue(pqList, 7);
        enqueue(pqList, 3);
        enqueue(pqList, 1);
        enqueue(pqList, 9);
        System.out.println(pqList);

        System.out.println(dequeue(pqList));
        System.out.println(dequeue(pqList));
        System.out.println(pqList);
        System.out.println();

        // 자바 기본 PriorityQueue 사용
        // 기본적으로 heap이기 때문에 순서자체는 반정렬상태이고 삭제를 할때만 정렬 순이다
        System.out.println("== 자바 기본 우선순위 큐 ==");
        // 객체의 경우 Comparable 구현 필수
        // 우선순위: 오름차 순
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(5);
        priorityQueue.add(3);
        priorityQueue.add(2);
        priorityQueue.add(7);
        priorityQueue.add(10);
        System.out.println(priorityQueue);

        // 우선순위: 내림차 순
        // reverseOrder를 넣어주거나 람다식으로 널어줘야 함
        System.out.println("== 내림차 순 우선순위 큐");
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(Collections.reverseOrder());
        priorityQueue2.add(5);
        priorityQueue2.add(3);
        priorityQueue2.add(2);
        priorityQueue2.add(7);
        priorityQueue2.add(10);
        System.out.println(priorityQueue2);
    }
}
