package collection.map.test;

import java.util.*;

// Map에 들어있는 데이터 중에 값이 1000원인 모든 상품을 출력해라.
public class ItemPriceTest {

  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();
    map.put("사과", 500);
    map.put("바나나", 500);
    map.put("망고", 1000);
    map.put("딸기", 1000);


    Set<String> keySet = map.keySet();
    Iterator<String> iterator = keySet.iterator();

    while(iterator.hasNext()) {
      String key = iterator.next();
      if(map.get(key) != 1000) {
        iterator.remove();
      }
    }

    System.out.println(keySet);

  }


}
