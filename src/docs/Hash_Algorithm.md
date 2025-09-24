## 컬렉션 프레임워크 - 해시(Hash)

### 1. 리스트(List) vs 세트(Set)

List(리스트)

정의 : 리스트는 요소들의 순차적인 컬렉션이다. 요소들은 특정 순서를 가지며, 같은 요소가 여러 번 나타날 수 있다.

특징

- 순서 유지 : 리스트에 추가된 요소는 특정한 순서를 유지한다. 이 순서는 요소가 추가된 순서를 반영할 수 있다.  

- 중복 허용 : 리스트는 동일한 값이나 객체의 중복을 허용한다. 예를 들어, 같은 숫자나 문자열을 리스트 안에 여러번 저장 할 수 있다.

- 인덱스 접근 : 리스트의 각 요소는 인덱스를 통해 접근할 수 있다. 이 인덱스는 보통 0부터 사용한다.

- 용도 : 순서가 중요하거나 중복된 요소를 허용해야 하는 경우에 주로 사용된다. 

Set(세트,셋)

- 정의: 세트(셋)는 유일한 요소들의 컬렉션이다. 참고로 세트보다는 셋으로 많이 불린다.

- 특징

-> 유일성 : 셋에는 중복된 요소가 존재하지 않는다. 셋에 요소를 추가할 때, 이미 존재하는 요소면 무시된다.

-> 순서 미보장 : 대부분의 셋 구현에서는 요소들의 순서를 보장하지 않는다. 즉, 요소를 출력할 때, 입력 순서와 다를 수 있다.

-> 빠른 검색 : 셋은 요소의 유무를 빠르게 확인할 수 있도록 최적화되어 있다. 이는 데이터의 중복을 방지하고 빠른 조회를 가능하게 한다.

-> 용도 : 중복을 허용하지 않고, 요소의 유무만 중요한 경우에 사용된다.

예시 

List -> 장바구니 목록, 순서가 중요한 일련의 이벤트 목록.
Set -> 회원 ID 집합, 고유한 항목의 집합.

### 2. 해시 알고리즘 - index 사용

배열은 인덱스의 위치를 사용해서 데이터를 찾을 때 O(1)로 매우 빠른 특징을 가지고 있다.

반면에 데이터를 검색할 때는 배열에 들어있는 데이터 하나하나를 모두 비교해야 하므로 인덱스를 활용할 수 없다.

그런데 만약에 데이터를 검색할 때도 인덱스를 활용해서 데이터를 한 번에 찾을 수 있다면 어떻게 될까?

데이터의 값과 배열의 인덱스를 맞추어 입력을 해보자. 

예를 들어서, Integer[] inputArray = new Integer[10];
inputArray[1] = 1;
inputArray[2] = 2;
inputArray[5] = 5;
inputArray[8] = 8;

이런식으로 값과 인덱스를 맞추면 데이터를 검색할떄나 조회할때 너무 쉬워진다. 

왜냐면 데이터를 검색할땐 인덱스를 활용을 못했는데 인덱스를 활용하면 O(1)이기 때문.

### 3. 해시 알고리즘 - 메모리 낭비

코드를 보자.

public class HashStart3 {
  
  public static void main(String[] args) { 
    //{1, 2, 5, 8, 14, 99}
    //[null, 1, 2, null, null, 5, null, null, 8, ..., 14, ....., 99]
    Integer[] inputArray = new Integer[100];
    inputArray[1] = 1;
    inputArray[2] = 2;
    inputArray[5] = 5;
    inputArray[8] = 8;
    inputArray[14] = 14;
    inputArray[99] = 99;

    int searchValue = 99;
    Integer result = inputArray[searchValue]; // O(1)
  }
}

여기서도 인덱스와 데이터를 맞췄다. 하지만 메모리 낭비가 너무 심하다.

배열에 100개의 데이터를 넣을 수 있는데 정작 6개의 데이터밖에 없어서 메모리 낭비가 심하다.

이런 낭비를 해결하기 위해 다른 해시 알고리즘에 대해서 알아보자.

### 4. 해시 알고리즘 - 나머지 연산 

