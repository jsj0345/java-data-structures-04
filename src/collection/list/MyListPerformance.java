package collection.list;

public class MyListPerformance {

  public static void main(String[] args) {
    int size = 50000;
    System.out.println("==MyArrayList 추가==");
    addFirst(new MyArrayList<>(), size);
    addMid(new MyArrayList<>(), size); // 찾는데 O(1), 데이터를 미는데 O(n)

    MyArrayList<Integer> arrayList = new MyArrayList<>(); // 조회용 데이터로 사용
    addLast(arrayList, size); // 데이터를 찾는데 O(1) 미는데 O(1)

    int loop = 10000;
    System.out.println("==MyArrayList 조회==");
    getIndex(arrayList, loop, 0);
    getIndex(arrayList, loop, size / 2);
    getIndex(arrayList, loop, size - 1);

    System.out.println("==MyArrayList 검색==");
    search(arrayList, loop, 0);
    search(arrayList, loop, size / 2);
    search(arrayList, loop, size - 1);


    System.out.println("==MyLinkedList 추가==");
    addFirst(new MyLinkedList<>(), size);
    addMid(new MyLinkedList<>(), size); // 찾는데 O(n), 데이터 추가 O(1)

    MyLinkedList<Integer> linkedList = new MyLinkedList<>(); // 조회용 데이터로 사용
    addLast(linkedList, size); // 찾는데 O(n) , 추가 O(1)

    System.out.println("==MyLinkedList 조회==");
    getIndex(linkedList, loop, 0);
    getIndex(linkedList, loop, size / 2);
    getIndex(linkedList, loop, size - 1);

    System.out.println("==MyLinkedList 검색==");
    search(linkedList, loop, 0);
    search(linkedList, loop, size / 2);
    search(linkedList, loop, size - 1);

  }

  private static void addFirst(MyList<Integer> list, int size) {
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < size; i++) {
      list.add(0,i);
    }
    long endTime = System.currentTimeMillis();
    System.out.println("앞에 추가 - 크기: " + size + ", 계산 시간=" + (endTime - startTime) +"ms");
  }

  private static void addMid(MyList<Integer> list, int size) {
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < size; i++) {
      list.add(i / 2, i);
    }
    long endTime = System.currentTimeMillis();
    System.out.println("중간에 추가 - 크기: " + size + ", 계산 시간=" + (endTime - startTime) +"ms");
  }

  private static void addLast(MyList<Integer> list, int size) {
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < size; i++) {
      list.add(i);
    }
    long endTime = System.currentTimeMillis();
    System.out.println("뒤에 추가 - 크기: " + size + ", 계산 시간=" + (endTime - startTime) +"ms");
  }

  private static void getIndex(MyList<Integer> list, int loop, int index) {
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < loop; i++) {
      list.get(index);
    }
    long endTime = System.currentTimeMillis();
    System.out.println("index: " + index + ", 반복: " + loop + ", 계산 시간: " + (endTime - startTime) + "ms");
  }

  private static void search(MyList<Integer> list, int loop, int findValue) {
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < loop; i++) {
      list.indexOf(findValue);
    }
    long endTime = System.currentTimeMillis();
    System.out.println("findValue: " + findValue + ", 반복: " + loop + ", 계산 시간: " + (endTime - startTime) + "ms");
  }

}

/*
package collection.list;

public class MyListPerformanceTest {

  public static void main(String[] args) {
    int size = 50000;
    System.out.println("==MyArrayList 추가==");
    addFirst(new MyArrayList<>(), size);
    addMid(new MyArrayList<>(), size);

    MyArrayList<Integer> arrayList = new MyArrayList<>(); // 조회용 데이터로 사용

    addLast(arrayList, size);

    System.out.println("==MyLinkedList 추가==");
    addFirst(new MyLinkedList<>(), size);
    addMid(new MyLinkedList<>(), size);

    MyLinkedList<Integer> linkedList = new MyLinkedList<>(); // 조회용 데이터로 사용
    addLast(linkedList, size);

    int loop = 10000;
    System.out.println("==MyArrayList 조회==");
    getIndex(arrayList, loop, 0);
    getIndex(arrayList, loop, size / 2);
    getIndex(arrayList, loop, size - 1);

    System.out.println("==MyLinkedList 조회==");
    getIndex(linkedList, loop, 0);
    getIndex(linkedList, loop, size / 2);
    getIndex(linkedList, loop, size - 1);

    System.out.println("==MyArrayList 검색==");
    search(arrayList, loop, 0);
    search(arrayList, loop, size / 2);
    search(arrayList, loop, size - 1);

    System.out.println("==MyLinkedList 검색==");
    search(linkedList, loop, 0);
    search(linkedList, loop, size / 2);
    search(linkedList, loop, size - 1);

  }

  private static void addFirst(MyList<Integer> list, int size) {
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < size; i++) {
      list.add(0, i);
    }
    long endTime = System.currentTimeMillis();
    System.out.println("앞에 추가 - 크기: " + size + ", 계산 시간: " + (endTime - startTime) +
    "ms");
  }

  private static void addMid(MyLIst<Integer> list, int size) {
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < size; i++) {
      list.add(i / 2, i);
    }
    long endTime = System.currentTimeMillis();
    System.out.println("평균 추가 - 크기: " + size + ". 계산 시간: " + (endTime - startTime) + "ms");
  }

  private static void addLast(MyList<Integer> list, int size) {
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < size; i++) {
      list.add(i);
    }
    long endTime = System.currentTimeMillis();
    System.out.println("뒤에 추가 - 크기: " + size + ", 계산 시간: " + (endTime - startTime) + "ms");
  }

  private static void getIndex(MyList<Integer> list, int loop, int index) {
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < loop; i++) {
      list.get(index);
    }
    long endTime = System.currentTimeMillis();
    System.out.println("index: " + index + ", 반복: " + loop + ", 계산 시간: " + (endTime - startTime) +
    "ms");
  }

  private static void search(MyList<Integer> list, int loop, int findValue) {
    long startTime = System.currentTimeMillis();
    for(int i = 0; i < loop; i++) {
      list.indexOf(findValue);
    }
    long endTime = System.currentTimeMillis();
    System.out.println("findValue: " + findValue + ", 반복: " + loop +
    ",계산 시간: " (endTime - startTime) + "ms");
  }





}

이론적으로 MyLinkedList의 평균 추가(중간 삽입) 연산은 MyArrayList보다 빠를 수 있다.

그러나 실제 성능은 요소의 순차적 접근 속도, 메모리 할당 및 해제 비용, CPU 캐시 활용도 등

다양한 요소에 의해 영향을 받는다.

MyArrayList는 요소들이 메모리 상에서 연속적으로 위치하여 CPU 캐시 효율이 좋고, 메모리 접근 속도가 빠르다.

CPU 캐시(Cache)는 메인 메모리(RAM)보다 훨씬 빠른, CPU 내부의 작은 임시 저장소임.

메모리 지역성 -> 프로그램은 가까운 주소의 데이터를 자주 참조하는 경향이 있음. 이걸 공간 지역성이라고 하고

짭은 시간 안에 같은 데이터를 다시 참조하는 걸 시간 지역성이라 함.




 */