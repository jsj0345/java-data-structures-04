package collection.map;

import java.util.*;

public class JavaMapMain {

  public static void main(String[] args) {
    run(new HashMap<>());
    run(new LinkedHashMap<>());
    run(new TreeMap<>());
  }

  private static void run(Map<String, Integer> map) {
    System.out.println("map = " + map.getClass());
    map.put("C", 10);
    map.put("B", 20);
    map.put("A", 30);
    map.put("1", 40);
    map.put("2", 50);

    Set<String> keySet = map.keySet();
    Iterator<String> iterator = keySet.iterator();

    while (iterator.hasNext()) {
      String key = iterator.next();
      System.out.print(key + "=" + map.get(key) + " ");
    }
    System.out.println();
  }

}

/*
package collection.map;

import java.util.*;

public class JavaMapMain {

  public static void main(String[] args) {
    run(new HashMap<>());
    run(new LinkedHashMap<>());
    run(new TreeMap<>());
  }

  private static void run(Map<String, Integer> map) {
    System.out.println("map = " + map.getClass());
    map.put("C", 10);
    map.put("B", 20);
    map.put("A", 30);
    map.put("1", 40);
    map.put("2", 50);

    Set<String> keySet = map.keySet();
    Iterator<String> iterator = keySet.iterator();

    while(iterator.hasNext()) {
      String key = iterator.next();
      System.out.println(key + "=" + map.get(key) + " ");
    }

    System.out.println();
  }

}

HashMap: 입력한 순서를 보장하지 않는다.
LinkedHashMap : 키를 기준으로 입력한 순서를 보장한다.
TreeMap : 키 자체의 데이터 값을 기준으로 정렬한다.

자바의 HashMap은 Key를 사용해서 해시 코드를 생성한다.

Map의 Key로 사용되는 객체는 hashCode(), equals()를 반드시 구현해야 한다.
 */
