package generic.animal;

public class Cat extends Animal {

  public Cat(String name, int size) {
    super(name, size);
  }

  @Override
  public void sound() {
    System.out.println("야옹");
  }

  public void sound_1() {
    System.out.println("야옹2");
  }
}

/*
package generic.animal;

public class Cat extends Animal {

  public Cat(String name, int size) {
    super(name,size);
  }

  @Override
  public void sound() {
    System.out.println("야옹");
  }

  public void sound_1() {
    System.out.println("야옹2");
  }

}
 */