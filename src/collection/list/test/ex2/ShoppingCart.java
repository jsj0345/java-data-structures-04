package collection.list.test.ex2;

import java.util.ArrayList;

public class ShoppingCart {
  private ArrayList<Item> shoppinglist = new ArrayList<>();
  private int total = 0;

  public void addItem(Item item) {
    shoppinglist.add(item);
  }

  public void displayItems() {
    System.out.println("장바구니 상품 출력");
    for(Item a : shoppinglist) {
      System.out.println("상품명:" + a.getName() + ", 합계:" + a.getTotalPrice());
      total += a.getTotalPrice();
    }
    System.out.println("전체 가격 합:" + total);
  }


}
