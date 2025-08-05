package collection.deque;

import java.util.Stack;

public class StackMain {

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();

    stack.push(1);
    stack.push(2);
    stack.push(3);

    System.out.println(stack);

    // 다음 꺼낼 요소 확인(꺼내지 않고 단순 조회만)
    System.out.println("stack.peek() = " + stack.peek());

    // 스택 요소 뽑기
    System.out.println("stack.pop() = " + stack.pop());
    System.out.println("stack.pop() = " + stack.pop());
    System.out.println("stack.pop() = " + stack.pop());

    System.out.println(stack);
  }
}

/*
package collection.deque;

import java.util.Stack;

//Stack은 사용하면 안됨 -> Deque를 대신 사용
public class StackMain {

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();

    stack.push(1);
    stack.push(2);
    stack.push(3);
    System.out.println(stack);

    // 다음 꺼낼 요소 확인(꺼내지 않고 단순 조회만)
    System.out.println("stack.peek() = " + stack.peek());

    // 스택 요소 뽑기
    System.out.println("stack.pop() = " + stack.pop());
    System.out.println("stack.pop() = " + stack.pop());
    System.out.println("stack.pop() = " + stack.pop());
    System.out.println(stack);
  }

}

코드를 돌려보면 가장 마지막에 넣은 3번이 가장 먼저 나온다.

이렇게 나중에 넣은 것이 가장 먼저 나오는 것을 후입 선출이라 하고,

이런 자료 구조를 스택이라 한다.

____________________________________________________________

주의! - Stack 클래스는 사용하지 말자

자바의 Stack 클래스는 내부에서 Vector라는 자료 구조를 사용한다.

이 자료 구조는 자바 1.0에 개발 되었는데, 지금은 사용되지 않고 하위 호환을 위해 존재한다.

지금은 더 빠른 좋은 자료 구조가 많다.

따라서 Vector를 사용하는 Stack도 사용하지 않는 것을 권장한다.

 */
