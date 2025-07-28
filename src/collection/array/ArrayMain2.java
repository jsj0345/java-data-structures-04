package collection.array;

import java.util.Arrays;

public class ArrayMain2 {

  public static void main(String[] args) {
    int[] arr = new int[5];
    arr[0] = 1;
    arr[1] = 2;
    System.out.println(Arrays.toString(arr)); // [1,2,0,0,0]

    //배열의 첫번째 위치에 추가.
    //기본 배열의 데이터를 한 칸씩 뒤로 밀고 배열의 첫번째 위치에 추가.
    System.out.println("배열의 첫번째 위치에 3 추가 0(n)");
    int newValue = 3;
    addFirst(arr, newValue);
    System.out.println(Arrays.toString(arr)); // [3,1,2,0,0]

    //index 위치에 추가.
    //기본 배열의 데이터를 한 칸씩 뒤로 밀고 배열의 index 위치에 추가.
    System.out.println("배열의 index(2) 위치에 4 추가 0(n)");
    int index = 2;
    int value = 4;
    addAtIndex(arr, index, value);
    System.out.println(Arrays.toString(arr)); // [3,1,4,2,0]

    System.out.println("배열의 마지막 위치에 5 추가 0(1)");
    addLast(arr,5);
    System.out.println(Arrays.toString(arr)); // [3,1,4,2,5]
  }

  private static void addLast(int[] arr, int newValue) {
    arr[arr.length - 1] = newValue;
  }

  private static void addAtIndex(int[] arr, int index, int value) {
    for(int i = arr.length -1; i > index; i--) {
      arr[i] = arr[i - 1];
    }
    arr[index] = value;
  }

  private static void addFirst(int[] arr, int newValue) {
    for(int i = arr.length -1; i > 0; i--) {
      arr[i] = arr[i - 1];
    }
    arr[0] = newValue;
  }

}

/*
package collection.array;

import java.util.Arrays;

public class ArrayMain2 {

  public static void main(String[] args) {
    int[] arr = new int[5];
    arr[0] = 1;
    arr[1] = 2;
    System.out.println(Arrays.toString(arr));

    //배열의 첫번째 위치에 추가
    //기본 배열의 데이터를 한 칸씩 뒤로 밀고 배열의 첫번째 위치에 추가
    System.out.println("배열의 첫번째 위치에 3 추가 O(n)");
    int newValue = 3;
    addFirst(arr, newValue);
    System.out.println(Arrays.toString(arr));

    //index 위치에 추가
    //기본 배열의 데이터를 한 칸씩 뒤로 밀고 배열의 index 위치에 추가
    System.out.println("배열의 index(2) 위치에 4 추가 0(n)");
    int index = 2;
    int value = 4;
    addAtIndex(arr, index, value);
    System.out.println(Arrays.toString(arr));

    System.out.println("배열의 마지막 위치에 5 추가 0(1)");
    addLast(arr, 5);
    System.out.println(Arrays.toString(arr));

    private static void addFirst(int[] arr, int newValue) {
      for(int i = arr.length -1; i > 0; i--) {
        arr[i] = arr[i - 1];
      }
      arr[0] = newValue;
    }

    private static void addLast(int[] arr, int newValue) {
      arr[arr.length - 1] = newValue;
    }

    private static void addAtIndex(int[] arr, int index, int value) {
      for(int i = arr.length - 1; i > index; i--) {
        arr[i] = arr[i - 1];
      }

      arr[index] = value;
    }


}

배열의 한계

배열의 가장 기본적인 자료 구조이고, 특히 인덱스를 사용할 때 최고의 효율이 나온다.
하지만 이런 배열에는 큰 단점이 있다.
바로 배열의 크기를 배열을 생성하는 시점에 미리 정해야 한다는 점이다.

배열처럼 처음부터 정적으로 길이가 정해져있는 것이 아니라, 동적으로 언제든지 길이를
늘리고 줄일 수 있는 자료 구조가 있다면 편리할 것이다.

배열의 경우 두가지 불편함이 있다.

- 배열의 길이를 동적으로 변경할 수 없다.
- 데이터를 추가하기 불편하다.

배열의 이런 붎편함을 해소하고 동적으로 데이터를 추가할 수 있는 자료 구조를 List(리스트)라 한다.

List 자료 구조
-순서가 있고, 중복을 허용하는 자료 구조를 리스트라 한다.

배열: 순서가 있고 중복을 허용하지만 크기가 정적으로 고정된다.
리스트: 순서가 있고 중복을 허용하지만 크기가 동적으로 변할 수 있다.


 */
