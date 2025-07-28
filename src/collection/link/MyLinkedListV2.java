package collection.link;

public class MyLinkedListV2 {

  private Node first;
  private int size = 0;

  public void add(Object e) {
    Node newNode = new Node(e); // item에 참조값을 넣은거임.
    if (first == null) {
      first = newNode;
    } else {
      Node lastNode = getLastNode();
      lastNode.next = newNode;
    }
    size++;
  }

  private Node getLastNode() {
    Node x = first;
    while(x.next != null) {
      x = x.next;
    }
    return x;
  }

  //추가 코드
  public void add(int index, Object e) {
    Node newNode = new Node(e);

    if (index == 0) {
      newNode.next = first;
      first = newNode;
    } else {
      Node prev = getNode(index - 1);
      newNode.next = prev.next;
      prev.next = newNode;
      /*
      Node prev = getNode(index - 1);
      prev.next = newNode;
      newNode.next = getNode(index + 1);

      Node prev = getNode(index - 1);
      newNode.next = prev.next;
      prev.nex = newNode;

      그니까 이 두 코드를 다시 보면 첫번째는 prev.next에 원래 기존에 있던 노드에 접근 할 수 있는 참조값이 있는데 그 참조값을 없애버리고
      newNode로 접근 가능한 참조값을 next에 초기화 하는거고
      newNode.next에 기존에 접근 할 수 있던 참조값을 getNode라는 메서드를 통해서 다시 갖고 오는건데
      이미 있었던걸 굳이 없애서 다시 getNode라는 메서드를 통해서 갖고 오는거니 런타임을 더 오래 갖는거라 비효율적인데..

      두번째 같은경우에는 기존에 접근 할 수 있던 참조값을 newNode.next에 초기화를 하는거고
      prev.next에 newNode에 접근 할 수 있는 참조값을 초기화 하는거니 일을 여러번 하지 않네

       */

    }
    size++;
  }

  //추가 코드
  public Object remove(int index) {
    Node removeNode = getNode(index);
    Object removedItem = removeNode.item;
    if(index == 0) {
      first = removeNode.next;
    } else {
      Node prev = getNode(index - 1);
      prev.next = removeNode.next;
    }
    removeNode.item = null;
    removeNode.next = null;
    size--;
    return removedItem;
  }

  public Object set(int index, Object element) {
    Node x = getNode(index);
    Object oldValue = x.item;
    x.item = element;
    return oldValue;
  }

  public Object get(int index) {
    Node x = getNode(index);
    return x.item;
  }

  private Node getNode(int index) {
    Node x = first;
    for(int i = 0; i < index; i++) {
      x = x.next;
    }
    return x;
  }

  public int indexOf(Object o) {
    int index = 0;
    for (Node x = first; x != null; x = x.next) {
      if(o.equals(x.item)) {
        return index;
      }
      index++;
    }
    return -1;
  }

  public int size() {
    return size;
  }

  @Override
  public String toString() {
    return "MyLinkedListV1{" +
        "first=" + first +
        ", size=" + size +
        '}';
  }
}

/*
package collection.link;

public class MyLinkedListV1 {

  private Node first;
  private int size = 0;

  public void add(Object e) {
    Node newNode = new Node(e);
    if(first == null) {
      first = newNode;
    } else {
      Node lastNode = getLastNode();
      lastNode.next = newNode;
    }

    size++;
  }

  private Node getLastNode() {
    Node x = first;
    while(x.next != null) {
      x = x.next;
    }
    return x;
  }

  //추가 코드
  public void add(int index, Object e) {
    Node newNode = new Node(e);
    if(index == 0) {
      newNode.next = first;
      first = newNode;

    } else {
      Node prev = getNode(index - 1);
      newNode.next = prev.next;
      prev.next = newNode;
    }
    size++;


  }

  public Object set(int index, Object element) {
    Node x = getNode(index);
    Object oldValue = x.item;
    x.item = element;
    return oldValue;
  }

  //추가 코드
  public Object remove(int index) {
    Node removeNode = getNode(index);
    Object removedItem = removeNode.item;
    if(index == 0) {
      first = removeNode.next;
    } else {
      getNode(index - 1).next = removeNode.next;
    }
    removeNode.item = null;
    removeNode.next = null;
    size--;
    return removedItem;
 }



  public Object get(int index) {
    Node node = getNode(index);
    return node.item;
  }

  private Node getNode(int index) {
    Node x = first;
    for (int i = 0; i < index; i++) {
      x = x.next;
    }
    return x;
  }

  public int indexOf(Object o) {
    int index = 0;
    for (Node x = first; x != null; x = x.next) {
      if(o.equals(x.item)) {
        return index;
      }
      index++;
    }

    return -1;
  }

  public int size() {
    return size;
  }

  @Override
  public String toString() {
    return "MyLinkedListV1{" +
      "first=" + first +
       ", size=" + size +
       '}';
  }

}


 */
