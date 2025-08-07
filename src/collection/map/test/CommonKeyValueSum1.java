package collection.map.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//map1과 map2에 공통으로 들어있는 키를 찾고, 그 값의 합을 구해라.
public class CommonKeyValueSum1 {

  public static void main(String[] args) {
    Map<String, Integer> map1 = new HashMap<>();
    map1.put("A", 1);
    map1.put("B", 2);
    map1.put("C", 3);

    Map<String, Integer> map2 = new HashMap<>();
    map2.put("B", 4);
    map2.put("C", 5);
    map2.put("D", 6);

    // System.out.println(commonKeyFindAndSum(map1, map2));

    HashMap<String, Integer> result = new HashMap<>();

    for(String key : map1.keySet()) {
      if(map2.containsKey(key)) {
        result.put(key, map1.get(key) + map2.get(key));
      }
    }

    System.out.println(result);
  }

  private static Map<String, Integer> commonKeyFindAndSum(Map<String, Integer> map1, Map<String, Integer> map2) {
    Set<String> map1_key = map1.keySet();
    Map<String, Integer> map3 = new HashMap<>();

    int sum = 0;
    for(String key : map1_key) {
      if(map2.containsKey(key)) {

        sum = map1.get(key) + map2.get(key);
        map3.put(key,sum);
      }
    }

    return map3;
  }

}

/*
package collection.map.test;

import java.util.HashMap;
import java.util.Map;

public class CommonKeyValueSum1 {

  public static void main(String[] args) {
    Map<String, Integer> map1 = new HashMap<>();
    map1.put("A", 1);
    map1.put("B", 2);
    map1.put("C", 3);

    Map<String, Integer> map2 = new HashMap<>();
    map2.put("B", 4);
    map2.put("C", 5);
    map2.put("D", 6);

    System.out.println(commonKeyFindAndSum(map1, map2));
  }

  private static Map<String, Integer> commonKeyFindAndSum(Map<String, Integer> map1, Map<String, Integer> map2) {
    Set<String> map1_key = map1.keySet();
    Map<String, Integer> map3 = new HashMap<>();

    int sum = 0;
    for(String key : map1_key) {
      if(map2.containsKey(key)) {
        sum = map1.get(key) + map2.get(key);
        map3.put(key,sum);
      }
    }

    return map3;
  }


  }

}

package collection.map.test;

import java.util.HashMap;
import java.util.Map;

public class CommonKeyValueSum1 {

  public static void main(String[] args) {
    Map<String, Integer> map1 = new HashMap<>();
    map1.put("A", 1);
    map1.put("B", 2);
    map1.put("C", 3);

    Map<String, Integer> map2 = new HashMap<>();
    map2.put("B", 4);
    map2.put("C", 5);
    map2.put("D", 6);

    Map<String, Integer> result = new HashMap<>();

    for (String key : map1.keySet()) {
      if (map2.containsKey(key)) {
        result.put(key, map1.get(key) + map2.get(key));
      }
    }

    System.out.println(result);

 }

}


 */
