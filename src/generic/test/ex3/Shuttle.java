package generic.test.ex3;

import generic.test.ex3.unit.BioUnit;

public class Shuttle<T extends BioUnit> {

  private T info1;

  public void showInfo() {
    System.out.println("이름: " + info1.getName() + ", HP: " + info1.getHp());
  }

  public void in(T t) {
     this.info1 = t;
  }
}

/*
public class Box<T> {
  ...

  public void abc(Box<? extends Animal> a) {
   a.get()
 */