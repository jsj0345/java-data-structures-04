package generic.ex3;

import generic.animal.Animal;

public class AnimalHospitalV3<T extends Animal> {

  private T animal;

  public void set(T animal) {
    this.animal = animal;
  }

  public void checkUp() {
    // T의 타입을 메서드를 정의하는 시점에는 알 수 없다. Object의 기능만 사용.
    System.out.println("동물 이름: " + animal.getName());
    System.out.println("동물 크기: " + animal.getSize());
    animal.sound();
  }

  public T bigger(T target) {
    return animal.getSize() > target.getSize() ? animal : target;
    //return null;
  }

}

/*
package generic.ex3;

import generic.animal.Animal;

public class AnimalHospitalV3<T extends Animal> {

  private T animal;

  public void set(T animal) {
    this.animal = animal;
  }

  public void checkup() {
    System.out.println("동물 이름: " + animal.getName());
    System.out.println("동물 크기: " + animal.getSize());
    animal.sound();
  }

  public T getBigger(T target) {
    return animal.getSize() > target.getSize() ? animal : target;
  }

}

여기서 핵심은 <T extends Animal> 이다.
타입 매개변수 T를 Animal과 그 자식만 받을 수 있도록 제한을 두는 것이다.
즉 T의 상한이 Animal이 되는 것이다.

 */