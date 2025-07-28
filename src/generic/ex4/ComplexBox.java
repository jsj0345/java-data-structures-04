package generic.ex4;

import generic.animal.Animal;

public class ComplexBox<T extends Animal> {

  private T animal;

  public void set(T animal) {
    this.animal = animal;
  }

  public <Z> Z printAndReturn(Z z) {
    System.out.println("animal.className: " + animal.getClass().getName());
    System.out.println("z.className: " + z.getClass().getName());
    return z;
  }

}

/*
package generic.ex4;

import generic.animal.Animal;

public class ComplexBox<T extends Animal> {

  private T animal;

  public void set(T animal) {
    this.animal = animal;
  }

  public <Z> Z printAndReturn(Z z) {
    System.out.println("animal.className: " + animal.getClass().getName());
    System.out.println("z.className: " + z.getClass().getName());
    return z;
  }

  만약에 public <T> T printAndReturn(T t)로 바꿨다고 가정을 해보자.
  이때 제네릭 클래스는 T 타입으로 되어있는데 이것은 메서드까지 범위를 갖지않음.
  메서드는 호출 할때 , 타입이 결정됨.
}
 */
