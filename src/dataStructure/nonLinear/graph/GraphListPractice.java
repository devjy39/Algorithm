package dataStructure.nonLinear.graph;

class Node {
    int id;
    Node next;

    public Node(int id, Node next) {
        this.id = id;
        this.next = next;
    }
}

class MyGraphList {
    char[] vertices;
    Node[] adjList;
    int eleCnt;

    public MyGraphList(int size) {
        this.vertices = new char[size];
        this.adjList = new Node[size];
        this.eleCnt = 0;
    }

    public boolean isFull() {
        return vertices.length == eleCnt;
    }


    public void addVertex(char a) {
        if (isFull()) {
            System.out.println("Full!");
            return;
        }
        vertices[eleCnt++] = a;
    }

    public void addEdge(int x, int y) { // add시 순회비용을 아끼기 위해 앞단에 삽입
        this.adjList[x] = new Node(y, this.adjList[x]);
        this.adjList[y] = new Node(x, this.adjList[y]);
    }

    public void printAdjacentList() {
        for (int i = 0; i < eleCnt; i++) {
            System.out.printf(vertices[i]+" -> ");
            Node node = this.adjList[i];
            while (node != null) {
                System.out.print(vertices[node.id]+" ");
                node = node.next;
            }
            System.out.println();
        }
    }
}

public class GraphListPractice {
    public static void main(String[] args) {
        // Test code
        MyGraphList graph = new MyGraphList(4);

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.printAdjacentList();
    }
}
