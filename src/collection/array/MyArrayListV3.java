package collection.array;

import java.util.Arrays;

public class MyArrayListV3 {

  private static final int DEFAULT_CAPACITY = 5;

  private Object[] elementData;
  private int size = 0;

  public MyArrayListV3() {
    elementData = new Object[DEFAULT_CAPACITY];
  }

  public MyArrayListV3(int initialCapacity) {
    elementData = new Object[initialCapacity];
  }

  public int size() {
    return size;
  }

  public void add(Object e) {
    //코드 추가.
    if (size == elementData.length) {
      grow();
    }

    elementData[size] = e;
    size++;
  }

  //코드 추가
  public void add(int index, Object e) {
    //코드 추가.
    if (size == elementData.length) {
      grow();
    }

    //데이터 이동
    shiftRightFrom(index);
    elementData[index] = e;
    size++;
  }

  //코드 추가, 요소의 마지막부터 index까지 오른쪽으로 밀기
  private void shiftRightFrom(int index) {
    for(int i = size; i > index; i--) {
      elementData[i] = elementData[i-1];
    }
  }


  //코드 추가
  private void grow() {
    int oldCapacity = elementData.length;
    int newCapacity = oldCapacity * 2;

    // 배열을 새로 만들고, 기존 배열을 새로운 배열에 복사.

    /*
    Object[] newArr = new Object[newCapacity];
    for (int i = 0; i < elementData.length; i++) {
      newArr[i] = elementData[i];
    }
    */

    elementData = Arrays.copyOf(elementData, newCapacity);

    /*
    Arrays.copyOf(elementData, newCapacity)의 의미는
    elementData의 배열을 복사하고 newCapacity만큼 배열의 길이를 늘리라는 것.
     */



  }

  public Object get(int index) {
    return elementData[index];
  }

  public Object set(int index, Object element) {
    Object oldValue = get(index);
    elementData[index] = element;
    return oldValue;
  }

  //코드 추가
  public Object remove(int index) {
    Object oldValue = get(index);
    shiftLeftFrom(index);
    //데이터 이동
    size--;
    elementData[size] = null;
    return oldValue;

  }

  //코드 추가 요소의 index부터 마지막까지 왼쪽으로 밀기
  private void shiftLeftFrom(int index) {
    for(int i = index; i < size -1; i++) {
      elementData[i] = elementData[i+1];
    }


  }


  public int indexOf(Object o) {
    for(int i = 0; i < size; i++) {
      if(o.equals(elementData[i])) {
        return i;
      }
    }

    return -1;
  }

  public String toString() {
    return Arrays.toString(Arrays.copyOf(elementData, size)) + " size=" + size +
        ", capacity=" + elementData.length;

    //copyOf는 배열에서 size 크기만큼만 copy함.
  }

}

/*
package collection.array;

import java.util.Arrays;

public class MyArrayListV3 {
  private static final int DEFAULT_CAPACITY = 5;

  private Object[] elementData;
  private int size = 0;

  public MyArrayListV3() {
    elementData = new Object[DEFAULT_CAPACITY];
  }

  public MyArrayListV3(int initialCapacity) {
    elementData = new Object[initialCapacity];
  }

  public int size() {
    return size;
  }

  public void add(Object e) {
    if(size == elementData.length) {
      grow();
    }

    elementData[size] = e;
    size++;
  }

  //코드 추가
  public void add(int index, Object e) {
    if (size == elementData.length) {
      grow();
    }

    shiftRightFrom(index);
    elementData[index] = e;
    size++;
  }

  private void grow() {
    int oldCapacity = elementData.length;
    int newCapacity = oldCapacity * 2;
    elementData = Arrays.copyOf(elementData, newCapacity);
  }

  //코드 추가, 요소의 마지막부터 index까지 오른쪽으로 밀기
  private void shiftRightFrom(int index) {
    for(int i = size; i > index; i--) {
      elementData[i] = elementData[i - 1];
    }
  }

  public Object get(int index) {
    return elementData[index];
  }

  public Object set(int index, Object element) {
    Object oldValue = get(index);
    elementData[index] = element;
    return oldValue;
  }

  public Object remove(int index) {
    Object oldValue = get(index);
    shiftLeftFrom(index);

    size--;
    elementData[size] = null;
    return oldValue;

    ["a", "b", "c", "d", "e", "f"] -> size = 6

    ["a","c","d","e","f", null] -> size = 5
    실제로 ArrayLIst remove 메서드는 Array를 출력 할 때 제거 된것 처럼 보이지만
    실제로는 없애진 않고 null로 초기화.
  }

  //코드 추가, 요소의 index부터 마지막까지 왼쪽으로 밀기
  private void shiftLeftFrom(int index) {
    for(int i = index; i < size - 1; i++) {
      elementData[i] = elementData[i + 1];
    }
  }

  public int indexOf(object o) {
    for (int i = 0; i < size; i++) {
      if (o.equals(elementData[i])) {
        return i;
      }
    }

    return -1;
  }

  @Override
  public String toString() {
    return Arrays.toString(Arrays.copyOf(elementData, size)) + " size="
      + size + ", capacity=" + elementData.length;
  }

}


["a", "b", "c", "d", "e"]

이 배열에서 인덱스 1번에 데이터를 추가한다고 가정.

["a","푸들","b","c","d","e"]

private static void shiftRightFrom(int index) {
  for(int i = size; i > index; i--) {
    elementData[i] = elementData[i - 1];
  }
}

["a","푸들","b","c","d","e"]

인덱스 3번을 제거한다고 가정.

private static void shiftLeftFrom(int index) {
  for(int i = index; i < size - 1; i++) {
    elementData[i] = elementData[i + 1];
  }
}





 */


