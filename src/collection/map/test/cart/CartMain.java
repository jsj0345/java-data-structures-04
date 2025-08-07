package collection.map.test.cart;

/*
장바구니 추가 - add()
- 장바구니에 상품과 수량을 담는다. 상품의 이름과 가격이 같으면 같은 상품이다.
- 장바구니에 이름과 가격이 같은 상품을 추가하면 기존에 담긴 상품에 수량만 추가된다.
- 장바구니에 이름과 가격이 다른 상품을 추가하면 새로운 상품이 추가된다.

장바구니 제거 - minus()
- 장바구니에 담긴 상품의 수량을 줄일 수 있다. 만약 수량이 0보다 작다면 상품이 장바구니에서 제거된다.

CartMain과 실행 결과를 참고해서 Product, Cart 클래스를 완성하자.

Cart 클래스는 Map을 통해 상품을 장바구니에 보관한다.
 */

public class CartMain {

  public static void main(String[] args) {
      Cart cart = new Cart();
      cart.add(new Product("사과", 1000), 1);
      cart.add(new Product("바나나", 500), 1);

      cart.printAll();
      cart.add(new Product("사과", 1000), 2);

      cart.printAll();
      cart.minus(new Product("사과", 1000), 3);

      cart.printAll();
  }

}




/*
package collection.map.test.cart;

public class CartMain {

  public static void main(String[] args) {
    Cart cart = new Cart();
    cart.add(new Product("사과", 1000), 1);
    cart.add(new Product("바나나", 500), 1);
    cart.printAll();

    cart.add(new Product("사과", 1000), 2);
    cart.printAll();

    cart.minus(new Product("사과", 1000), 3);
    cart.printAll();
  }

}





==모든 상품 출력==
상품: Product{name='사과', price=1000} 수량: 1
상품: Product{name='바나나', price=500} 수량: 1
==모든 상품 출력==
상품: Product{name='사과', price=1000} 수량: 3
상품: Product{name='바나나', price=500} 수량: 1
==모든 상품 출력==
상품: Product{name='바나나', price=500} 수량: 1
 */
