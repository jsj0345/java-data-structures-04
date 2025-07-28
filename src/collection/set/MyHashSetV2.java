package collection.set;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

public class MyHashSetV2 {

  static final int DEFAULT_INITIAL_CAPACITY = 16;

  private LinkedList<Object>[] buckets;

  private int size = 0;
  private int capacity = DEFAULT_INITIAL_CAPACITY;

  public MyHashSetV2() {
    initBuckets();
  }


  public MyHashSetV2(int capacity) {
    this.capacity = capacity;
    initBuckets();
  }

  private void initBuckets() {
    buckets = new LinkedList[capacity];
    for (int i = 0; i < capacity; i++) {
      buckets[i] = new LinkedList<>();
    }
  }

  public Boolean add(Object value) {
    int hashIndex = hashIndex(value);
    LinkedList<Object> bucket = buckets[hashIndex];
    if (bucket.contains(value)) {
      return false;
    }
    bucket.add(value);
    size++;
    return true;
  }

  public boolean contains(Object searchValue) {
    int hashIndex = hashIndex(searchValue);
    LinkedList<Object> bucket = buckets[hashIndex];
    return bucket.contains(searchValue);
  }

  private int hashIndex(Object value) {
    return Math.abs(value.hashCode()) % capacity;
    // 간단하게 바꾸고 싶으면 ctrl + alt + M (Inline variable)
    // hashCode가 음수가 나올 수도 있으니 절댓값을 취해줘야함.
    
  }

  public boolean remove(Object value) {
    int hashIndex = hashIndex(value);
    LinkedList<Object> bucket = buckets[hashIndex];
    boolean result = bucket.remove(value);
    /*
    LinkedList에 있는 remove 메서드를 보면 매개변수가 Object형 인 것과 기본형인 것이 있음.

    public E remove(int index) {
      checkElementIndex(index); // 인덱스 유효성 검사
      return unlink(node(index)); // 인덱스 위치 노드를 찾아서 제거
    }

    public boolean remove(Object o) {
    if (o == null) {
        for (Node<E> x = first; x != null; x = x.next) {
            if (x.item == null) {
                unlink(x);
                return true;
            }
        }
    } else {
        for (Node<E> x = first; x != null; x = x.next) {
            if (o.equals(x.item)) {
                unlink(x);
                return true;
            }
        }
    }
    return false;
    }

    여기서 int index가 매개 변수인 remove 메서드는 index 번째에 해당하는 노드 전체를 없애는 개념임.

    반면에 remove(Object o)는 여러개의 노드 중 o가 있는 노드가 있을텐데 그 노드의 o를 지우는 것.
     */
     if (result) {
       size--;
       return true;
     } else {
       return false;
     }

   }

    public int getSize() {
      return size;
    }

  @Override
  public String toString() {
    return "MyHashSetV2{" +
        "buckets=" + Arrays.toString(buckets) +
        ", size=" + size +
        ", capacity=" + capacity +
        '}';
  }

}

/*
package collection.set;

import java.util.Arrays;
import java.util.LinkedList;

public class MyHashSetV2 {

  static final int DEFAULT_INITIAL_CAPACITY = 16;

  private LinkedList<Object>[] buckets;

  private int size = 0;
  private int capacity = DEFAULT_INITIAL_CAPACITY;

  public MyHashSetV2() {
    initBuckets();
  }

  public MyHashSetV2(int capacity) {
    this.capacity = capacity;
    initBuckets();
  }

  private void initBuckets() {
    buckets = new LinkedList[capacity];
    for (int i = 0; i < capacity; i++) {
      buckets[i] = new LinkedList<>();
    }
  }

  public boolean add(Object value) {
    int hashIndex = hashIndex(value);
    LinkedList<Object> bucket = buckets[hashIndex];
    if (bucket.contains(value)) {
      return false;
    }

    bucket.add(value);
    size++;
    return true;
  }

  public boolean contains(Object searchValue) {
    int hashIndex = hashIndex(searchValue);
    LinkedList<Object> bucket = buckets[hashIndex];
    return bucket.contains(searchValue);
  }

  public boolean remove(Object value) {
    int hashIndex = hashIndex(value);
    LinkedList<Object> bucket = buckets[hashIndex];
    boolean result = bucket.remove(value);
    if (result) {
      size--;
      return true;
    } else {
      return false;
    }
  }

  private int hashIndex(Object value) {
    //hashCode의 결과로 음수가 나올 수 있다. abs()를 사용해서 마이너스를 제거한다.
    return Math.abs(value.hashCode()) % capacity;
  }

  public int getSize() {
    return size;
  }

}






 */




