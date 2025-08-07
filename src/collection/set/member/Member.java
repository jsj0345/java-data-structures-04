package collection.set.member;

import java.util.Objects;

public class Member {

  private String id;

  public Member(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Member member = (Member) o;
    return Objects.equals(id, member.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "Member{" +
        "id='" + id + '\'' +
        '}';
  }

  /*
  같은 데이터가 들어 온다하면 중복을 허용하지 않고 정 위치에 들어갈 수 있도록
  HashCode(), equals() 메서드를 오버라이딩 해야 한다.
   */
}

/*
package collection.set.member;

import java.util.Objects;

public class Member {

  private String id;

  public Member(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Member member = (Member) o;
    return Objects.equals(id, member.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id); // hashCode를 구하는 함수.
  }

  @Override
  public String toString() {
    return "Member{" +
            "id='" + id + '\'' +
            '}';
  }

}


 */
