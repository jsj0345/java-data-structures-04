package collection.set;

import java.util.Arrays;

public class HashStart3 {

  public static void main(String[] args) {
    //입력: {1, 2, 5, 8, 14, 99}
    //[null, 1, 2, null, null, 5, null, null, 8, null, ..., 14, ..., 99]
    Integer[] inputArray = new Integer[100];
    inputArray[1] = 1;
    inputArray[2] = 2;
    inputArray[5] = 5;
    inputArray[8] = 8;
    inputArray[14] = 14;
    inputArray[99] = 99;

    System.out.println("inputArray = " + Arrays.toString(inputArray));
    
    int searchValue = 99;
    Integer result = inputArray[searchValue]; // O(1)
    System.out.println("result = " + result);
  }
}

/*
package collection.set;

import java.util.Arrays;

public class HashStart3 {

  public static void main(String[] args) {
    //{1, 2, 5, 8, 14, 99}
    //[null, 1, 2, null, null, 5, null, null, 8, .., 14 ....., 99]
    Integer[] inputArray = new Integer[100];
    inputArray[1] = 1;
    inputArray[2] = 2;
    inputArray[5] = 5;
    inputArray[8] = 8;
    inputArray[14] = 14;
    inputArray[99] = 99;
    System.out.println("inputArray = " + Arrays.toString(inputArray));

    int searchValue = 99;
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

한계

데이터의 값을 인덱스로 사용한 덕분에 O(1)의 매우 빠른 검색 속도를 얻을 수 있다.

그리고 이 코드는 정상적으로 수행된다. 하지만 낭비되는 메모리 공간이 너무 많다.



 */