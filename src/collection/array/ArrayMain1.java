package collection.array;

import java.util.Arrays;

public class ArrayMain1 {

  public static void main(String[] args) {
    int[] arr = new int[5];
    // index 입력: 0(1)
    System.out.println("==index 입력: 0(1)==");
    arr[0] = 1;
    arr[1] = 2;
    arr[2] = 3;
    // System.out.println(arr); // 참조값이 나옴.
    System.out.println(Arrays.toString(arr));

    //index 변경: 0(1)
    System.out.println("==index 변경: 0(1)==");
    arr[2] = 10;
    System.out.println(Arrays.toString(arr));

    /*
    예를 들어서, System.out.println(abcd); 가 있다고 가정하자.
    아걸 문자열로 처리하고싶으면 abcd를 마우스로 클릭한다음에 "를 눌러보자.
    그럼 "abcd"로 바뀐다.
     */

    System.out.println("==index 조회: 0(1)==");
    System.out.println("arr[2] = " + arr[2]);

    System.out.println("==배열 검색: 0(n)==");
    System.out.println(Arrays.toString(arr));
    int value = 10;

    for(int i = 0; i< arr.length; i++) {
      System.out.println("arr["+i+"]: " + arr[i] );
      if(arr[i] == value) {
        System.out.println(value + " 찾음");
        break;
      }
    }


  }
}

/*
package collection.array;

import java.util.Arrays;

public class ArrayMain1 {

  public static void main(String[] args) {
    int[] arr = new int[5];

    System.out.println("==index 입력: 0(1)==");
    arr[0] = 1;
    arr[1] = 2;
    arr[2] = 3;
    System.out.println(Arrays.toString(arr));

    //index 변경: 0(1)
    System.out.println("==index 변경: 0(1)==");
    arr[2] = 10;
    System.out.println(Arrays.toString(arr));

    //index 조회: 0(1)
    System.out.println("==index 조회: 0(1)==");
    System.out.println("arr[2] = " + arr[2]);

    //검색: 0(n)
    System.out.println("==배열 검색: 0(n)==");
    System.out.println(Arrays.toString(arr));
    int value = 10;
    for (int i = 0; i < arr.length; i++) {
      System.out.println("arr[" + i + "]:" + arr[i]);
      if(arr[i] == value) {
        System.out.println(value + " 찾음");
        break;
      }
    }
  }
}

일단 이 코드에서 봐야 할 건 index를 찾는 것은 연산이 복잡하지 않다.

그런데 인덱스에 있는 데이터를 찾으려면 시간이 오래 걸린 다는 것을 알 수 있음.

배열의 특징
- 배열에서 자료를 찾을 때 인덱스(index)를 사용하면 매우 빠르게 자료를 찾을 수 있다.
- 인덱스를 통한 입력,변경,조회의 경우 한번의 계산으로 자료의 위치를 찾을 수 있다.

배열의 경우 인덱스를 사용하면 한번의 계산으로 매우 효율적으로 자료의 위치를 찾을 수 있다.
인덱스를 통한 입력, 변경, 조회 모두 한번의 계산으로 필요한 위치를 찾아서 처리할 수 있다.
정리하면 배열에서 인덱스를 사용하는 경우 데이터가 아무리 많아도 한번의 연산으로 필요한 위치를 찾을 수 있다.

배열의 검색

배열에 들어있는 데이터를 찾는 것을 검색이라 한다.
배열에 들어있는 데이터를 검색할 때는 배열에 들어있는 데이터를 하나하나 비교해야 한다.
이때는 이전과 같이 인덱스를 사용해서 한번에 찾을 수 없다.
대신에 배열안에 들어있는 데이터를 하나하나 확인해야 한다.
따라서 평균적으로 볼때 배열의 크기가 클 수록 오랜 시간이 걸린다.

배열의 데이터 추가

배열의 특정 위치에 데이터를 추가해보자.
추가는 기존 데이터를 유지하면서 새로운 데이터를 입혁하는 것을 뜻한다.
참고로 데이터를 중간에 추가하면 기존 데이터가 오른쪽으로 한 칸씩 이동해야 한다.
이 말을 좀 더 쉽게 풀어보자면 데이터를 추가하려면 새로운 데이터를 입력할 공간을 확보해야 한다.
따라서 기존 데이터를 오른쪽으로 한 칸씩 밀어야 한다.


 */
