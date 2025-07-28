package generic.ex1;

public class GenericBox<T> {

  private T value;

  public void set(T value) {
    this.value = value;
  }

  public T get() {
    return value;
  }


}

/*
package generic.ex1;

public class GenericBox<T> {

  private T value;

  public void set(T value) {
    this.value = value;
  }

  public T get() {
    return value;
  }

}



<>를 사용한 클래스를 제네릭 클래스라한다. (<>)를 다이아몬드라고 부른다.

T를 타입 매개변수라 부름.

이 타입 매개변수는 이후에 Integer, String으로 변할 수 있다.
 */