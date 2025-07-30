package collection.set.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
집합1: 1, 2, 3, 4, 5
집합2: 3, 4, 5, 6, 7

두 집합의 합집합, 교집합, 차집합을 구해라. 출력 순서는 관계없다.

합집합 : [1, 2, 3, 4, 5, 6, 7]
교집합 : [3, 4, 5]
차집합 : [1, 2]

Set 인터페이스의 주요 메서드를 참고하자.

그리고 Set 구현체의 생성자에는 배열을 넣을 수 없지만. List는 가능함.
 */

public class SetOperationsTest {

  public static void main(String[] args) {
    Set<Integer> set1 = new HashSet<>(List.of(1, 2, 3, 4, 5));
    Set<Integer> set2 = new HashSet<>(List.of(3, 4, 5, 6, 7));

    Set<Integer> union = new HashSet<>(set1);
    union.addAll(set2);

    Set<Integer> intersection = new HashSet<>(set1);
    intersection.retainAll(set2);

    Set<Integer> difference = new HashSet<>(set1);
    difference.removeAll(set2);

    System.out.println("합집합: " + union);
    System.out.println("교집합: " + intersection);
    System.out.println("차집합: " + difference);

    /*
    Object[] set1_array = set1.toArray();
    Object[] set2_array = set2.toArray();

    interSection(set1_array, set2_array);
    union(set1_array, set2_array);
    difference(set1_array, set2_array);

     */

  }

  /*
  주석 친 부분들은 코드 길이도 길고 유지 보수의 어려움이 있음.
  특히 합집합을 구현한 방식은 중복된 요소를 불필요하게 여러번 add를 시도함.
  intValue() 비교 로직이 중복 된다.

  또한 Set을 사용하고 있음에도 Object[]로 변환해서 수작업 반복문을 돌리는 건 Set의 장점을 포기하는 행위.

  private static void interSection(Object[] set1_array, Object[] set2_array) {
    Set<Integer> set3 = new HashSet<>();
    for(Object a : set1_array) {
      Integer b = (Integer) a;
      for(int i = 0; i < set2_array.length; i++) {
        Integer c = (Integer) set2_array[i];
        if(b.intValue() == c.intValue()) {
          set3.add(b);
        }
      }

    }
    System.out.println("교집합: " + set3);
  }

  private static void union(Object[] set1_array, Object[] set2_array) {
    Set<Integer> set3 = new HashSet<>();
    for(Object a : set1_array) {
      Integer b = (Integer) a;
      set3.add(b);
      for(int i = 0; i < set2_array.length; i++) {
        Integer c = (Integer) set2_array[i];
        if(b.intValue() != c.intValue()) {
          set3.add(c);
        }
      }

    }
    System.out.println("합집합: " + set3);
  }

  private static void difference(Object[] set1_array, Object[] set2_array) {
    Set<Integer> set3 = new HashSet<>();
    for(Object a : set1_array) {
      Integer b = (Integer) a;
      set3.add(b);
      for(int i = 0; i < set2_array.length; i++) {
        Integer c = (Integer) set2_array[i];
        if(b.intValue() == c.intValue()) {
          set3.remove(b);
        }
      }

    }
    System.out.println("차집합: " + set3);
  }

   */



}
