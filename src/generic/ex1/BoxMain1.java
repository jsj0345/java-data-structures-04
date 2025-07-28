package generic.ex1;

public class BoxMain1 {

  public static void main(String[] args) {
    IntegerBox integerBox = new IntegerBox();
    integerBox.set(10); // 오토박싱
    Integer integer = integerBox.get();
    System.out.println("integer = " + integer);

    StringBox stringBox = new StringBox();
    stringBox.set("hello");
    String str = stringBox.get();
    System.out.println("str = " + str);


    //int a = 10;
    //Integer b = Integer.valueOf(a);
    //System.out.println(b.toString());

    /*
    이 코드를 보면 Integer 형이나 String형 다 잘 담고 있다.
    그런데 만약에 다른 여러가지 형들을 담아야 한다면 수십개의 클래스를 타입에 맞게 만들어야 할 것이다.
    좀 한계가 있다. 어떻게 해결 해볼까?
    Object를 활용해보자.
     */
  }
}

/*
package generic.ex1;

public class BoxMain1 {

  public static void main(String[] args) {
    IntegerBox integerBox = new IntegerBox();
    integerBox.set(10);
    Integer integer = integerBox.get();
    System.out.println("integer = " + integer);

    StringBox stringBox = new StringBox();
    stringBox.set("hello");

    String str = stringBox.get();
    System.out.println("str = " + str);
  }
}

package generic.ex1;

public class BoxMain1 {

  public static void main(String[] args) {
    IntegerBox integerBox = new IntegerBox();
    integerBox.set(10); // 오토 박싱

    set 메서드를 보면 Integer value가 매개 변수임.

    즉, Integer value = 10; 이건데
    원래 참조형에 기본값을 못넣음. 그래서
    Integer.valueOf(10);이 생략 되어있고
    이것을 통해 Integer 클래스에 있는 멤버 변수에 10을 초기화함.
    즉 Integer 객체안에 어떤 변수에 10을 넣은것.

    Integer integer = integerBox.get();
    System.out.println("integer = " + integer);

    StringBox stringBox = new StringBox();
    stringBox.set("hello");
    String str = stringBox.get();
    System.out.println("str = " + str);

 */


/*
Integer integer = new Integer(100);
int a = integer.intValue();
System.out.println(a);

valueOf라는 메서드를 살펴보자.

 public static Integer valueOf(int i) {
        if (i >= IntegerCache.low && i <= IntegerCache.high)
            return IntegerCache.cache[i + (-IntegerCache.low)];
        return new Integer(i);
    }

이런 구조임. 여기서 println에다가 Integer형인 객체를 넣으면
Integer 클래스에 있는 toString을 호출.
호출 한 다음에 String형으로 반환.
반환 한 상태에서 println에서 콘솔창에다가 보여줌.

여기서 의문인건 객체를 println()에 매개변수로 넣어서
숫자를 문자열로 반환한건데 여기서 숫자는 어떻게 나온걸까?

Integer 클래스에 value라는 멤버 변수를 이용한 것.
toString 메서드를 보면 return toString(value); 라고 있음
return 옆에 있는 toString은 문자열로 바꾸는 메서드를 의미.

 */
