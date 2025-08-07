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

  /*
  HashCode() 메서드만 있는 경우에는 이제 다른 위치로 데이터가 들어가진 않는다.
  다만, equals() 메서드가 없으므로 같은 데이터여도
  다른 데이터로 취급해서 문제가 발생한다. (즉, 중복을 허용한다는 것)
   */
}
