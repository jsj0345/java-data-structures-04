package generic.test.ex2;

public class Pair<T1,T2> {
  private T1 value_1;
  private T2 value_2;

  public void setFirst(T1 value) {
    value_1 = value;
  }

  public void setSecond(T2 value) {
    value_2 = value;
  }

  public T1 getFirst() {
    return value_1;
  }

  public T2 getSecond() {
    return value_2;
  }


  @Override
  public String toString() {
    return "Pair{" +
        "first=" + value_1 +
        ", second=" + value_2 +
        '}';
  }
}
