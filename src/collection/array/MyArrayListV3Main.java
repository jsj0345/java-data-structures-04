package collection.array;

public class MyArrayListV3Main {
  public static void main(String[] args) {
    MyArrayListV3 list = new MyArrayListV3();

    /*
    맨 처음에 객체를 생성 할 때, Object[] elementData = new Object[5]; , size = 0;

    list.add("a");를 하면
    [null, null, null, null, null] -> ["a", null, null, null, null]  size = 1;
     */

    list.add("a");

    list.add("b");
    // ["a", "b", null, null, null]  size = 2
    list.add("c");
    // ["a", "b", "c", null, null]   size = 3
    System.out.println(list); // ["a", "b", "c"] size = 3 , capacity = 5

    //원하는 위치에 추가
    System.out.println("addLast");
    list.add(3,"addList"); // O(1)

    /*
    ["a', "b", "c", null, null] 현 상황 size = 3 , elementData.length = 5

    grow()를 거칠 필요 없음.

    shiftRightFrom(3);

    for(int i = size; i > index; i--) {
      elementData[i] = elementData[i - 1];
    }

    ["a", "b", "c", "addLast", null]
     */
    System.out.println(list); // ["a", "b", "c", "addLast"] , elementData.length = 4

    System.out.println("addFirst");
    list.add(0, "addFirst"); // 0(n) ["a", "b", "c", "addLast", null]

    /*
    ["a", "b", "c", "addLast" , null] -> size = 4 , elementData.length = 5

    for (int i = 4; i > index; i--) {
      elementData[i] = elementData[i - 1];
    }

    ["addFirst", "a", "b", "c", "addLast"]

     */
    System.out.println(list); // -> size = 5, elementData.length = 5
    // ["addFirst", "a", "b" , "c", "addLast"]

    //삭제
    Object removed1 = list.remove(4);

    /*
    for(int i = index; i < size - 1; i++) {
      elementData[i] = elementData[i + 1];
    }

    ["addFirst", "a", "b", "c", "addLast"]

    index = 2

    elementData[2] = elementData[3]
    elementData[3] = elementData[4]



     */

    System.out.println("removed(4) = " + removed1);
    System.out.println(list);

    Object removed2 = list.remove(0);
    System.out.println("remove(0)=" + removed2);
    System.out.println(list);

  }
}

/*
Array -> 이 경우에는 데이터를 단순히 변경 할 수는 있음, 길이가 제한됨.
어떤 인덱스에 데이터를 넣는다고 생각해보자.

문제점이 데이터 순서를 보존하기 위해 오른쪽 방향으로 데이터를 이동 시키면서..
데이터를 넣으려는 인덱스에 데이터가 비어서 넣었다고 해도 "길이 제한"이란 것이 있기 때문에.
데이터 보존을 하지 못함.

반면 ArrayList 같은 경우에는..

배열의 길이를 유동적으로 늘릴 수도 있고.. 데이터를 삽입 할 때 길이를 동적으로 조절하면서

데이터 보존 및 순서 유지가 가능함.

[null, null, null, null, null]

["a", null, null, null, null]

["a", "b", null, null, null]

["a", "b", "c", null, null]

예를 들어서, 데이터를 인덱스 1번에 추가 하고싶음.

["a", "b", "c", null, null] -> size = 3 , elementData.length = 5

데이터를 옮겨야해. 오른쪽으로 (추가 할 때는)

데이터를 다 미는게 통상적으로는 정상인데 중요한게 null은 의미가 없어서 옮길 필요가 없다는거지. 불필요하다고.

shiftRightFrom(index);

private static void shiftRightFrom(int index) {
  for (int i = size; i > index; i--) {
    elementData[i] = elementData[i -1];
  }
}

["addFirst", "a", "b", "c", "addLast"]

index=1 데이터를 없애고싶다?

["addFirst","b","c","addLast"]

shiftLeftFrom(index);

for(int i = index ; i < size -1  ; i++) {
  elementData[i] = elementData[i + 1];
}


 */
