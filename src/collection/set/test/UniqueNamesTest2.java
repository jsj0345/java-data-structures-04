package collection.set.test;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class UniqueNamesTest2 {

  public static void main(String[] args) {
    Integer[] inputArr = {30, 20, 20, 10, 10};
    Set<Integer> set = new LinkedHashSet<>();

    for (Integer a : inputArr) {
      set.add(a);
    }

    Iterator<Integer> iterator = set.iterator();

    while(iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

}
