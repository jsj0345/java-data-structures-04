package collection.list;

import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {

  private static final int DEFAULT_CAPACITY = 5;

  private Object[] elementData;
  private int size = 0;

  public MyArrayList() {
    elementData = new Object[DEFAULT_CAPACITY];
    /*
    자바 생성자엔 제네릭을 쓸 수가 없음.

    왜 그럴까?

    답은 단순하다. 클래스 제네릭 타입과 생성자 제네릭 타입이 서로 다를 수도 있어서 혼동을 방지하기 위함.
     */
  }

  public MyArrayList(int initialCapacity) {
    elementData = new Object[initialCapacity];
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public void add(E e) {
    //코드 추가.
    if (size == elementData.length) {
      grow();
    }

    elementData[size] = e;
    size++;
  }

  //코드 추가
  @Override
  public void add(int index, E e) {
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
    for(int i = size ; i > index; i--) {
      elementData[i] = elementData[i-1];
    }
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

  @SuppressWarnings("unchecked")
  @Override
  public E get(int index) {
    return (E) elementData[index];
  }

  @Override
  public E set(int index, E element) {
    E oldValue = get(index);
    elementData[index] = element;
    return oldValue;
  }

  //코드 추가
  @Override
  public E remove(int index) {
    E oldValue = get(index);
    shiftLeftFrom(index);
    //데이터 이동
    size--;
    elementData[index] = null;
    return oldValue;

  }

  //코드 추가 요소의 index부터 마지막까지 왼쪽으로 밀기
  private void shiftLeftFrom(int index) {
    for(int i = index; i < size -1  ; i++) {
      elementData[i] = elementData[i + 1];
    }


  }


  @Override
  public int indexOf(E o) {
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
package collection.list;

import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {

  private static final int DEFAULT_CAPACITY = 5;

  private Object[] elementData;

  private int size = 0;

  public MyArrayList() {
    elementData = new Object[DEFAULT_CAPACITY];
  }

  public MyArrayList(int initialCapacity) {
    elementData = new Object[initialCapacity];
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public void add(E e) {
    if (size == elementData.length) {
      grow();
    }

    elementData[size] = e;
    size++;
  }

  @Override
  public void add(int index, E e) {
    if (size == elementData.length) {
      grow();
    }
    shiftRightFrom(index);
    elementData[index] = e;
    size++;
  }

  //요소의 마지막부터 index까지 오른쪽으로 밀기
  private void shiftRightFrom(int index) {
    for (int i = size; i > index; i--) {
      elementData[i] = elementData[i - 1];
    }
  }

  @Override
  @SuppressWarnings("unchecked")
  public E get(int index) {
    return (E) elementData[index];
  }

  @Override
  public E set(int index, E element) {
    E oldValue = get(index);
    elementData[index] = element;
    return oldValue;
  }

  @Override
  public E remove(int index) {
    E oldValue = get(index);
    shiftLeftFrom(index);

    size--;
    elementData[size] = null;
    return oldValue;
  }

  //요소의 index부터 마지막까지 왼쪽으로 밀기
  private void shiftLeftFrom(int index) {
    for(int i = index; i < size - 1; i++) {
      elementData[i] = elementData[i + 1];
    }
  }

  @Override
  public int indexOf(E o) {
    for (int i = 0; i < size; i++) {
      if (o.equals(elementData[i])) {
        return i;
      }
    }
    return -1;
  }

  private void grow() {
    int oldCapacity = elementData.length;
    int newCapacity = oldCapacity * 2;
    elementData = Arrays.copyOf(elementData, newCapacity);
  }

  @Override
  public String toString() {
    return Arrays.toString(Arrays.copyOf(elementData, size)) " size=" + size
    + ", capacity=" + elementData.length;
  }

}






컴파일 단계에서는 문법에 맞게 하려고 타입 지정을 하지만

런타임중에는 사실 제네릭이 Object나 bound로 바뀐다.

 */


