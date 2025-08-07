package collection.map.test.cart;

import java.util.Objects;

public class Product {

  private String name;
  private int price;

  // 코드 작성
  public Product(String name, int price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "Product{" +
        "name='" + name + '\'' +
        ", price=" + price +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return price == product.price && Objects.equals(name, product.name);
  }
  @Override
  public int hashCode() {
    return Objects.hash(name, price);
  }
}

/*
상품명과 가격이 같은 경우에는 같은 상품으로 취급해야 한다.

따라서, 같은 해시코드 값을 구해야하고 중복을 방지하기 위해 equals() 메서드를 활용해야한다.


 */