방금 이야기한 것 처럼 모든 숫자를 입력할 수 있다고 가정한다면, 입력값의 범위가 너무 넓어져서

데이터의 값을 인덱스로 사용하기가 어렵다. 입력 값의 범위가 넓다고해서 해당 범위의 값을 다 입력하는 것도 아니다.

공간도 절약하면서, 넓은 범위의 값을 사용할 수 있는 방법이 있는데, 바로 나머지 연산을 사용하는 것이다.

예를 들어서, 배열의 크기를 10이라고 가정하자.

그러면 위에서 1,2,5,8,14,99 의 데이터를 넣었는데

다 10으로 나눈 나머지를 보면 1, 2, 5, 8, 4, 9이다. 

나머지 연산의 결과는 절대로 배열의 크기를 넘기지 않는다.(0~9)

안전하게 인덱스로 사용할 수 있다.

해시 인덱스 -> 이렇게 배열의 인덱스로 사용할 수 있도록 원래의 값을 계산한 인덱스를 해시 인덱스라 한다.

코드를 살펴보자. 

package collection.set;

import java.util.Arrays;

public class HashStart4 {

static final int CAPACITY = 10;

    public static void main(String[] args) {
        //{1, 2, 5, 8, 14, 99}
        System.out.println("hashIndex(1) = " + hashIndex(1));
        System.out.println("hashIndex(2) = " + hashIndex(2));
        System.out.println("hashIndex(5) = " + hashIndex(5));
        System.out.println("hashIndex(8) = " + hashIndex(8));
        System.out.println("hashIndex(14) = " + hashIndex(14));
        System.out.println("hashIndex(99) = " + hashIndex(99));
    
        Integer[] inputArray = new Integer[CAPACITY];
        add(inputArray, 1);
        add(inputArray, 2);
        add(inputArray, 5);
        add(inputArray, 8);
        add(inputArray, 14);
        add(inputArray, 99);
        System.out.println("inputArray = " + Arrays.toString(inputArray));
    
        //검색
        int searchValue = 14;
        int hashIndex = hashIndex(searchValue);
        System.out.println("searchValue hashIndex = " + hashIndex);
        Integer result = inputArray[hashIndex];
        System.out.println(result);
    }

    private static void add(Integer[] inputArray, int value) {
        int hashIndex = hashIndex(value);
        inputArray[hashIndex] = value;
    }

    static int hashIndex(int value) {
        return value % CAPACITY;
    }

}

이 코드를 보면 배열의 크기 안에 데이터를 다 넣을수 있다.

입력 값의 범위가 넓어도 실제로 모든 값이 들어오지는 않기 때문에 배열의 크기를 제한하고,

나머지 연산을 통해 메모리가 낭비되는 문제도 해결할 수 있다.

해시 인덱스를 사용해서 O(1)의 성능으로 데이터를 저장하고, O(1)의 성능으로 데이터를 조회할 수 있게 되었다.

덕분에 자료 구조의 조회 속도를 비약적으로 향상할 수 있게 되었다. 

하지만 한계점이 있다.

만약에 데이터가 1, 11이 들어온다면 hashIndex는 1로 동일하다. 저장할 위치가 충돌할 수 있다.

해시 충돌에 대해서 더 알아보자. 

### 5. 해시 알고리즘5 - 해시 충돌 

해시 충돌

99, 9의 두 값은 10으로 나눈 나머지가 9가 된다.

따라서 다른 값을 입력했지만 같은 해시 코드가 나오게 되는데 이것을 해시 충돌이라 한다. 

만약에

package collection.set;

import java.util.Arrays;

public class HashStart4 {

    static final int CAPACITY = 10;

    public static void main(String[] args) {

        Integer[] inputArray = new Integer[CAPACITY];
        add(inputArray, 5); 
        add(inputArray, 9); 
        add(inputArray, 99);
        System.out.println("inputArray = " + Arrays.toString(inputArray));

    }

    private static void add(Integer[] inputArray, int value) {
        int hashIndex = hashIndex(value);
        inputArray[hashIndex] = value;
    }

    static int hashIndex(int value) {
        return value % CAPACITY;
    }

}

