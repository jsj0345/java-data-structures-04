package collection.set.member;

import collection.set.MyHashSetV2;

public class HashAndEqualsMain2 {

  //중복 등록
  public static void main(String[] args) {
    MyHashSetV2 set = new MyHashSetV2(10);
    MemberOnlyHash m1 = new MemberOnlyHash("A");
    MemberOnlyHash m2 = new MemberOnlyHash("A");
    System.out.println("m1.hashCode() = " + m1.hashCode());
    System.out.println("m2.hashCode() = " + m2.hashCode());
    System.out.println("m1.equals(m2) = " + m1.equals(m2));

    set.add(m1);
    set.add(m2);
    System.out.println(set); // 원래 set에는 데이터가 중복으로 들어 갈 수가 없다.

    //검색 실패
    MemberOnlyHash searchValue = new MemberOnlyHash("A");
    System.out.println("searchValue.hashCode() = " + searchValue.hashCode());
    boolean contains = set.contains(searchValue);
    System.out.println("contains = " + contains);


  }

}
