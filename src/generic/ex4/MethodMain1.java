package generic.ex4;

public class MethodMain1 {

  public static void main(String[] args) {
    Integer i = 10;
    Object object = GenericMethod.objMethod(i);
    // System.out.println(object);

    /*
    위 코드에서는 objMethod의 반환 값이 object형임.
    근데 이걸 Integer로 바꾸려면 변수가 Integer형이여야함.
    동시에 다운 캐스팅을 해줘야함.

    좀 번거러움.
     */

    // 타입 인자(Type Argumnet) 명시적 전달
    System.out.println("명시적 타입 인자 전달");
    Integer result = GenericMethod.<Integer>genericMethod(i);
    Integer integerValue = GenericMethod.<Integer>numberMethod(10);
    Double doubleValue = GenericMethod.<Double>numberMethod(20.0);

    /*
    위 코드에서 <Integer>,<Double>와 같이 제네릭을 계속 적는건 좀 귀찮다.

    매개변수에 뭘 넣었는지에 따라 추론이 가능해서 <>를 생략해도 괜찮다. (물론 상황에 따라 다름.)
     */

    System.out.println("타입 추론");
    Integer result2 = GenericMethod.genericMethod(i);
    Integer integerValue2 = GenericMethod.numberMethod(10);
    Double doubleValue2 = GenericMethod.numberMethod(20.0);

  }
}

/*
package generic.ex4;

public class MethodMain1 {

  public static void main(String[] args) {
    Integer i = 10;
    Object object = GenericMethod.objMethod(i);

    // 타입 인자(Type Argument) 명시적 전달
    System.out.println("명시적 타입 인자 전달");
    Integer result = GenericMethod.<Integer>genericMethod(i);
    Integer integerValue = GenericMethod.<Integer>numberMethod(10);
    Double doubleValue = GenericMethod.<Double>numberMethod(20.0);

    위처럼 계속 제네릭을 적는 것은 살짝 번거롭다.
    다음과 같이 적어보자.

    Integer result1 = GenericMethod.genericMethod(i);
    Integer integerValue1 = GenericMethod.numberMethod(10);
    Double doubleValue = GenericMethod.numberMethod(20.0);

    제네릭 메서드는 메서드 범위내로 한정해서 매개변수로 인해 제네릭 타입이 결정됨.
    매개변수 타입이 정해지면 반환형도 알아서 정해짐. (즉 매개변수로 추론 가능)
  }


}


 */