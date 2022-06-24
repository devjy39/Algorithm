package dataStructure.linear.arrayPractice;

class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T data) {
        this.data = data;
    }
}

class LinkedList<T> {
    Node<T> head;

    public boolean isEmpty() {
        return head == null ? true : false;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = newNode;
        }
    }

    public void add(int index, T data) {
        Node newNode = new Node(data);

        Node node = head;
        for (int i = 1; i < index; i++) {
            node = node.next;
            if (node == null) {
                System.out.println("OutOfIndexError");
                return;
            }
        }

        if (index == 0) { //first
            newNode.next = node;
            this.head = newNode;
        } else if (node.next == null) {  //last
            node.next = newNode;
        } else {
            newNode.next = node.next;
            node.next = newNode;
        }
    }

    public void deleteData(T data) {
        Node node = head;
        Node preNode = null;
        while (node != null) {
            if (node.data == data)
                break;
            preNode = node;
            node = node.next;
        }

        if (node == null) {
            System.out.println("data not found");
            return;
        }
        if (node == head) {
            this.head = head.next;
        } else if (node.next == null) {
            preNode.next = null;
        } else {
            preNode.next = node.next;
        }
    }

    public void printNodes() {
        Node node = this.head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public boolean findDate(T data) {
        Node node = this.head;
        while (node != null) {
            if(node.data.equals(data))
                return true;
            node = node.next;
        }
        return false;
    }
}

public class LinkedListPractice {
    static LinkedList removeDup(LinkedList linkedList) {
        LinkedList result = new LinkedList();

        Node node = linkedList.head;
        while (node != null) {
            if (!result.findDate(node.data))
                result.add(node.data);
            node = node.next;
        }

        return result;
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList1 = new LinkedList<>();

        linkedList1.add(1);
        linkedList1.add(1);
        linkedList1.add(1);
        linkedList1.add(3);
        linkedList1.add(4);
        linkedList1.add(5);
        linkedList1.add(6);
        linkedList1.add(7);
        linkedList1.add(8);
        linkedList1.add(9);
        linkedList1.add(100);
        linkedList1.add(33);
        linkedList1.add(13);
        linkedList1.add(12);

        removeDup(linkedList1);
        linkedList1.printNodes();

    }
}
