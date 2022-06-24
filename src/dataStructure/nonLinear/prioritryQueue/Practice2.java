package dataStructure.nonLinear.prioritryQueue;// Practice 2
// 문자열 사전식 오름차순

import java.util.PriorityQueue;
import java.util.stream.IntStream;

class Person2 implements Comparable<Person2>{
    String name;
    int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person2 o) {
        return this.name.compareToIgnoreCase(o.name);
    }

    @Override
    public String toString() {
        return String.format("(%s,%d)", name, age);
    }
}

public class Practice2 {
    public static void solution(String[] name, int[] age) {
        PriorityQueue<Person2> priorityQueue = new PriorityQueue<>();
        PriorityQueue<Person2> prLambda = new PriorityQueue<>
                ((Person2 p1, Person2 p2) -> p1.name.compareTo(p2.name));
        // 람다식으로 Comparable 인자 삽입 방법

        IntStream.range(0, age.length).forEach(i -> priorityQueue.add(new Person2(name[i], age[i])));


        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.poll().toString()+" ");
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Person2> pq = new PriorityQueue<>((Person2 p1, Person2 p2) -> p1.name.compareTo(p2.name));

        String[] name = {"A", "B", "C", "D", "E"};
        int[] age = {30, 20, 45, 62, 35};

        solution(name, age);
    }
}
