package collection.set;

import collection.set.member.Member;

public class MyHashSetV2Main2 {

  public static void main(String[] args) {
    MyHashSetV2 set = new MyHashSetV2(10);
    Member hi = new Member("hi");
    Member jpa = new Member("JPA"); // 대문자 주의!
    Member java = new Member("java");
    Member spring = new Member("spring");

    System.out.println("hi.hashCode() = " + hi.hashCode());
    System.out.println("jpa.hashCode() = " + jpa.hashCode());
    System.out.println("java.hashCode() = " + java.hashCode());
    System.out.println("spring.hashCode() = " + spring.hashCode());

    set.add(hi);
    set.add(jpa);
    set.add(java);
    set.add(spring);
    System.out.println(set);

    //검색
    Member searchValue = new Member("JPA");
    boolean result = set.contains(searchValue);
    System.out.println("set.contains(" + searchValue + ") " + result);

  }
}

/*
hash 메서드와 hashCode 메서드의 차이점을 알아보자.

hash 메서드 같은경우에는 Object형 배열을 받은 후에..

각 요소에 있는 형태별 hashCode 메서드를 오버라이딩해서 해시 코드를 계산함.

반면 hashCode 메서드는 객체의 참조값을 해시코드로 반환함.

즉 참조값으로 코드를 반환하느냐 내용물로 해시코드를 반환하느냐의 차이.
 */
