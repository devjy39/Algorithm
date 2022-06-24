package dataStructure.linear.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

class ArrayQueue {
    int[] arr;
    int front;
    int rear; // 첫 front를 비워둬야 함.

    public ArrayQueue(int length) {
        this.arr = new int[length+1];
    }

    private boolean isFull() {
        return front == (rear + 1) % arr.length;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void add(int num) {
        if (isFull()) {
            System.out.println("Full");
        } else {
            rear = (rear+1)%arr.length;
            arr[rear] = num;
        }
    }

    public void delete() {
        if(isEmpty())
            System.out.println("empty");
        else
            front = (front+1)%arr.length;
    }

    public void printQ() {
        System.out.print("q = ");
        for (int i = (front+1)%arr.length; i != (rear+1)%arr.length; i = (i+1)%arr.length) {
            System.out.print(this.arr[i]+" ");
        }
        System.out.println();
    }


}

public class QueuePractice {
    static int solution(int n) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        while (q.size() > 1) {
            q.remove();
            q.add(q.poll());
            System.out.println(q);
        }

        return q.peek();
    }

    static ArrayList solution2(int n,int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        IntStream.range(1, n + 1).forEach(i -> q.add(i));
        int count = 1;

        while (!q.isEmpty()) {
            if (count == k) {
                result.add(q.remove());
            } else {
                q.add(q.remove());
            }
            count = count % k + 1;
        }

        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        Queue queue = new LinkedList(); // queue는 인터페이스고 linkedlist에 구현돼있음

//        System.out.println(solution(4));
//        System.out.println(solution(7));
//        System.out.println(solution(9));
        solution2(5, 2);
        solution2(7, 3);

    }
}
