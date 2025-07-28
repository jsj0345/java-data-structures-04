package collection.set;

import java.util.Arrays;

public class MyHashSetV0Main {

  public static void main(String[] args) {
    MyHashSetV0 set = new MyHashSetV0();
    set.add(1); // O(1)
    set.add(2); // O(n)
    set.add(3); // O(n)
    set.add(4); // O(n)
    set.add(5); // O(n)
    System.out.println("set = " + set);

    boolean result = set.add(4); // 중복 데이터 저장
    System.out.println("중복 데이터 저장 결과 = " + result);
    System.out.println(set);

    System.out.println("set.contains(3) = " + set.contains(3)); // O(n)
    System.out.println("set.contains(99) = " + set.contains(99)); // O(n)


  }
}

/*
package collection.set;

public class MyHashSetV0Main {

  public static void main(String[] args) {
    MyHashSetV0 set = new MyHashSetV0();
    set.add(1); // O(1)
    set.add(2); // O(n)
    set.add(3); // O(n)
    set.add(4); // O(n)
    System.out.println(set);

    boolean result = set.add(4); // 중복 데이터 저장
    System.out.println("중복 데이터 저장 결과 = " + result);
    System.out.println(set);

    System.out.println("set.contains(3): " + set.contains(3));
    System.out.println("set.contains(99): " + set.contains(99));
  }

}



set을 간단하게 구현했지만 문제점이 있다.
ArrayList나 LinkedList를 보면 ArrayList는 인덱스를 통한 데이터 찾기, 마지막 위치에 데이터 추가에
연산이 용이함.
LinkedList는 맨 처음에 데이터를 추가할때 용이.

그런데 Set은 데이터 중복을 체크해야해서 데이터를 일릴히 검색 해야함. 이러면 성능이 떨어진다.

어떻게 해야할까?
 */