package collection.map;

import java.util.*;

public class MapMain1 {

  public static void main(String[] args) {
    Map<String, Integer> studentMap = new HashMap<>();

    // 학생 성적 데이터 추가
    studentMap.put("studentA", 90);
    studentMap.put("studentB", 80);
    studentMap.put("studentC", 80);
    studentMap.put("studentD", 100); //순서 보장x

    System.out.println(studentMap);

    // 특정 학생의 값 조회.
    Integer result = studentMap.get("studentD");
    System.out.println("result = " + result);

    System.out.println("keySet 활용");
    Set<String> keySet = studentMap.keySet(); // key는 중복 허용 X, 순서보장 X
    for (String key : keySet) {
      Integer value = studentMap.get(key);
      System.out.println("key = " + key + ", value = " + value);
      // 여기서 keySet의 값을 key에 자연스럽게 넣을 수 있는 이유는 향상된 for문은 내부적으로 Iterator를 사용함.
    }

    System.out.println("entrySet 활용");
    Set<Map.Entry<String, Integer>> entries = studentMap.entrySet();
    for (Map.Entry<String, Integer> entry : entries) {
      String key = entry.getKey();
      Integer value = entry.getValue();
      System.out.println("key = " + key + ", value = " + value);
    }

    System.out.println("values 활용");
    Collection<Integer> values = studentMap.values();
    Iterator<Integer> iterator = values.iterator();


    while(iterator.hasNext()) { // 만약에 values.iterator().hasNext()를 조건에 걸어두면 매번 새로운 Iterator가 반환 되기 때문에 문제 발생.
      Integer value = iterator.next();
      System.out.println(value);
    }


    System.out.println("values 활용");
    Collection<Integer> values1 = studentMap.values();
    for (Integer value : values1) {
      System.out.println("value = " + value);
    }




  }
}

/*
package collection.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapMain1 {

  public static void main(String[] args) {
    Map<String, Integer> studentMap = new HashMap<>();

    // 학생 성적 데이터 추가
    studentMap.put("studentA", 90);
    studentMap.put("studentB", 80);
    studentMap.put("studentC", 80);
    studentMap.put("studentD", 100);

    System.out.println(studentMap);

    // 특정 학생의 값 조회
    Integer result = studentMap.get("studentD");
    System.out.println("result = " + result);

    System.out.println("keySet 활용");
    Set<String> keySet = studentMap.keySet();
    for (String key : keySet) {
      Integer value = studentMap.get(key);
      System.out.println("key=" + key + ", value=" + value);
    }

    System.out.println("entrySet 활용");
    Set<Map.Enrty<String, Integer>> entries = studentMap.entrySet();
    for (Map.Entry<String, Integer> entry : entries) {
      String key = entry.getKey();
      Integer value = entry.getValue();
      System.out.println("key = " + key + ", value = " + value);
    }

    System.out.println("values 활용");
    Collection<Integer> values = studentMap.values();
    for (Integer value : values) {
      System.out.println("value = " value);
    }

  }

}



 */

