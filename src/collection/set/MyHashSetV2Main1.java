package collection.set;

public class MyHashSetV2Main1 {

  public static void main(String[] args) {
    MyHashSetV2 set = new MyHashSetV2(10);
    set.add("A");
    set.add("B");
    set.add("C");
    set.add("D");
    set.add("AB");
    set.add("SET");
    System.out.println(set);

    System.out.println("A.hashCode() = " + "A".hashCode());
    System.out.println("B.hashCode() = " + "B".hashCode());
    System.out.println("AB.hashCode() = " + "AB".hashCode());
    System.out.println("SET.hashCode() = " + "SET".hashCode());

    /*
    원래 아스키 코드를 보면 S E T를 다 더해도 큰 값이 안나온다.

    콘솔창을 보면 해시 코드 값이 크다. 이러한 이유는 해시 충돌을 좀 방지하기 위해

    내부에서 연산을 덧셈이 아닌 다른 연산을 한 것.
     */

    //검색
    String searchValue = "SET";
    boolean result = set.contains(searchValue);
    System.out.println("set.contains(" + searchValue + ") = " + result);




  }
}

/*
타입	 hashCode() 구현 방식
Object	 참조값 (주소 기반, 네이티브)
String	 아스키 + 31 곱셈 방식
Integer	 값 그대로 반환
Long	 상위/하위 32비트 XOR
Double	 long 변환 후 XOR
Boolean	 true → 1231, false → 1237
배열	 Arrays.hashCode(...)로 따로 처리
사용자 정의 클래스	 Objects.hash(...) 또는 커스텀 계산

위에서 봤듯이 각 클래스에는 hashCode를 구하는 메서드가 있음.

그런데 Objects.hash 메서드는 모든 타입을 다 담을 수 있고 담은 것들의
해시 코드 값을 알 수 있다.

그럼 이거만 쓰면 되는거 아닌가?

아니다. 편리한 대신 성능이 좀 떨어진다. 그래서 좀 더 빠르게 hashCode를 구하고 싶으면

각 클래스의 hashCode 메서드를 활용 하는 것도 괜찮다.

package collection.set;

public class MyHashSetV2Main1 {

  public static void main(String[] args) {
    MyHashSetV2 set = new MyHashSetV2(10);

    set.add("A");
    set.add("B");
    set.add("C");
    set.add("D");
    set.add("AB");
    set.add("SET");
    System.out.println(set);

    System.out.println("A.hashCode = " + "A".hashCode());
    System.out.println("B.hashCode = " + "B".hashCode());
    System.out.println("AB.hashCode = " + "AB".hashCode());
    System.out.println("SET.hashCode = " + "SET".hashCode());

    String searchValue = "SET";
    boolean result = set.contains(searchValue);
    System.out.println("set.contains(" + searchValue + ") = " + result);
  }

}

 */
