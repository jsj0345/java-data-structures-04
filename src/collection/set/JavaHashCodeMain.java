package collection.set;

import collection.set.member.Member;

public class JavaHashCodeMain {

  public static void main(String[] args) {
    //Object의 기본 hashCode는 객체의 참조값을 기반으로 생성
    Object obj1 = new Object();
    Object obj2 = new Object();
    System.out.println("obj1.hashCode() = " + obj1.hashCode());
    System.out.println("obj2.hashCode() = " + obj2.hashCode());
    System.out.println("obj1 = " + obj1);

    //각 클래스마다 hashCode를 이미 오버라이딩 해두었다.
    Integer i = 10;
    String strA = "A";
    String strAB = "AB";

    System.out.println("10.hashCode() = " + i.hashCode());
    System.out.println("strA.hashCode() = " + strA.hashCode());
    System.out.println("strAB.hashCode() = " + strAB.hashCode());

    //hashCode는 마이너스 값이 들어올 수 있다.
    System.out.println("-1.hashCode() = " + Integer.valueOf(-1).hashCode());

    //둘을 같을까 다를까?, 인스턴스는 다르지만, equals는 같다.
    Member member1 = new Member("idA");
    Member member2 = new Member("idA");

    //equals, hashCode를 오버라이딩 하지 않은 경우와, 한 경우를 비교
    System.out.println("(member1 == member2) = " + (member1 == member2));
    System.out.println("(member1 equals member2) = " + (member1.equals(member2)));
    System.out.println("member1.hashCode() = " + member1.hashCode());
    System.out.println("member2.hashCode() = " + member2.hashCode());

    /*
    @Override
    public int hashCode() {
     int h = hash;  // 👉 맨 처음엔 0 (기본값)
     if (h == 0 && value.length > 0) {
     for (char c : value) {
       h = 31 * h + c;
     }
     hash = h;  // 👉 계산 끝나고 나서야 여기 저장됨
    }
    return h;
   }

    처음에 hash 는 0이고 h를 축적함에 따라 값을 계산함 이것은 String 클래스의 hashCode임

    String 클래스는 멤버 변수에 char[] 배열이 있고 문자열을 하나 하나의 문자로 나눔.

    Object 클래스에 있는 hashCode는 참조값의 hashCode를 구함.

    근데 이걸 오버라이딩하고 안에 hash라는 메서드를 쓰면 내용물의 해시 코드를 구하는거임.

    equals 논리적 동등성을 비교할때 각 클래스 마다 equals 메서드가 있을 텐데
    String 같은 경우에는 문자열을 문자로 쪼개서 확인함.

    각 클래스마다 equals 메서드가 있는데 그러한 메서드들은 "논리적 동등성"을 기반으로 정의함.
    */


  }

}

/*

package collection.set;

import collection.set.member.Member;

public class JavaHashCodeMain {

  public static void main(String[] args) {
    //Object의 기본 hashCode는 객체의 참조값을 기반으로 생성
    Object obj1 = new Object();
    Object obj2 = new Object();
    System.out.println("obj1.hashCode() = " + obj1.hashCode());
    System.out.println("obj2.hashCode() = " + obj2.hashCode());

    //각 클래스마다 hashCode를 이미 오버라이딩 해두었다.
    Integer i = 10;
    String strA = "A";
    String strAB = "AB";
    System.out.println("10.hashCode = " + i.hashCode());
    System.out.println("'A'.hashCode = " + strA.hashCode());
    System.out.println("'AB'.hashCode = " + strAB.hashCode());

    //hashCode는 마이너스 값이 들어올 수 있다.
    System.out.println("-1.hashCode = " + Integer.valueOf(-1).hashCode());

    //둘은 같을까 다를까? , 인스턴스는 다르지만, eqauls는 같다.

  }

}


@Override
public int hashCode() {
  int h = hash;  // 👉 맨 처음엔 0 (기본값)
  if (h == 0 && value.length > 0) {
    for (char c : value) {
      h = 31 * h + c;
    }
    hash = h;  // 👉 계산 끝나고 나서야 여기 저장됨
  }
  return h;
}
처음에 hash 는 0이고 h를 축적함에 따라 값을 계산함 이것은 String 클래스의 hashCode임

String 클래스는 멤버 변수에 char[] 배열이 있고 문자열을 하나 하나의 문자로 나눔.

Object 클래스에 있는 hashCode는 참조값의 hashCode를 구함.

근데 이걸 오버라이딩하고 안에 hash라는 메서드를 쓰면 내용물의 해시 코드를 구하는거임.

System.out.println("member1.hashCode() = " + member1.hashCode());
System.out.println("member2.hashCode() = " + member2.hashCode());

두 개가 같은 이유는? id를 기반으로 한 hashCode를 생성 해주기 때문. hashCode 메서드를 살펴보자.

public static int hashCode(Object[] a) {
        if (a == null)
            return 0;

        int result = 1;

        for (Object element : a)
            result = 31 * result + (element == null ? 0 : element.hashCode());

        return result;
 }

 여기서 element는 Object element = id; id는 String 클래스에 속함.
 id를 기반으로 한 hashCode를 만듬 문자로 쪼개서 ㅇㅇ
 그래서 결과냄.
 */
