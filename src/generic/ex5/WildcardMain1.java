package generic.ex5;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class WildcardMain1 {
  public static void main(String[] args) {
    Box<Object> objBox = new Box<>();
    Box<Dog> dogBox = new Box<>();
    Box<Cat> catBox = new Box<>();

    dogBox.set(new Dog("멍멍이", 100));

    WildcardEx.printGenericV1(dogBox);
    WildcardEx.printWildcardV1(dogBox);

    WildcardEx.printGenericV2(dogBox);
    WildcardEx.printWildcardV2(dogBox);

    WildcardEx.printAndReturnGeneric(dogBox);
    Animal animal = WildcardEx.printAndReturnWildcard(dogBox);

  }
}

/*
package generic.ex5;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class WildcardMain1 {

  public static void main(String[] args) {
    Box<Object> objBox = new Box<>();
    Box<Dog> dogBox = new Box<>();
    Box<Cat> catBox = new Box<>();
    dogBox.set(new Dog("멍멍이", 100));

    WildcardEx.printGenericV1(dogBox); // T =  Animal{Name = ... , size = ...}
    WildcardEx.printWildcardV1(dogBox); // ? =  Animal{Name = ...., size = ...}

    WildcardEx.printGenericV2(dogBox); // 이름 = 멍멍이
    WildcardEx.printWildcardV2(dogBox); // 이름 = 멍멍이

    WildcardEx.printAndReturnGeneric(dogBox); // 이름 = 멍멍이
    Animal animal = WildcardEx.printAndReturnWildcard(dogBox); // 이름 = 멍멍이
  }

}

 */
