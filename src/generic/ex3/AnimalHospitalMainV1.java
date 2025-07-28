package generic.ex3;

import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalHospitalMainV1 {

  public static void main(String[] args) {
    AnimalHospitalV1 dogHospital = new AnimalHospitalV1();
    AnimalHospitalV1 catHospital = new AnimalHospitalV1();

    Dog dog = new Dog("멍멍이1", 100);
    Cat cat = new Cat("냐옹이1", 300);

    // 개 병원
    dogHospital.set(dog);
    dogHospital.checkUp();

    // 고양이 병원
    catHospital.set(cat);
    catHospital.checkUp();

    // 문제1 : 개 병원에 고양이 전달
    dogHospital.set(cat); // 매개변수 체크 실패 : 컴파일 오류가 발생하지 않음.

    // 문제2 : 개 타입 반환.
    dogHospital.set(dog);
    Dog biggerDog = (Dog) dogHospital.bigger(new Dog("멍멍이2", 200));
    System.out.println("biggerDog = " + biggerDog);
  }

}

/*
package generic.ex3;

import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalHospitalMainV1 {

  public static void main(String[] args) {
    AnimalHospitalV1 dogHospital = new AnimalHospitalV1();
    AnimalHospitalV1 catHospital = new AnimalHospitalV1();

    Dog dog = new Dog("멍멍이1", 100);
    Cat cat = new Cat("냐옹이1", 300);

    // 개 병원
    dogHospital.set(dog);
    dogHospital.checkup();

    // 고양이 병원
    catHospital.set(cat);
    catHospital.checkup();

    // 문제1 : 개 병원에 고양이 전달
    dogHospital.set(cat); // 매개변수 체크 실패:  컴파일 오류가 발생하지 않음.

    // 문제2 : 개 타입 반환, 캐스팅 필요
    dogHospital.set(dog);
    Dog biggerDog = (Dog) dogHospital.getBigger(new Dog("멍멍이2", 200));
    System.out.println("biggerDog = " + biggerDog);
  }

}


코드 재사용O : 다형성을 통해 AnimalHospitalV1 하나로 개와 고양이를 모두 처리한다.

타입 안전성X

- 개 병원에 고양이를 전달하는 문제가 발생한다.
- Animal 타입을 반환하기 때문에 다운 캐스팅을 해야 한다.
- 실수로 고양이를 입력했는데, 개를 반환하는 상황이라면 캐스팅 예외가 발생한다.


 */
