package dataStructure.nonLinear.graph;

class MyGraphMatrix {
    char[] vertices;
    int[][] map;
    int eleCnt;

    public MyGraphMatrix(int size) {
        this.vertices = new char[size];
        this.map = new int[size][size];
        this.eleCnt = 0;
    }

    public boolean isFull() {
        return this.eleCnt == this.vertices.length;
    }


    public void addVertex(char data) {
        if(isFull()) {
            System.out.println("graph is full");
            return;
        }
        vertices[eleCnt++] = data;
    }

    public void addEdge(int x, int y) {
        map[x][y] = 1;
        map[y][x] = 1;
    }

    public void printAdjacentMatrix() {
        System.out.printf("  ");
        for (int i = 0; i < eleCnt; i++) {
            System.out.print(vertices[i]+" ");
        }
        System.out.println();

        for (int i = 0; i < eleCnt; i++) {
            System.out.printf(vertices[i]+" ");
            for (int e : map[i]) {
                System.out.print(e+" ");
            }
            System.out.println();
        }
    }

}

public class Main {
    public static void main(String[] args) {
        // Test code
        MyGraphMatrix graph = new MyGraphMatrix(4);

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.printAdjacentMatrix();
    }
}