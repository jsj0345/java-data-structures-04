package collection.set.javaSet;

import java.util.*;

public class JavaSetMain {

  public static void main(String[] args) {
    run(new HashSet<>());
    run(new LinkedHashSet<>());
    run(new TreeSet<>());
  }
  
  private static void run(Set<String> set) {
    System.out.println("set = " + set.getClass());
    set.add("C");
    set.add("B");
    set.add("A");
    set.add("1");
    set.add("2");

    System.out.println("set = " + set);
    Iterator<String> iterator = set.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next() + " ");
    }
    System.out.println();
  }

}

/*
이전에 HashSet을 구현 할 때, 배열에 LinkedList형만 들어가게 했다.
그리고 LinkedList에서 item을 조회 할 때 마다 [아이템, 아이템.., ] 이런 순으로 출력 되게하니까
출력물은 방금 언급 한 것 처럼 보임.

그런데 위에 코드를 실햄하면 출력이 그냥 단순히 [요소1, 요소2, 요소3, .. ] 이런식으로 나옴
당연히 LinkedList에서 쓰는 toString() 메서드와 다르기 때문
 */