package collection.map.test.cart;

import java.util.*;

public class Cart {
  private Map<Product, Integer> cartMap = new HashMap<>();

  public void add(Product product, int addQuantity) {
    int existingQuantity = cartMap.getOrDefault(product, 0);
    cartMap.put(product, existingQuantity + addQuantity);

    /*
    getOrDefault 메서드는 해당 키가 없으면 defaultValue 값을 반환한다.
    Map 구조를 바꾸는 것이 아님. 단순히 값을 반환할 뿐임.
    해당 키가 있으면 기존 값을 반환함! (맵 구조 안바뀜 오해X)
    */
  }

  public void minus(Product product, int minusQuantity) {
    int existingQuantity = cartMap.getOrDefault(product, 0);
    int newQuantity = existingQuantity - minusQuantity;
    if (newQuantity <= 0) {
      cartMap.remove(product); // key, Value 둘다 없앰.
    } else {
      cartMap.put(product, newQuantity);
    }
  }

  public void printAll() {
    System.out.println("==모든 상품 출력==");
    for (Map.Entry<Product, Integer> entry : cartMap.entrySet()) {
      System.out.println("상품: " + entry.getKey() + " 수량: " +
          entry.getValue());
    }
  }

}

/*
package collection.map.test.cart;

import java.util.HashMap;
import java.util.Map;

public class Cart {

  private Map<Product, Integer> cartMap = new HashMap<>();

  public void add(Product product, int addQuantity) {
    int existingQuantity = cartMap.getOrDefault(product, 0);
    cartMap.put(product, existingQuantity + addQuantity);
  }

  public void minus(Product product, int minusQuantity) {
    int existingQuantity = cartMap.getOrDefault(product, 0);

    int newQuantity = existingQuantity - minusQuantity;

    if (newQuantity <= 0) {
      cartMap.remove(product);
    } else {
      cartMap.put(product, newQuantity);
    }

  }

  public void printAll() {

    System.out.println("==모든 상품 출력==");
    for (Map.Entry<Product, Integer> entry : cartMap.entrySet()) {
      System.out.println("상품: " + entry.getKey() + " , 수량: " + entry.getValue());
    }

  }
}

 */








