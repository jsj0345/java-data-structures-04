package collection.deque;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueMain {

  public static void main(String[] args) {
    Queue<Integer> queue = new ArrayDeque<>();

    //데이터 추가
    queue.offer(1);
    queue.offer(2);
    queue.offer(3);
    System.out.println(queue);

    //다음 꺼낼 데이터 확인(꺼내지 않고 단순히 조회)
    System.out.println("queue.peek() = " + queue.peek());

    //데이터 꺼내기
    System.out.println("queue.poll() = " + queue.poll());
    System.out.println("queue.poll() = " + queue.poll());
    System.out.println("queue.poll() = " + queue.poll());
    System.out.println(queue);


  }
}

/*
package collection.deque;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueMain {

  public static void main(String[] args) {
    Queue<Integer> queue = new ArrayDeque<>();

    // 데이터 추가
    queue.offer(1);
    queue.offer(2);
    queue.offer(3);
    System.out.println(queue);

    // 다음 꺼낼 데이터 확인(꺼내지 않고 단순 조회만)
    System.out.println("queue.peek() = " + queue.peek());

    // 데이터 꺼내기
    System.out.println("poll = " + queue.poll());
    System.out.println("poll = " + queue.poll());
    System.out.println("poll = " + queue.poll());
    System.out.println(queue);
  }

}


선입 선출(FIFO, First In First Out)

-후입 선출과 반대로 가장 먼저 넣은 것이 가장 먼저 나오는 것을 선입 선출이라 한다.
이런 자료 구조를 Queue라 한다.

전통적으로 큐에 값을 넣는 것을 offer라 하고, 큐에서 값을 꺼내는 것을 poll이라 한다.

Queue 인터페이스는 List, Set과 같이 Collection의 자식이다.

Queue 대표적인 구현체는 ArrayDeque, LinkedList가 있다.

 */
