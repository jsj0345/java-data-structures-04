package collection.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MapMain3 {

  public static void main(String[] args) {
    Map<String, Integer> studentMap = new HashMap<>();
    // 학생 성적 데이터 추가
    studentMap.put("studentA", 50);
    System.out.println(studentMap);

    // 학생이 없는 경우에만 추가1
    if (!studentMap.containsKey("studentA")) {
      studentMap.put("studentA", 100);
    }
    System.out.println(studentMap);

    // 학생이 없는 경우에만 추가2
    studentMap.putIfAbsent("studentA", 100); // key가 없는 경우에 값을 넣는 것.
    studentMap.putIfAbsent("studentB", 100); // value가 null일때 IfAbsent는 key가 없는걸로 간주하고 value값을 초기화함
    /*
    putIfAbsent 메서드 살펴보기

    default V putIfAbsent(K key, V value) {
        V v = get(key);
        if (v == null) {
            v = put(key, value);
        }

        return v;
    }

     */
    System.out.println(studentMap);
  }
}

/*
package collection.map;

import java.util.HashMap;
import java.util.Map;

public class MapMain3 {

  public static void main(String[] args) {
    Map<String, Integer> studentMap = new HashMap<>();

    // 학생 성적 데이터 추가
    studentMap.put("studentA", 50);
    System.out.println(studentMap);

    // 학생이 없는 경우에만 추가1
    if (!studentMap.containsKey("studentA")) {
      studentMap.put("studentA", 100);
    }

    System.out.println(studentMap);

    // 학생이 없는 경우에만 추가2
    studentMap.putIfAbsent("studentA", 100);
    studentMap.putIfAbsent("studentB", 100);
    System.out.println(studentMap);
  }

}


______________________________________________________________________________________

Map vs Set

-Map의 키는 중복을 허용하지 않고, 순서를 보장하지 않는다.
Map의 키가 바로 Set과 같은 구조이다. 그리고 Map은 모든 것이 Key를 중심으로 동작한다.
Value는 단순히 Key 옆에 따라 붙은 것 뿐이다. Key 옆에 Value만 하나 추가해주면 Map이 되는 것이다.
Map과 Set은 거의 같다. 단지 옆에 Value를 가지고 있는가 없는가의 차이가 있을 뿐이다.

참고 : 실제로 자바 HashSet의 구현은 대부분 HashMap의 구현을 가져다 사용한다.
Map에서 Value만 비워두면 Set으로 사용할 수 있다.

참고사항이 진짜인지 확인해보자.

public class HashSet<E>
    extends AbstractSet<E>
    implements Set<E>, Cloneable, java.io.Serializable
{

public HashSet() {
  map = new HashMap<>();
}


public HashSet(Collection<? extends E> c) {
  map = HashMap.newHashMap(Math.max(c.size(), 12));
  addAll(c);
}

코드를 보면 HashMap으로 코드를 짜는 걸 볼 수 있다.

1. HashMap :

- 구조 : HashMap은 해시를 사용해서 요소를 저장한다. 키(Key) 값은 해시 함수를 통해
해시 코드로 변환되고, 해시 코드는 데이터를 저장하고 검색하는 데 사용된다.

- 특징 : 삽입,삭제,검색 작업은 해시 자료 구조를 사용하므로 일반적으로 상수 시간(O(1))의 복잡도를 가진다.

- 순서 : 순서를 보장하지 않는다.

2. LinkedHashMap :

- 구조 : LinkedHashMap은 HashMap과 유사하지만, 연결 리스트를 사용하여 삽입 순서 또는
최근 접근 순서에 따라 요소를 유지한다.

- 특징 : 입력 순서에 따라 순회가 가능하다.
HashMap과 같지만 입력 순서를 링크로 유지해야 한다. (prev, next 활용)

- 성능 : HashMap과 유사하게 대부분의 작업은 O(1)의 시간 복잡도를 가진다.

- 순서 : 입력 순서를 보장한다.

3. TreeMap :

- 구조 : TreeMap은 레드-블랙 트리를 기반으로 한 구현이다.
- 특징 : 모든 키는 자연 순서 또는 생성자에 제공된 comparator에 의해 정렬된다.
- 성능 : get, put, remove와 같은 주요 작업들은 O(log n)의 시간 복잡도를 가진다.
- 순서 : 키는 정렬된 순서로 저장된다.


 */



