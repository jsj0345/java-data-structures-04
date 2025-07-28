package generic.ex1;

public class BoxMain2 {
  public static void main(String[] args) {
    ObjectBox IntegerBox = new ObjectBox();
    IntegerBox.set(10); // shift+f6은 여러 줄의 있는 같은 변수들을 이름을 한번에 바꿀수있음.
    Integer integer = (Integer) IntegerBox.get();

    /*
    Object object = IntegerBox.get();
    Integer integer = (Integer) object;
    에서 ctrl+alt+shift+T를 하면 Inline valriable을 사용해보자.
     */
    // Integer integer2 = (Integer) objectBox.get();
    System.out.println("integer = " + integer);

    ObjectBox stringBox = new ObjectBox();
    stringBox.set("hello");
    String str = (String) stringBox.get();
    System.out.println("str = " + str);




    /*
    위 코드처럼 만들면 잘 해결 된 것 같지만.. 뭔가 문제가 있다.

    만약에 integerBox.set("문자100"); 을 하면
    Integer result = (Integer) integerBox.get(); // String -> Integer로 변환됨.
    System.out.println("result = " + result);

    Object는 최상위 클래스여서 어떠한 클래스형이든 다 담을수 있는데..
    이렇게 개발자가 잘못 넣으면 문제가 발생함.
     */



  }
}

/*
package generic.ex1;

public class BoxMain2 {

  public static void main(String[] args) {
    ObjectBox integerBox = new ObjectBox();
    integerBox.set(10);
    Integer integer = (Integer) integerBox.get(); // Object -> Integer 캐스팅.
    System.out.println("integer = " + integer);

    ObjectBox stringBox = new ObjectBox();
    stringBox.set("hello");
    String str = (String) stringBox.get(); // Object -> String 캐스팅.
    System.out.println("str = " + str);

    //잘못된 타입의 인수 전달시
    integerBox.set("문자100");
    Integer result = (Integer) integerBox.get(); // String -> Integer 캐스팅 불가.
    System.out.println("result = " + result);
  }
}


다형성을 활용한 덕분에 코드의 중복을 제거하고, 기존 코드를 재사용할 수 있게 되었다.

하지만 입력할 때 실수로 원하지 않는 타입이 들어갈 수 있는 타입 안전성 문제가 발생한다.

예를 들어서 integerBox에는 숫자만 넣어야 하고,
StringBox에는 문자열만 입력할 수 있어야 한다.

하지만 박스에 값을 보관하는 set()의 매개변수가
Object이기 때문에 다른 타입의 값을 입력할 수 있다.

그리고 반환 시점에도 Object를 반환하기 때문에 원하는 타입을 정확하게 받을 수 없고,

 */
