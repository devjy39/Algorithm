package dataStructure.nonLinear.graph.practices;
// Practice2
// 주어진 그래프에서 시작 노드에서 끝 노드로 가는 길이 있는지 확인하는 프로그램을 작성하세요.
// path 가 존재하면 true 없으면 false 출력

// 입력 예시)
// 노드 개수 = 3
// 간선 정보  = {{0, 1}, {1, 2}, {2, 0}}
// 출발 노드 = 0
// 종착 노드 = 2
// 출력 : true

import java.util.Stack;

class Node {
    int id;
    Node next;

    public Node(int id, Node next) {
        this.id = id;
        this.next = next;
    }
}

class MyGraphList {
    int vertices[];
    Node[] adjList;
    int elemCnt;

    public MyGraphList() {}
    public MyGraphList(int size) {
        this.vertices = new int[size];
        this.adjList = new Node[size];
        this.elemCnt = 0;
    }

    public boolean isFull() {
        return this.elemCnt == this.vertices.length;
    }

    public void addVertex(int data) {
        if (isFull()) {
            System.out.println("Graph is full!");
            return;
        }

        this.vertices[elemCnt++] = data;
    }

    public void addEdge(int x, int y) {
        this.adjList[x] = new Node(y, this.adjList[x]);
        this.adjList[y] = new Node(x, this.adjList[y]);
    }
}

public class Practice2 {
    public static void solution(int n, int[][] edges, int source, int dest) {
        MyGraphList graph = new MyGraphList(n);
        for (int i = 0; i < n; i++) {
            graph.addVertex(i);
        }
        for (int[] edge : edges) {
            graph.addEdge(edge[0], edge[1]);
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];
        stack.push(source);
        visited[source] = true;

        while (!stack.isEmpty()) {
            int id = stack.pop();

            Node node = graph.adjList[id];
            while (node != null) {
                if (!visited[node.id]) {
                    visited[node.id] = true;
                    stack.push(node.id);
                }
                node = node.next;
            }
        }

        System.out.println(visited[dest]);
    }

    public static void main(String[] args) {
        // Test code
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        int source = 0;
        int dest = 2;
        solution(n, edges, source, dest);

        n = 6;
        edges = new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        source = 0;
        dest = 5;
        solution(n, edges, source, dest);
    }
}
