package collection.link;

public class NodeMain2 {

  public static void main(String[] args) {
    // 노드 생성하고 연결하기: A -> B -> C
    Node first = new Node("A");
    first.next = new Node("B");
    first.next.next = new Node("C");

    System.out.println("연결된 노드 출력하기");
    System.out.println(first);

    /*
    first.toString()이 실행 될 것임.
    이때 first가 가리키는 인스턴스 클래스의 참조값이 this가 되는 것.
     */

  }

}

/*
package collection.link;

public class NodeMain2 {

  public static void main(String[] args) {
    // 노드 생성하고 연결하기 : A -> B -> C
    Node first = new Node("A");
    first.next = new Node("B");
    first.next.next = new Node("C");

    System.out.println("연결된 노드 출력하기");
    System.out.println(first);
  }

  Node{item=A, next=Node{item=B, next=Node{item=C, next=null}}}

}

  return "Node{" +
           "item=" + item +
           ", next=" + next +
           '}';

출력물을 살펴보자. 먼저 first를 println()에 넣었으면 first는 참조변수이므로 first.toString()이 실행됨.

Node{item=A, next=Node{item=B, next={Node{item=C, next=null}}}









//IDE 생성 toString()
  @Override
  public String toString() {
    return "Node{" +
            "item=" + item +
            ", next=" + next +
            '}';
  }

일단 println()에 있으면 toString 메서드를 호출

근데 Object가 최상위 클래스이므로 Object 클래스에 있는 toString()을 호출 해야함.

메서드 오버라이딩에 의해서 Object 클래스가 아닌 Node 클래스에 있는 toString() 호출

Npde{item=A, next=Node{item=B,next=Node{item=C,next=null}
 */
