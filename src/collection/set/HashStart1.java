package collection.set;

import java.util.Arrays;

public class HashStart1 {

  public static void main(String[] args) {
    Integer[] inputArray = new Integer[4];
    inputArray[0] = 1;
    inputArray[1] = 2;
    inputArray[2] = 5;
    inputArray[3] = 8;
    System.out.println("inputArray = " + Arrays.toString(inputArray));

    int searchValue = 8;
    //4번 반복 O(n)
    for (Integer inputValue : inputArray) {
      if (inputValue == searchValue) {
        System.out.println(inputValue);
      }
    }

  }
}

/*
package collection.set;

import java.util.Arrays;

public class HashStart1 {

  public static void main(String[] args) {
    Integer[] inputArray = new Integer[4];
    inputArray[0] = 1;
    inputArray[1] = 2;
    inputArray[2] = 5;
    inputArray[3] = 8;

    System.out.println("inputArray = " + Arrays.toString(inputArray));

    int searchValue = 8;

    //4번 반복 O(n)
    for (int inputValue : inputArray) {
      if (inputValue == searchValue) {
        System.out.println(inputValue);
      }
    }
  }
 }



Arrays.toString(inputArray) 에서 왜 [1, 2, 5, 8]로 나올까?

이유는 간단하다. toString 메서드를 살펴보자.

 public static String toString(Object[] a) {
        if (a == null)
            return "null";

        int iMax = a.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(String.valueOf(a[i]));
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
}

valueOf()메서드에 의해서 String으로 변함

 */