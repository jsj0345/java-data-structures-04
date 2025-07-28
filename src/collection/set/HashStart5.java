package collection.set;

import java.util.Arrays;
import java.util.LinkedList;

public class HashStart5 {

  static final int CAPACITY = 10;

  public static void main(String[] args) {
    //{1, 2, 5, 8, 14, 99}
    LinkedList<Integer>[] buckets = new LinkedList[CAPACITY]; // 이건 지금 LinkedList를 넣을 수 있는 배열을 생성한거임. LinkedList를 생성 한 것이 아님.
    System.out.println("buckets = " + Arrays.toString(buckets));
    for (int i = 0; i < CAPACITY; i++) {
      buckets[i] = new LinkedList<>();
    }

    System.out.println("buckets = " + Arrays.toString(buckets));
    add(buckets, 1);
    add(buckets, 2);
    add(buckets, 5);
    add(buckets, 8);
    add(buckets, 14);
    add(buckets, 99);
    add(buckets, 9);
    System.out.println("buckets = " + Arrays.toString(buckets)); // [null, [1], [2], null, null, [5], null, null, [8], [99, 9] ]

    //검색
    int searchValue = 9;
    boolean contains = contains(buckets, 9);
    System.out.println("buckets.contains(" + searchValue + ") = " + contains);


  }

  private static void add(LinkedList<Integer>[] buckets, int value) {
    int hashIndex = hashIndex(value);
    LinkedList<Integer> bucket = buckets[hashIndex]; // O(1) linkLast 메서드 호출
    if (!bucket.contains(value)) { // value가 중복되지 않을 때, 값을 넣야함.
      bucket.add(value); // 왜 중복되지 않을 때 넣어야 할까? Set 구현 때문임.
    }

    /*
    여기서 add 메서드는 LinkedList에 있는 메서드에 add를 의미.
    <Integer>는 이전 노드에 있는 item, 그 다음 노드에 있는 item에 Integer로 넣기 위함.
     */

  }

  static int hashIndex(int value) {
    return value % CAPACITY;
  }

  private static boolean contains(LinkedList<Integer>[] buckets, int searchValue) {
    int hashIndex = hashIndex(searchValue);
    LinkedList<Integer> bucket = buckets[hashIndex];
    return bucket.contains(searchValue);

    /*
    의문점이 하나 있음.

    LinkedList에 데이터를 추가 할 때, 원래 Node 클래스에 데이터를 추가해야함.

    이러면 Node 클래스의 참조값을 알아 낸 다음, 인스턴스 변수(item)에 값을 넣어야함.

    자바에서 구현한 LinkedList는 알아서 Node 객체를 만들고 item에 값을 넣는거임.

    정확하게 말하면 LinkedList에 first나 last에 new Node<>(세가지 요소); 이런식으로.
     */

    /*
    출력을 보면 9번째 인덱스에 [99, 9]로 나오는데 이러한 이유는 각 인덱스에 new LinkedList<>()를 넣었는데
    같은 참조값을 공유하고 있기에 사이드 이펙트가 생기는 느낌이라고 보면 돼 .
     */

  }
}

/*
package collection.set;

import java.util.Arrays;
import java.util.LinkedList;

public class HashStart5 {

  static final int CAPACITY = 10;

  public static void main(String[] args) {
    // {1, 2, 5, 8, 14, 99 ,9}
    LinkedList<Integer>[] buckets = new LinkedList[CAPACITY];
    for (int i = 0; i < CAPACITY; i++) {
      buckets[i] = new LinkedList<>(); // 제네릭 추론
    }

    add(buckets, 1);
    add(buckets, 2);
    add(buckets, 5);
    add(buckets, 8);
    add(buckets, 14);
    add(buckets, 99);
    add(buckets, 9);
    System.out.println("buckets = " + Arrays.toString(buckets));

    // 검색
    int searchValue = 9;
    boolean contains = contains(buckets, searchValue);
    System.out.println("buckets.contains(" + searchValue + ") = " + contains);
  }

  private static void add(LinkedList<Integer>[] buckets, int value) {
    int hashIndex = hashIndex(value);
    LinkedList<Integer> bucket = buckets[hashIndex];
    if (!bucket.contains(value)) { // O(n)
       bucket.add(value);
    }
  }

  private static boolean contains(LinkedList<Integer>[] buckets, int searchValue) {
    int hashIndex = hashIndex(searchValue);
    LinkedList<Integer> bucket = buckets[hashIndex];
    return bucket.contains(searchValue);
  }

  static int hashIndex(int value) {
    return value % CAPACITY;
  }

}





 */
