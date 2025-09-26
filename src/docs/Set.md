## Set

### 1. 자바가 제공하는 set1 - HashSet, LinkedHashSet

- Set은 중복을 허용하지 않고, 순서를 보장하지 않는 자료 구조이다.

먼저 Set이 어떤식으로 상속 및 구현 관계인지 살펴보자.

최상위 개념은 Collection 인터페이스다.

이 인터페이스의 메서드를 상속받는 것은 Set다.

HashSet과 TreeSet은 Set를 구현한다.

HashSet의 자식은 LinkedHashSet.

TreeSet은 Set의 메서드를 구현하는 것인 관계고 HashSet,LinkedHashSet과 아무런 관계도 아니다. 

**Collection interface**

Collection 인터페이스는 java.util 패키지의 컬렉션 프레임워크의 핵심 인터페이스 중 하나다. 이 인터페이스는

자바에서 다양한 컬렉션, 즉 데이터 그룹을 다루기 위한 메서드를 정의한다. Collection 인터페이스는 List, Set, Queue와

같은 다양한 하위 인터페이스와 함꼐 사용되며, 이를 통한 데이터를 리스트, 세트, 큐등의 형태로 관리할 수 있다.

**Set interface**

자바의 Set 인터페이스는 java.util 패키지의 컬렉션 프레임워크에 속하는 인터페이스 중 하나이다. 

Set 인터페이스는 중복을 허용하지 않는 유일한 요소의 집합을 나타낸다. 즉, 어떤 요소도 같은 Set내에 두번 이상 나타날 수 없다.

Set는 수학적 집합 개념을 구현한 것이므로, 순서를 보장하지 않으며, 특정 요소가 집합에 있는지 여부를 확인하는데 최적화 되어있다.

### 2. Set의 구현체 - HashSet 

- 구현: 해시 자료 구조를 사용해서 요소를 저장한다.

- 순서: 요소들은 특정한 순서 없이 저장된다. 즉, 요소를 추가한 순서를 보장하지 않는다.

- 시간 복잡도: HashSet의 주요 연산(추가,삭제,검색)은 평균적으로 O(1) 시간 복잡도를 가진다. 

- 용도: 데이터의 유일성만 중요하고, 순서가 중요하지 않은 경우에 적합하다.

### 3. Set의 구현체 - LinkedHashSet

- 구현: LinkedHashSet은 HashSet에 연결 리스트를 추가해서 요소들의 순서를 유지한다.

- 순서: 요소들은 추가된 순서대로 유지된다. 즉, 순서대로 조회 시 요소들이 추가된 순서대로 반환된다.

- 시간 복잡도: LinkedHashSet도 HashSet과 마찬가지로 주요 연산에 대해 평균 O(1) 시간 복잡도를 가진다.

- 용도: 데이터의 유일성과 함께 삽입 순서를 유지해야 할 때 적합하다.

- 참고: 연결 링크를 유지해야 하기 때문에 HashSet 보다는 조금 무겁다.

- LinkedHashSet = HashSet + LinkedList

### 4. 자바가 제공하는 Set2 - TreeSet

- 구현: TreeSet은 이진 탐색 트리를 개선한 레드-블랙 트리를 내부에서 사용한다.

- 순서: 요소들은 정렬된 순서로 저장된다. 순서의 기준은 비교자(Comparator)로 변경할 수 있다. 

- 시간 복잡도: 주요 연산들은 O(log n)의 시간 복잡도를 가진다. 따라서 HashSet보다는 느리다.

- 용도: 데이터들을 정렬된 순서로 유지하면서 집합의 특성을 유지해야 할 때 사용한다. 예를 들어, 범위 검색이나 정렬된 데이터가 필요한 

경우에 유용하다. 참고로 입력된 순서가 아니라 데이터 값의 순서이다. 

### 5. 자바가 제공하는 Set3 - 예제

HashSet, LinkedHashSet, TreeSet에서 학습한 내용을 코드로 확인해보자.

```java
package collection.set.javaSet;

import java.util.*;

public class JavaSetMain {

  public static void main(String[] args) {
    run(new HashSet<>());
    run(new LinkedHashSet<>());
    run(new TreeSet<>());
  }
  
  private static void run(Set<String> set) {
    System.out.println("set = " + set.getClass());
    set.add("C");
    set.add("B");
    set.add("A");
    set.add("1");
    set.add("2");
    
    Iterator<String> iterator = set.iterator();
    while(iterator.hasNext()) {
      System.out.print(iterator.next() + " ");
    }
    System.out.println();
    
  }
  
  
}
/*
set = class java.util.HashSet
A 1 B 2 C 
set = class java.util.LinkedHashSet
C B A 1 2 
set = class java.util.TreeSet
1 2 A B C     
 */

```

- 결과를 보면 HashSet은 입력한 순서를 보장하지 않는다.

- LinkedHashSet는 입력한 순서를 정확히 보장한다.

- TreeSet은 데이터 값을 기준으로 정렬한다.

### 6. 자바가 제공하는 Set4 - 최적화

자바 HashSet과 최적화

- 자바의 HashSet은 직접 구현한 내용과 거의 같지만 다음과 같은 최적화를 추가로 진행한다.

최적화

- 해시 기반 자료 구조를 사용하는 경우 통계적으로 입력한 데이터의 수가 배열의 크기를 75%정도

넘어가면 해시 인덱스가 자주 충돌한다.

-> 해시 충돌로 같은 해시 인덱스에 들어간 데이터를 검색하려면 모두 탐색해야 한다.
따라서 성능이 O(n)으로 좋지 않다.

- 하지만 데이터가 동적으로 계속 추가되기 때문에 적절한 배열의 크기를 정하는 것은 어렵다.

- 자바의 HashSet은 데이터의 양이 배열 크기의 75%를 넘어가면 배열의 크기를 2배로 늘리고 2배 늘어난
크기를 기준으로 모든 요소에 해시 인덱스를 다시 적용한다.

- 자바 HashSet의 기본 크기는 16이다. 

- 데이터의양이 75% 이상이면 배열의 크기를 2배로 증가하고, 모든 데이터의 해시 인덱스를 커진 배열에 맞추어서 다시 계산한다.
이 과정을 재해싱(rehashing)이라 한다.

- 인덱스 충돌 가능성이 줄어든다.

- 여기서 데이터가 다시 75% 이상 증가하면 다시 2배 증가와 재계산을 반복한다. 







