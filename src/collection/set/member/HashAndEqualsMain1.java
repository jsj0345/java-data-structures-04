package collection.set.member;

import collection.set.MyHashSetV2;

public class HashAndEqualsMain1 {

  //중복 등록
  public static void main(String[] args) {
    MyHashSetV2 set = new MyHashSetV2(10);
    MemberNoHashNoEqual m1 = new MemberNoHashNoEqual("A");
    MemberNoHashNoEqual m2 = new MemberNoHashNoEqual("A");
    System.out.println("m1.hashCode() = " + m1.hashCode());
    System.out.println("m2.hashCode() = " + m2.hashCode());
    System.out.println("m1.equals(m2) = " + m1.equals(m2));

    set.add(m1);
    set.add(m2);
    System.out.println(set); // 원래 set에는 데이터가 중복으로 들어 갈 수가 없다.

    //검색 실패
    MemberNoHashNoEqual searchValue = new MemberNoHashNoEqual("A");
    System.out.println("searchValue.hashCode() = " + searchValue.hashCode());
    boolean contains = set.contains(searchValue);
    System.out.println("contains = " + contains);


    /*
    위 코드처럼 equals(), HashCode() 메서드가 없으면
    id가 같다고 해도 다른 곳으로 데이터가 들어가서 중복을 허용 하게 된다.
     */

  }

}
