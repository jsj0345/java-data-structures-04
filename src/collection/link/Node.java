package collection.link;

public class Node {
  Object item;
  Node next;

  public Node(Object item) {
    this.item = item;
  }



  //IDE 생성 toString()

  /*
  @Override
  public String toString() {
    return "Node{" +
        "item=" + item +
        ", next=" + next +
        '}';
  }

   */


  //[A -> B -> C]
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    Node x = this;
    sb.append("[");
    while (x != null) {
      sb.append(x.item);
      if (x.next != null) {
        sb.append("->");
      }
      x = x.next;
    }
    sb.append("]");
    /*
    String string = sb.toString();
    return string; 여기에 변수에다가 커서를 올려두고 ctrl+Alt+N을 누르면
    return sb.toString();으로 바뀜.
     */

    return sb.toString();
  }


}


/*
package collection.link;

public class Node {
  Object item;
  Node next;

  public Node(Object item) {
    this.item = item;
  }

  //IDE 생성 toString()
  @Override
  public String toString() {
    return "Node{" +
            "item=" + item +
            ", next=" + next +
            '}';
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    Node x = this;
    sb.append("[");
    while (x != null) {
      sb.append(x.item);
      if (x.next != null) {
        sb.append("->");
      }

      x = x.next;
    }

    sb.append("]");
    return sb.toString();
  }


}

package collection.link;

public class Node {

  Object item;
  Node next;

  public Node(Object item) {
    this.item = item;
  }


  //IDE 생성 toString()
  @Override
  public String toString() {
    return "Node{" +
           "item=" + item +
           ", next=" + next +
           '}';
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    Node x = this;
    sb.append("[");
    while (x != null) {
      sb.append(x.item);
      if (x.next != null) {
        sb.append("->");
      }
      x = x.next;
    }

    sb.append("]");
    return sb.toString();
  }

}
 */