package collection.set.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class UniqueNamesTest3 {

  public static void main(String[] args) {
    Integer[] inputArr = {30, 20, 20, 10, 10};

    Set<Integer> treeSet = new TreeSet<>();

    for(Integer a : inputArr) {
      treeSet.add(a);
    }

    Iterator<Integer> iterator = treeSet.iterator();

    while(iterator.hasNext()) {
      System.out.println(iterator.next());
    }


  }
}
