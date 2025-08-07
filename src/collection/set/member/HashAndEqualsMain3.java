package collection.set.member;

import collection.set.MyHashSetV2;

public class HashAndEqualsMain3 {

  //중복 등록
  public static void main(String[] args) {
    MyHashSetV2 set = new MyHashSetV2(10);
    Member m1 = new Member("A");
    Member m2 = new Member("A");
    System.out.println("m1.hashCode() = " + m1.hashCode());
    System.out.println("m2.hashCode() = " + m2.hashCode());
    System.out.println("m1.equals(m2) = " + m1.equals(m2));

    set.add(m1);
    set.add(m2);
    System.out.println(set); // 원래 set에는 데이터가 중복으로 들어 갈 수가 없다.

    //검색 성공
    Member searchValue = new Member("A");
    System.out.println("searchValue.hashCode() = " + searchValue.hashCode());
    boolean contains = set.contains(searchValue);
    System.out.println("contains = " + contains);


  }

  /*
  HashCode()와 equals() 메서드가 둘다 있으면 중복을 허용하지 않고 데이터를 넣는다.
   */

}
