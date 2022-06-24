package dataStructure.nonLinear.prioritryQueue;
// Practice 1
// 자바 기본 PriorityQueue 응용
// 나이 순으로 오름차순 또는 내림차순 출력

import java.util.PriorityQueue;
import java.util.stream.IntStream;

class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        // this는 새로 삽입하는 객체이고
        // return 값이 음수면 (new 객체가 더 작으면) 부모와 변경, 즉 값을 트리 위로 올림.
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return String.format("(%s,%d)", name, age);
    }
}

public class Practice1 {
    public static void solution(String[] name, int[] age) {
        PriorityQueue<Person> priorityQueue = new PriorityQueue<>();
        PriorityQueue<Person> prLambda = new PriorityQueue<>
                ((Person p1, Person p2) -> p1.age - p2.age);
        // 람다식으로 Comparable 인자 삽입 방법

        IntStream.range(0, age.length).forEach(i -> priorityQueue.add(new Person(name[i], age[i])));


        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.poll().toString()+" ");
        }
    }

    public static void main(String[] args) {
        String[] name = {"A", "B", "C", "D", "E"};
        int[] age = {30, 20, 45, 62, 35};

        solution(name, age);

    }
}