/*
Iterable 인터페이스

public interface Iterable<T> {
  Iterator<T> iterator(); // Iterable이 iterator를 의존.
  //의존하니까 LinkedList, ArrayList 이런 곳에 있는 내부 클래스에서 iterator 안에 있는
  hasNext(), next(), remove()가 구현 되서 쓸 수 있는것.


}

 public Iterator<E> iterator() {
        return new Itr();  // ← 여기서 Itr 객체를 생성해서 반환
        내부 클래스라 return new Itr();를 해도된다.

        마치 어떤 클래스 내에 private 생성자 메서드가 있는데 그냥 사용하는것 처럼.
        // Iterator<E> iterator = treeset.iterator(); 원래 직접적으로 인터페이스를 new할수는 없지만 간접적으로는 가능.
    }

public interface Iterator<E> {
  boolean hasNext(); // 다음 요소가 있는가?
  E next(); // 다음 요소 꺼내기
  void remove(); // (선택적) 요소 제거
}

Object(최상위) - Iterable<E> - Collection<E>

Iterator는 독립적 (Iterator를 implements 하는 클래스들 ArrayList.Itr, LinkedList.ListItr 등등이 있음)

_______________________________________________________________________________________


public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable {

    // ... 생략

    public Iterator<E> iterator() {
        return new Itr();  // ← 여기서 Itr 객체를 생성해서 반환
        내부 클래스라 return new Itr();를 해도된다.

        마치 어떤 클래스 내에 private 생성자 메서드가 있는데 그냥 사용하는것 처럼.
    }


private class Itr implements Iterator<E> {
  int cursor = 0;

  public boolean hasNext() {
    return cursor != size();
  }

  public E next() {
    if (cursor >= size()) throw new NoSuchElementException();
    return get(cursor++);
  }

  public void remove() {
    throw new UnsupportedOperationException("remove");
  }
}
}
___________________________________________________________________________________________________

원래 List나 Set은 Iterator를 직접 implements 하지 않지만,
Iterable을 상속하고 있고 Iterable은 iterator()로 Iterator를 리턴해야 하므로
내부 클래스에서 Iterator를 구현해서 제공한다.

결국 Iterable → Collection → List/Set으로 상속 구조가 이어지고,
내부에 구현된 Iterator 덕분에
hasNext(), next(), remove() 등의 반복 기능을 사용할 수 있게 되는 구조다.

그럼 결론이 이거지? 원래 Iterator 인터페이스를 implements 하지 않는데 Iterable이 Iterator를 의존하고
그 의존하는 Iterator에 hasNext() , remove(), next() 라는 메서드들이 있는데
이것들을 implements 하는게 Set 인터페이스를 implements 하는 클래스들과 List 인터페이스를
implements 하는 클래스들의 내부클래스에서 iterator를 구현한거고..
어찌됐든 iterable -> Collection -> List, Set.. 등이니까
List,Set 다 iterable을 상속 받는데 iterator 인터페이스는 독립적이여도
내부 클래스에 구현한 iterator 메서드들이 있는데 iterable은 iterator를 의존하니까 사실상 사용 가능하다.


그럼 원래는 Collection 인터페이스 , Set 인터페이스엔 뭐 따로 배열이나 데이터를 보관하는건 없고
구현해야 하는 메서드들만 있는건데 내가말한 구조 + 향상된 for문일땐 요소를 순회하니까 나온다.

___________________________________________________________________________--

최종 정리

컬렉션에는 List, Set등이 있는데 이 인터페이스들을 implements 하는 클래스는 ArrayList, LinkedList, HashSet, LinkedSet, TreeSet 등이 있다.
근데 이것들을 보면 내부 클래스에 Iterator를 반환하는 메서드가 있음.
그러면 Iterator를 담는 변수를 하나 만들고 이 변수로 hasNext, next 메서드에 접근 하는 것.

그리고 애초에 Iterable이라는 인터페이스에 Iterator<E> iterator(); 가 있기에 Collection 을 상속받는 인터페이스나 구현하는 클래스는
iterator()를 만들어줘야함. 그래서 이 iterator()의 반환은 Iterator<E>이면서 동시에 Iterator 인터페이스에 있는 구현해야 할 메서드를 사용하는 것.

그리고 ArrayList, LinkedList, HashSet 이런 클래스들에는 Iterator를 반환하는 내부 클래스에 당연히 Iterator 인터페이스 안에 있는
hasNext(),next() 이런 메서드들도 구현 했음. 그래서 사용 가능한 것.


_________________________________________________________________________________________________-

Map은 키-값의 쌍을 저장하는 자료 구조이다.

-키는 맵 내에서 유일해야 한다. 그리고 키를 통해 값을 빠르게 검색할 수 있다.
-키는 중복될 수 없지만, 값은 중복될 수 있다.
-Map은 순서를 유지하지 않는다.


 */
