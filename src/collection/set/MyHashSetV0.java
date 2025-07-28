package collection.set;

import java.util.Arrays;

public class MyHashSetV0 {

  private int[] elementData = new int[10];
  private int size = 0;

  // O(n)
  public boolean add(int value) {

    if (contains(value)) {
      return false;
    }

    elementData[size] = value;
    size++;
    return true;
  }

  // O(n)
  public boolean contains(int value) {
    for (int data : elementData) {
      if (data == value) {
        return true;
      }
    }

    return false;
  }

  public int size() {
    return size;
  }

  @Override
  public String toString() {
    return "MyHashSetV0{" +
        "elementData=" + Arrays.toString(Arrays.copyOf(elementData, size)) +
        ", size=" + size +
        '}';
  }
}

/*
package collection.set;

import java.util.Arrays;

public class MyHashSetV0 {

  private int[] elementData = new int[10];
  private int size = 0;

  // O(n)
  public boolean add(int value) {
    if (contains(value)) {
      return false;
    }
    elementData[size] = value;
    size++;
    return true;
  }

  // O(n)
  public boolean contains(int value) {
    for (int data : elementData) {
      if (data == value) {
        return true;
      }
    }
    return false;
  }

  public int getSize() {
    return size;
  }

  @Override
  public String toString() {
    return "MyHashSetV0{" +
            "elementData=" + Arrays.toString(Arrays.copyOf(elementData, size)) + ", size=" + size +
            +'}';
  }



 }






리스트는 요소들의 순차적인 컬렉션이다. 요소들은 특정 순서를 가지며, 같은 요소가 여러번 나타 날 수 있다.

순서 유지: 리스트에 추가된 요소는 특정한 순서를 유지한다. 이 순서는 요소가 추가된 순서를 반영할 수 있다.

중복 허용: 리스트는 동일한 값이나 객체의 중복을 허용한다. 예를 들어, 같은 숫자나 문자열을 리스트 안에 여러번
저장할 수 있다.

인덱스 접근: 리스트의 각 요소는 인덱스를 통해 접근할 수 있다. 이 인덱스는 보통 0부터 시작한다.

Set(세트, 셋)
정의: 세트(셋)는 유일한 요소들의 컬렉션이다. 참고로 세트보다는 셋으로 많이 불린다.

특징

유일성: 셋에는 중복된 요소가 존재하지 않는다. 셋에 요소를 추가할 때, 이미 존재하는 요소면 무시된다.

순서 미보장: 대부분의 셋 구현에서는 요소들의 순서를 보장하지 않는다. 즉, 요소를 출력할 때 입력 순서와 다를 수 있다.

빠른 검색: 셋은 요소의 유무를 빠르게 확인할 수 있도록 최적화되어 있다. 이는 데이터의 중복을 방지하고 빠른 조회를 가능하게 한다.

용도: 중복을 허용하지 않고, 요소의 유무만 중요한 경우에 사용된다.

List: 장바구니 목록, 순서가 중요한 일련의 이벤트 목록.
Set: 회원 ID 집합, 고유한 항목의 집합.


 */