package generic.ex3;

import generic.animal.Cat;

public class CatHospital {
  private Cat animal;

  public void set(Cat animal) {
    this.animal = animal;
  }

  public void checkUp() {
    System.out.println("동물 이름: " + animal.getName());
    System.out.println("동물 크기: " + animal.getSize());
    animal.sound();
  }

  public Cat bigger(Cat target) {
    return animal.getSize() > target.getSize() ? animal : target;
  }
}

/*
package generic.ex3;

import generic.animal.Cat;

public class CatHospital {

  private Cat animal;

  public void set(Cat animal) {
    this.animal = animal;
  }

  public void checkup() {
    System.out.println("동물 이름: " + animal.getName());
    System.out.println("동물 크기: " + animal.getSize());
    animal.sound();
  }

  public Cat getBigger(Cat target) {
    return animal.getSize() > target.getSize() ? animal : target;
  }

}

코드 재사용X : 개 병원과 고양이 병원은 중복이 많아 보인다.
타입 안전성O : 타입 안전성이 명확하게 지켜진다.
 */