이런 코드가 있다고 가정을 했을 때, 데이터 5는 문제가 없지만

9와 99가 문제다.

hashIndex(9)와 hashIndex(99)는 hashIndex가 9로 동일 하다.

이러면 99를 나중에 넣었으니 배열엔 99가 초기화 된다. 

여기서 해결하려면 CAPACITY의 값을 높이면 된다. 근데 이러면 또 메모리 낭비가 심해진다.

해결할 방법이 없을까?

일단 해시 인덱스가 같으면 그 인덱스 안에 또 다른 배열을 만들어서 데이터를 넣으면 된다. 

이건 코드를 보도록 하자. 

public class HashStart5 {

    static final int CAPACITY = 10;
    
    public static void main(String[] args) {
    
        LinkedList<Integer>[] buckets = new LinkedList[CAPACITY]; 
        System.out.println("buckets = " + Arrays.toString(buckets));

        for (int i = 0; i < CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
    
        System.out.println("buckets = " + Arrays.toString(buckets));
        add(buckets, 1);
        add(buckets, 2);
        add(buckets, 5);
        add(buckets, 8);
        add(buckets, 14);
        add(buckets, 99);
        add(buckets, 9);
        System.out.println("buckets = " + Arrays.toString(buckets)); 
    
        
        int searchValue = 9;
        boolean contains = contains(buckets, 9);
        System.out.println("buckets.contains(" + searchValue + ") = " + contains);
    
    
    }
    
    private static void add(LinkedList<Integer>[] buckets, int value) {
        int hashIndex = hashIndex(value);
        LinkedList<Integer> bucket = buckets[hashIndex]; 
        if (!bucket.contains(value)) { // value가 중복되지 않을 때, 값을 넣야함.
            bucket.add(value); // 왜 중복되지 않을 때 넣어야 할까? Set 구현 때문임.
        }
    }
    
    static int hashIndex(int value) {
        return value % CAPACITY;
    }
    
    private static boolean contains(LinkedList<Integer>[] buckets, int searchValue) {
        int hashIndex = hashIndex(searchValue);
        LinkedList<Integer> bucket = buckets[hashIndex];
        return bucket.contains(searchValue);
    }
}

여기서 이 코드를 잠깐 분석해보자.

먼저 LinkedList<Integer> buckets = new LinkedList[CAPACITY];

buckets라는 배열에는 LinkedList로 접근 할 수 있는 참조값들을 넣을 수 있다.

for (int i = 0; i < CAPACITY; i++) {
  buckets[i] = new LinkedList<>();
}

이 코드에선 LinkedList에 접근 할 수 있는 참조값을 각 인덱스에 넣은 것이다.

여기서 잠깐 알아둬야 할 것. 매번 객체가 새로 생성되는거니까 LinkedList에 접근 할 수 있는 참조값도 다 다름.

add메서드를 여러번 쓰는데 잠깐 add메서드를 살펴보자.

private static void add(LinkedList<Integer>[] buckets, int value) {
    int hashIndex = hashIndex(value);
    LinkedList<Integer> bucket = buckets[hashIndex]; // O(1)
    if (!bucket.contains(value)) { // O(n)
        bucket.add(value);
    }
}

이렇게 되어 있다.

이제 hashIndex를 얻어 낸 다음에 hashIndex에 위치한 곳에는 LinkedList로 접근 할 수 있는 참조값이 있을텐데

그러한 참조값을 bucket에 넣는다. (이제 bucket은 LinkedList 메서드 호출 가능)

이제 contains 메서드를 잠깐 살펴봐야 한다. (contains 메서드로 들어가면  indexOf 메서드 바로 실행)

public int indexOf(Object o) {
    int index = 0;
    if (o == null) {
        for (Node<E> x = first; x != null; x = x.next) {
            if (x.item == null)
                return index;
        index++;
        }
    } else {
        for (Node<E> x = first; x != null; x = x.next) {
            if (o.equals(x.item))
                return index;
        index++;
        }
    }
    return -1;
}

이 메서드를 보면 LinkedList 객체를 생성할땐 first = null, size = 0, last = null이다.

o값이 null이 아닐때를 보면 되는데 이미 first , last 가 null이므로 바로 탈출한다. 

그래서 -1을 반환하고 !bucket.contains(value) !false가 되므로 true가 된다.

add 메서드를 살펴보자. 

void linkLast(E e) {
    final Node<E> l = last;
    final Node<E> newNode = new Node<>(l, e, null);
    last = newNode;
        if (l == null) {
            first = newNode;
        }
        else {
            l.next = newNode;
        }
    size++;
    modCount++;
}

이제 first, last는 같아진다. 왜냐하면? 

먼저 숫자1을 넣는다 치면 new Node<>(l, new Integer(1), null); 이다.

근데 l이 null이니까 (맨처음 last == null, first==null이므로)

Node 클래스에 있는 prev, next -> null로 초기화 된다. 그리고 first = newNode, last = newNode로 서로 참조하는 값이 같아진다. 

이제 다른 인덱스에 있는 것들도 살펴보면 first last는 다 같을 것이다. 물론[99, 9] 제외이다. 

이제 [99, 9]를 살펴보자.

먼저 99와 9는 hashIndex가 9이다.

그러면 LinkedList로 접근 할 수 있는 참조값은 일단 같다.

그럼 생각을 해보자 먼저 99를 넣어보면.. 

먼저 Node 클래스에 있는 prev, next는 null이 될 것이다.

final Node<E> l = last;
final Node<E> newNode = new Node<>(l, e, null);

처음엔 last,first 둘다 null이여서 last = new Node<>(null, new Integer(99), null); first = new Node<>(null, new Integer(99), null);  // 이거의 참조값을 X001이라고 가정. 

그런데 여기서 9를 넣었다고 해보자. 그럼 9랑 같은 값은 없으니까 !bucket.contains(value) -> !false라 true가 된다.

그럼 add 메서드를 실행한다. 

맨처음에 Node<E> l = last;인데 아까전에 99를 넣었을때 last의 참조값은 X001이였다 

그렇다면 final Node<E> newNode = new Node<>(l(X001), new Integer(9), null); // X002 인 것이다. 

last = newNode가 되고 

l은 last가 newNode로 초기화 되기 전 값이므로 첫번째 노드이다. 이 노드 next에 newNode(X002)를 초기화 한것이다.

따라서 첫번째 노드에는 item -> new Integer(99), Node<E> prev -> null, Node<E> next -> X002이고

두번째 노드에는 item -> new Integer(9), Node<E> prev -> l(X001), Node<E> next -> null이다.

전개과정은 이렇고 Arrays.toString(buckets); 의 출력물을 보면

buckets = [[], [1], [2], [], [14], [5], [], [], [8], [99, 9]]

이렇게 나온다. 

이건 왜 이렇게 나올까? 

다음은 LinkedList의 toString 메서드다. 

public String toString() {
    Iterator<E> it = iterator();
    if (!it.hasNext()) {
        return "[]";
    }

    StringBuilder sb = new StringBuilder();
    sb.append('[');
    for (;;) {
        E e = it.next();
        sb.append(e == this ? "(this Collection)" : e);
        if (!it.hasNext())
            return sb.append(']').toString();
        sb.append(',').append(' ');
    }
}

이 메서드를 살펴보면 LinkedList는 컬렉션보다 하위 개념이다. 그래서 iterator()라는 메서드를 구현 해야한다.

iterator() 메서드의 반환값은 LinkedList라는 클래스의 내부 클래스로 접근 할 수 있는 참조값인데 그 참조값에서 next() 라는 메서드를 써서

요소를 순회한다. 

public Iterator<E> iterator() {
    return new Itr();
}

next 메서드는 간단하게 다음과 같다. 

private class Itr implements Iterator<E> {
    private Node<E> lastReturned;
    private Node<E> next;
    private int nextIndex;

    Itr() {
        next = first;
    }

    public E next() {
        lastReturned = next;
        next = next.next;
        return lastReturned.item; // ← 바로 이거!
    }
}

이렇게 LinkedList를 활용할 때, 배열안에 또 다른 배열이 있는것처럼 보이는게 설명이 된다. 

















