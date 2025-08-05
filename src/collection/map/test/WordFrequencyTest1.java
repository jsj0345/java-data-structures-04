package collection.map.test;

import java.util.HashMap;
import java.util.Map;

//각각의 단어거 나타난 수를 출력해라.
public class WordFrequencyTest1 {

  public static void main(String[] args) {

    String text = "orange banana apple apple banana apple";
    String[] text_split = text.split(" ");
    Map<String, Integer> text_map = new HashMap<>();


    int orange_count = 0;
    int banana_count = 0;
    int apple_count = 0;


    for(int i = 0; i < text_split.length; i++) {
      if(text_split[i].equals("orange")){
        orange_count++;
        text_map.put(text_split[i], orange_count);
      } else if(text_split[i].equals("banana")) {
        banana_count++;
        text_map.put(text_split[i], banana_count);
      } else {
        apple_count++;
        text_map.put(text_split[i], apple_count);
      }
    }

    System.out.println(text_map);


    String text1 = "orange banana apple apple banana apple";
    Map<String, Integer> map = new HashMap<>();
    String[] words = text1.split(" ");
    for (String word : words) {
      Integer count = map.get(word);
      if (count == null) {
        count = 0;
      }
      count++;
      map.put(word, count); //put 메서드는 key가 같아도 value는 변경 할 수 있음.
    }

    System.out.println(map);

  }

}
