package problem.baekjoon.linear;

import java.io.*;

class ArrayQueue {
    private final int[] arr;
    private int rear;
    private int front;

    public ArrayQueue(int size) {
        this.arr = new int[size];
        this.front = -1;
        this.rear = -1;
    }

    public void push(int x) {
        arr[++rear] = x;
    }

    public int empty() {
        return rear == front ? 1 : 0;
    }

    public int size() {
        return rear - front;
    }

    public int front() {
        return empty() == 1 ? -1 : arr[front + 1];
    }

    public int back() {
        return empty() == 1 ? -1 : arr[rear];
    }

    public int pop() {
        return empty() == 1 ? -1 : arr[++front];
    }
}

public class 큐구현10845 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayQueue queue = new ArrayQueue(n);
        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();

            switch (cmd) {
                case "front":
                    bw.write(queue.front()+"\n");
                    break;
                case "back":
                    bw.write(queue.back()+"\n");
                    break;
                case "size":
                    bw.write(queue.size()+"\n");
                    break;
                case "empty":
                    bw.write(queue.empty()+"\n");
                    break;
                case "pop":
                    bw.write(queue.pop()+"\n");
                    break;
                default:
                    queue.push(Integer.parseInt(cmd.split(" ")[1]));
            }
        }
        br.close();
        bw.close();
    }

}