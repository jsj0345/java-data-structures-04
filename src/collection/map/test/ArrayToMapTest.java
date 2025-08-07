package collection.map.test;

// 다음 예제를 참고해서 2차원 배열의 데이터를 Map<String, Integer>로 변경해라.
// 그리고 실행 결과를 참고해서 Map을 출력해라. 출력 순서는 상관 없다.


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ArrayToMapTest {

  public static void main(String[] args) {
    String[][] productArr = {{"Java", "10000"}, {"Spring", "20000"}
        , {"JPA", "30000"}};

    // 주어진 배열로부터 Map 생성 - 코드 작성
    HashMap<String, String> hashMap = new HashMap<>();
    for(String[] product : productArr) {
      hashMap.put(product[0], product[1]);
    }

    for (String key : hashMap.keySet()) {
      System.out.println("제품: " + key + ", 가격: " + hashMap.get(key));
    }


    // arrayToMap(productArr, hashMap);

    // System.out.println("방법1로 했을때의 결과");



    // Map의 모든 데이터 출력 - 코드 작성(방법1)
    /*
    Set<Map.Entry<String, String>> entries = hashMap.entrySet();
    for (Map.Entry<String, String> entry : entries) {
      String key1 = entry.getKey();
      String value = entry.getValue();
      System.out.println("제품: " + key1 + ", 가격: " + value);
    }

    System.out.println("방법2로 했을때의 결과");


    */

    /*
    // 방법 2
    Set<String> keySet = hashMap.keySet();
    for(String key : keySet) {
      System.out.println("제품: " + key + ", 가격: " + hashMap.get(key));
    }

    // 방법3
    System.out.println("방법3로 했을때의 결과");
    Set<String> keySet1 = hashMap.keySet();
    Iterator<String> iterator = keySet1.iterator();

    while(iterator.hasNext()) {
      String key1 = iterator.next();
      System.out.println("제품: " + key1 + ", 가격: " + hashMap.get(key1));
    }

     */

  }

  private static void arrayToMap(String[][] productArr, HashMap<String, String> hashMap) {
    String key = "";
    String value = "";

    for(int i=0; i < 3; i++) {
      for(int j = 0; j < 2; j++) {
        if(j==0) {
          key = productArr[i][j];
        } else {
          value = productArr[i][j];
        }
      }
      hashMap.put(key, value);
    }
  }
}

/*
package collection.map.test;

public class ArrayToMapTest {
  public static void main(String[] args) {
    String[][] productArr = {{"Java", "10000"}, {"Spring", "20000"}
    , {"JPA", "30000"}};

    HashMap<String, String> hashMap = new HashMap<>();

    arrayToMap(productArr, hashMap);

    System.out.println("방법 1로 했을때의 결과");

    // Map의 모든 데이터 출력 - 코드 작성(방법1)
    Set<Map.Entry<String, String>> entries = hashMap.entrySet();
    for (Map.Entry<String, String> entry : entries) {
      String key1 = entry.getKey();
      String value = entry.getValue();
      System.out.println("제품: " + key1 + ", 가격: " + value);
    }

    System.out.println("방법 2로 했을때의 결과");

    // 방법 2
    Set<String> keySet = hashMap.keySet();
    for(String key : keySet) {
      System.out.println("제품: " + key + ", 가격: " + hashMap.get(key));
    }

    System.out.println("방법 3로 했을때의 결과");

    // 방법3
    System.out.println("방법3로 했을때의 결과");
    Set<String> keySet1 = hashMap.keySet();
    Iterator<String> iterator = keySet1.iterator();

    while(iterator.hasNext()) {
      String key1 = iterator.next();
      System.out.println("제품: " + key1 + ", 가격: " + hashMap.get(key1));
    }



  }

  private static void arrayToMap(String[][] productArr, HashMap<String, String> hashMap) {
    String key ="";
    String value = "";

    for(int i=0; i < 3; i++) {
     for(int j=0; j < 2; j++) {
      if(j==0) {
        key = productArr[i][j];
      } else {
        value = productArr[i][j];
      }
     }
     hashMap.put(key, value);
    }
  }

 }

package collection.map.test;

public class ArrayToMapTest {

  public static void main(String[] args) {

    String[][] productArr = {{"Java", "10000"}, {"Spring", "20000"}
      ,{"JPA","30000"} };

    Map<String, Integer> productMap = new HashMap<>();

    for (String[] product : productArr) {
      productMap.put(product[0], Integer.valueOf(product[1]));
    }

    // Map의 모든 데이터 출력
    for (String key : productMap.keySet()) {
      System.out.println("제품: " + key + ", 가격: " + productMap.get(key));
    }

  }

}








 */
