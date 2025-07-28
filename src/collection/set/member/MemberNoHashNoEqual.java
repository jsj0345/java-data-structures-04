package collection.set.member;

public class MemberNoHashNoEqual {

  private String id;

  public MemberNoHashNoEqual(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  @Override
  public String toString() {
    return "MemberNoHashNoEqual{" +
        "id='" + id + '\'' +
        '}';
  }


}
