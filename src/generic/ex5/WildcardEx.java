package generic.ex5;

import generic.animal.Animal;

public class WildcardEx {

  static <T> void printGenericV1(Box<T> box) {
    System.out.println("T = " + box.get());
  }

  //Box<Dog>, Box<Cat>, Box<Object>
  static void printWildcardV1(Box<?> box) {
    System.out.println("? = " + box.get());
  }

  static <T extends Animal> void printGenericV2(Box<T> box) {
    T t = box.get();
    System.out.println("이름 = " + t.getName());
  }

  static void printWildcardV2(Box<? extends Animal> box) {
    Animal animal = box.get(); // 다형성
    System.out.println("이름 = " + animal.getName());
  }

  static <T extends Animal> T printAndReturnGeneric(Box<T> box) {
    T t = box.get();
    System.out.println("이름 = " + t.getName());
    return t;
  }

  static Animal printAndReturnWildcard(Box<? extends Animal> box) {
    Animal animal = box.get();
    System.out.println("이름 = " + animal.getName());
    return animal;
  }
}

/*
package generic.ex5;

import generic.animal.Animal;

public class WildcardEx {

  static <T> void printGenericV1(Box<T> box) {
    System.out.println("T = " + box.get());
  }

  static void printWildcardV1(Box<?> box) {
    System.out.println("? = " + box.get());
  }

  static <T extends Animal> void printGenericV2(Box<T> box) {
    T t = box.get();
    System.out.println("이름 = " + t.getName());
  }

  static void printWildcardV2(Box<? extends Animal> box) {
    Animal animal = box.get();
    System.out.println("이름 = " + animal.getName());
  }

  static <T extends Animal> T printAndReturnGeneric(Box<T> box) {
    T t = box.get();
    System.out.println("이름 = " + t.getName());
    return t;
  }

  static Animal printAndReturnWildcard(Box<? extends Animal> box) {
    Animal animal = box.get();
    System.out.println("이름 = " + animal.getName());
    return animal;
  }

}



와일드 카드는 이미 만들어진 제네릭 타입을 편하게 쓸 때 이용한다.

와일드 카드는 타입 매개변수에만 쓸 수 있음. 리턴 타입엔 못 씀.
 */
