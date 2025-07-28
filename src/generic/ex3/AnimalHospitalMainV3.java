package generic.ex3;

import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalHospitalMainV3 {

  public static void main(String[] args) {
    AnimalHospitalV3<Dog> dogHospital = new AnimalHospitalV3<>();
    AnimalHospitalV3<Cat> catHospital = new AnimalHospitalV3<>();

    Dog dog = new Dog("멍멍이1", 100);
    Cat cat = new Cat("냐옹이1", 300);

    // 개 병원
    dogHospital.set(dog);
    dogHospital.checkUp();

    // 고양이 병원
    catHospital.set(cat);
    catHospital.checkUp();

    // 문제1 : 개 병원에 고양이 전달
    // dogHospital.set(cat); // 다른 타입 입력: 컴파일 오류

    // 문제2 : 개 타입 반환.
    dogHospital.set(dog);
    Dog biggerDog = dogHospital.bigger(new Dog("멍멍이2", 200));
    System.out.println("biggerDog = " + biggerDog);

  }

}

/*
package generic.ex3;

import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalHospitalMainV3 {

  public static void main(String[] args) {
    AnimalHospitalV3<Dog> dogHospital = new AnimalHospitalV3<>();
    AnimalHospitalV3<Cat> catHospital = new AnimalHospitalV3<>();

    Dog dog = new Dog("멍멍이1", 100);
    Cat cat = new Cat("냐옹이1", 300);

    //개 병원
    dogHospital.set(dog);
    dogHospital.checkup();

    //고양이 병원
    catHospital.set(cat);
    catHospital.checkup();

    // 문제1 해결 : 개 병원에 고양이 전달
    // dogHospital.set(cat); // 다른 타입 입력 : 컴파일 오류

    // 문제2 해결 : 개 타입 반환
    dogHospital.set(dog);
    Dog biggerDog = dogHospital.getBigger(new Dog("멍멍이2", 200));
    System.out.println("biggerDog = " + biggerDog);
  }

}


 타입 안전성X 문제
 - 개 병원에 고양이를 전달하는 문제가 발생한다. -> 해결
 - Animal 타입을 반환하기 때문에 다운 캐스팅을 해야 한다. -> 해결
 - 실수로 고양이를 입력했는데, 개를 반환하는 상황이라면 캐스팅 예외가 발생한다. -> 해결

 제네릭 도입 문제
 - 제네릭에서 타입 매개변수를 사용하면 어떤 타입이든 들어올 수 있다. -> 해결
 - 그리고 어떤 타입이든 수용할 수 있는 Object로 가정하고, Object의 기능만 사용할 수 있다. -> 해결



 */