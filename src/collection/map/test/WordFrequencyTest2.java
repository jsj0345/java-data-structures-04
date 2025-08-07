package collection.map.test;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencyTest2 {

  public static void main(String[] args) {
    String text = "orange banana apple apple banana apple";

    Map<String, Integer> map = new HashMap<>();

    String[] words = text.split(" ");

    for(String word : words) {
      Integer count = map.getOrDefault(word, 0);
      /*
      getOrDefault 메서드는 해당 키가 없으면 defaultValue 값을 반환한다.
      Map 구조를 바꾸는 것이 아님. 단순히 값을 반환할 뿐임.
      해당 키가 있으면 기존 값을 반환함! (맵 구조 안바뀜 오해X)
       */
      count++;
      map.put(word,count);
    }

    System.out.println(map);
  }
}

/*
package collection.map.test;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencyTest2 {

  public static void main(String[] args) {
    String text = "orange banana apple apple banana apple";

    Map<String, Integer> map = new HashMap<>();

    String[] words = text.split(" ");

    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    System.out.println(map);
  }

}

 */
