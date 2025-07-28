package generic.ex3;

public class AnimalHospitalV2<T> {

  private T animal;

  public void set(T animal) {
    this.animal = animal;
  }

  public void checkUp() {
    // T의 타입을 메서드를 정의하는 시점에는 알 수 없다. Object의 기능만 사용.
    //System.out.println("동물 이름: " + animal.getName());
    //System.out.println("동물 크기: " + animal.getSize());
    //animal.sound();
  }

  public T bigger(T target) {
    // 컴파일 오류
    //return animal.getSize() > target.getSize() ? animal : target;
    return null;
  }

}

/*
package generic.ex3;

public class AnimalHospitalV2<T> {

  private T animal;

  public void set(T animal) {
    this.animal = animal;
  }

  public void checkup() {
    // T의 타입을 메서드를 정의하는 시점에는 알 수 없다.
    animal.toString();
    animal.equals(null);

    // 컴파일 오류
    // System.out.println("동물 이름: " + animal.getName());
    // animal.sound();
  }

  public T getBigger(T target) {
    // 컴파일 오류
    // return animal.getSize() > target.getSize() ? animal : target;
    return null;
  }

}

제네릭 타입을 선언하면 자바 컴파일러 입장에서 T에 어떤 값이 들어올지 예측할 수 없다.
우리는 Animal 타입의 자식이 들어오기를 기대했지만, 여기 코드 어디에도 Animal에 대한 정보는 없다.
T에는 타입 인자로 Integer가 들어올 수도 있고, Dog가 들어올 수도 있다.
물론 Object가 들어올 수도 있다.


 */


