package collection.array;

import java.util.Arrays;

public class MyArrayListV2 {

  private static final int DEFAULT_CAPACITY = 5;

  private Object[] elementData;
  private int size = 0;

  public MyArrayListV2() {
    elementData = new Object[DEFAULT_CAPACITY];
  }

  public MyArrayListV2(int initialCapacity) {
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
  private void grow() {
    int newCapacity = elementData.length * 2;

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

public class MyArrayListV2 {

  private static final int DEFAULT_CAPACITY = 5;

  private Object[] elementData;
  private int size = 0;

  public MyArrayListV2() {
    elementData = new Object[DEFAULT_CAPACITY];
  }

  public MyArrayListV2(int initialCapacity) {
    elementData = new Object[initialCapacity];
  }

  public int size() {
    return size;
  }

  public void add(Object e) {
    //코드 추가
    if (size == elementData.length) {
      grow();
    }

    elementData[size] = e;
    size++;
  }

  //코드 추가
  private void grow() {
    int oldCapacity = elementData.length;
    int newCapacity = oldCapacity * 2;
    elementData = Arrays.copyOf(elementData, newCapacity);
  }

  public Object get(int index) {
    return elementData[index];
  }

  public Object set(int index, Object element) {
    Object oldValue = get(index);
    elementData[index] = element;
    return oldValue;
  }

  @Override
  public String toString() {
    return Arrays.toString(Arrays.copyOf(elementData, size)) + " size=" + size
      +", capacity=" + elementData.length;
  }

}


grow()를 호출할 때 배열의 크기는 기존과 비교해서 2배씩 증가한다.

2 -> 4 -> 8 -> 16 -> 32 -> 64 -> 128

데이터가 하나 추가될 때 마다 배열이 크기를 1씩만 증가하게 되면 배열을 복사하는 연산이
너무 자주 발생할 가능성이 높다.

배열을 새로 복사해서 만드는 연산은 배열을 새로 만들고 또 기존 데이터를 복사하는 시간이 걸리므로
가능한 줄이는 것이 좋다. 이렇게 2배씩 증가하면 배열을 새로 만들고 복사하는 연산을 줄일 수 있다.
반면에 배열의 크기를 너무 증가하면 사용되지 않고 낭비되는 메모리가 많아지는 단점이 발생할 수 있다.

참고로 예제를 단순화 하기 위해 여기서는 2배씩 증가했지만, 보통 50% 정도 증가하는 방법을 사용한다.







 */