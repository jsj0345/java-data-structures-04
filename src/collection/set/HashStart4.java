package collection.set;

import java.util.Arrays;

public class HashStart4 {

  static final int CAPACITY = 10;

  public static void main(String[] args) {
    //{1, 2, 5, 8, 14, 99}
    System.out.println("hashIndex(1) = " + hashIndex(1));
    System.out.println("hashIndex(2) = " + hashIndex(2));
    System.out.println("hashIndex(5) = " + hashIndex(5));
    System.out.println("hashIndex(8) = " + hashIndex(8));
    System.out.println("hashIndex(14) = " + hashIndex(14));
    System.out.println("hashIndex(99) = " + hashIndex(99));

    Integer[] inputArray = new Integer[CAPACITY];
    add(inputArray, 1);
    add(inputArray, 2);
    add(inputArray, 5);
    add(inputArray, 8);
    add(inputArray, 14);
    add(inputArray, 99);
    System.out.println("inputArray = " + Arrays.toString(inputArray));

    //검색
    int searchValue = 14;
    int hashIndex = hashIndex(searchValue);
    System.out.println("hashIndex = " + hashIndex);
    Integer result = inputArray[hashIndex];
    System.out.println(result);

  }

  private static void add(Integer[] inputArray, int value) {
    int hashIndex = hashIndex(value);
    inputArray[hashIndex] = value;
  }

  static int hashIndex(int value) {
    return value % CAPACITY;
  }
}

/*


앞에서 이야기한 것 처럼 모든 숫자를 입력할 수 있다고 가정하면, 입력값의 범위가 너무 넓어져서 데이터의 값을 인덱스로 사용하기가 어려움.

하지만 입력 값의 범위가 넓어도 해당 범위의 값을 모두 다 입력하는 것은 아님.

앞의 예에서 0 ~ 99 범위의 값 중에 1, 2, 5, 8, 14, 99만 입력했다. 따라서 대부분의 공간은 낭비되었다.

공간도 절약하면서, 넓은 범위의 값을 사용할 수 있는 방법이 있는데, 바로 나머지 연산을 사용하는 것이다.

저장할 수 있는 배열의 크기(CAPACITY)를 10이라고 가정. 그 크기에 맞추어 나머지 연산을 사용하면 된다.

해시 인덱스

이렇게 배열의 인섹드로 사용할 수 있도록 원래의 값을 계산한 인덱스를 해시 인덱스라 한다.

14의 해시 인덱스는 4, 99의 해시 인덱스는 9이다.


 */
