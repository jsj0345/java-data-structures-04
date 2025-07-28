package generic.test.ex1;

import java.util.Objects;

public class Container<T> {
  private T item;


  public boolean isEmpty() {
    if(item == null) {
      return true;
    } else {
      return false;
    }

  }

  public void setItem(T value) {
    item = value;
  }

  public T getItem() {
    return item;
  }


}
