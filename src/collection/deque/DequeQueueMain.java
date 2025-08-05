package collection.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeQueueMain {

  public static void main(String[] args) {
    Deque<Integer> deque = new ArrayDeque<>();

    //데이터 추가
    deque.offer(1);
    deque.offer(2);
    deque.offer(3);

    System.out.println(deque);

    //다음 꺼낼 데이터 확인(꺼내지 않고 단순 조회만)
    System.out.println("deque.peek() = " + deque.peek());

    //데이터 꺼내기
    System.out.println("deque.poll() = " + deque.poll());
    System.out.println("deque.poll() = " + deque.poll());
    System.out.println("deque.poll() = " + deque.poll());
    System.out.println(deque);

  }
}

/*
"Deque"는 "Double Ended Queue"의 약자로 이 이름에서 알 수 있듯이, Deque는 양쪽 끝에서
요소를 추가하거나 제거할 수 있다. Deque는 일반적인 큐(Queue)와 스택(Stack)의 기능을 모두 포함.
매우 유연한 자료 구조임

package collection.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeMain {

  public static void main(String[] args) {
    Deque<Integer> deque = new ArrayDeque<>();
    //Deque<Integer> deque = new LinkedList<>();

    // 데이터 추가
    deque.offerFirst(1);
    System.out.println(deque);

    deque.offerFirst(2);
    System.out.println(deque);

    deque.offerLast(3);
    System.out.println(deque);

    deque.offerLast(4);
    System.out.println(deque);

    // 다음 꺼낼 데이터 확인(꺼내지 않고 단순 조회만)
    System.out.println("deque.peekFirst() = " + deque.peekFirst()); // 2
    System.out.println("deque.peekLast() = " + deque.peekLast()); // 4

    // 데이터 꺼내기
    System.out.println("pollFirst = " + deque.pollFirst()); // 2
    System.out.println("pollFirst = " + deque.pollFirst()); // 1
    System.out.println("pollLast = " + deque.pollLast()); // 4
    System.out.println("pollLast = " + deque.pollLast()); // 3
    System.out.println(deque);
  }

}

Deque 구현체와 성능 테스트

Deque의 대표적인 구현체는 ArrayDeque, LinkedList가 있다.
이 둘 중에서 ArrayDeque가 모든 면에서 더 빠르다.

왜??

현대 컴퓨터 시스템의 메모리 접근 패턴, CPU 캐시 최적화 등을 고려할 때 배열을 사용하는
ArrayDeque가 실제 사용 환경에서 더 나은 성능을 보여주는 경우가 많다.
 */


