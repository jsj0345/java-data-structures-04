package generic.animal;

public class Dog extends Animal {

  public Dog(String name, int size) {
    super(name, size);
  }

  @Override
  public void sound() { // ctrl+o를 하면 오버라이딩 가능.
    System.out.println("멍멍");
  }
}

/*
package generic.animal;

public class Dog extends Animal {

  public Dog(String name, int size) {
    super(name,size);
  }

  @Override
  public void sound() {
    System.out.println("멍멍");
  }

}
 */