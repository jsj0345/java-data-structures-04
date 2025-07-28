package collection.set;

import java.util.Arrays;

public class HashStart2 {

  public static void main(String[] args) {
    //입력: 1, 2, 5, 8
    //[null, 1, 2, null, null, 5, null, null, 8, null]
    Integer[] inputArray = new Integer[10];
    inputArray[1] = 1;
    inputArray[2] = 2;
    inputArray[5] = 5;
    inputArray[8] = 8;

    System.out.println("inputArray = " + Arrays.toString(inputArray));

    int searchValue = 8;
    Integer result = inputArray[searchValue]; // O(1)
    System.out.println("result = " + result);
  }
}

/*
package collection.set;

import java.util.Arrays;

public class HashStart2 {

  public static void main(String[] args) {
    //입력: 1, 2, 5, 8
    //[null, 1, 2, null, null, 5, null, null, 8, null]
    Integer[] inputArray = new Integer[10];
    inputArray[1] = 1;
    inputArray[2] = 2;
    inputArray[5] = 5;
    inputArray[8] = 8;
    System.out.println("inputArray = " + Arrays.toString(inputArray));

    int searchValue = 8;
    Integer result = inputArray[searchValue]; // O(1)
    System.out.println(result);
  }

}


데이터의 값 자체를 배열의 인덱스로 사용했다. 배열에서 인덱스로 데이터를 찾는 것은 매우 빠르다.

그 덕분에 O(n)의 검색 성능을 O(1)로 획기적으로 개선할 수 있었다.

문제점 : 입력 값의 범위 만큼 큰 배열을 사용해야 한다. 따라서 배열에 낭비되는 공간이 많이 발생함.




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

valueOf()메서드로 인해서 String으로 변함.

 */