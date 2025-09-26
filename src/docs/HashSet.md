## Set과 해시 알고리즘

### 1. Set

- Set은 중복을 허용하지 않고 순서를 보장하지 않는 자료 구조이다.

- 이전에 Set을 잠깐 구현해봤을때, 데이터가 중복 되는지 확인 하려면 모든 요소들을 다 확인 하느라 

O(n)의 시간이 걸렸다. 이거를 HashIndex를 사용해서 해결해보자. 



```java
package collection.set;

import java.util.Arrays;
import java.util.LinkedList;

public class MyHashSetV1 {
   
  static final int DEFAULT_INITIAL_CAPACITY = 16;
  
  LinkedList<Integer>[] buckets;
  
  private int size = 0;
   
  private int capacity = DEFAULT_INITIAL_CAPACITY;
  
  public MyHashSetV1() {
    initBuckets();
  }

  public MyHashSetV1(int capacity) {
     this.capacity = capacity;
     initBuckets();
  }

  private void initBuckets() {
    buckets = new LinkedList[capacity];
    for (int i = 0; i < capacity; i++) {
      buckets[i] = new LinkedList<>();
    }
  }

  public boolean add(int value) {
    int hashIndex = hashIndex(value);
    LinkedList<Integer> bucket = buckets[hashIndex];
    if (bucket.contains(value)) {
       return false;
    }
   
    bucket.add(value);
    size++;

    return true; 
  }

  public boolean contains(int searchValue) {
    int hashIndex = hashIndex(searchValue);
    LinkedList<Integer> bucket = buckets[hashIndex];
    return bucket.contains(searchValue);
  }

  public boolean remove(int value) {
    int hashIndex = hashIndex(value);
    LinkedList<Integer> bucket = buckets[hashIndex];
    boolean result = bucket.remove(Integer.valueOf(value));
    if(result) {
      size--;
      return true;
    } else {
      return false;
    }  
  }

  private int hashIndex(int value) {
    return value % capacity;
  }

}

```
코드를 분석하면 initBuckets()는 buckets의 각 인덱스에 LinkedList라는 객체를 생성하고 그 참조값을 인덱스에 보관한다.

add()는 hashIndex를 구한 다음에 hashIndex 위치에 있는 LinkedList 참조값을 bucket에 저장함. 

그리고 contains 메서드로 넣으려고 하는 item 값이 있는지 확인하고 있으면 item을 추가하지 않는다.

item 값이 없으면 노드에 값을 추가함. (단, 만약에 어떤 LinkedList라는 한 참조값에 여러개의 아이템을 넣는다면 각 노드마다 조회해야함)

remove 메서드는 중간에 있는 노드를 제거한다하면 그 노드의 prev와 next를 이전 노드와 다음 노드에 초기화 해주고 제거하려는 노드의

prev와 next 값을 null로 초기화한다.

이 코드를 보면 해시 충돌의 확률은 낮으니까 어떤 값을 넣으면 해시인덱스에 그 값을 초기화하고 검색,삭제,등록의 연산 처리 시간이 O(1)이 된다.

물론 해시 충돌이 있다하면 O(n)이 될 수 있다. (확률이 낮음)

이제 남은 문제는 해시 인덱스를 사용하려면 데이터의 값을 배열의 인덱스로 사용해야 하는데..

"A","B"와 같은 문자열은 배열의 인덱스로 사용할 수 없다.

문자열 데이터를 저장할 때, 해시 인덱스를 사용하려면 어떻게 해야할까? 

### 2. 문자열 해시 코드 

지금까지 해시 인덱스를 구할 때 숫자를 기반으로 해시 인덱스를 구했다.

해시 인덱스는 배열의 인덱스로 사용해야 하므로 0,1,2,같은 숫자(양의 정수)만 사용할 수 있다.

따라서 문자를 사용할 수 없다.

문자 데이터를 기반으로 숫자 해시 인덱스를 구하려면 어떻게 해야 할까?

```java
package collection.set;

public class StringHashMain {
    
  static final int CAPACITY = 10;
  
  public static void main(String[] args) {
    //char
    char charA = 'A';
    char charB = 'B';
    System.out.println(charA + " = " + (int)charA);
    System.out.println(charB + " = " + (int)charB);
    
    //hashCode
    System.out.println("hashCode(A) = " + hashCode("A"));
    System.out.println("hashCode(B) = " + hashCode("B"));
    System.out.println("hashCode(AB) = " + hashCode("AB"));
    
    //hashIndex
    System.out.println("hashIndex(A) = " + hashIndex(hashCode("A")));
    System.out.println("hashIndex(B) = " + hashIndex(hashCode("B")));
    System.out.println("hashIndex(AB) = " + hashIndex(hashCode("AB")));
  }
  
  static int hashCode(String str) {
    char[] charArray = str.toCharArray();
    int sum = 0;
    for(char c : charArray) {
      sum+=c;
    }
    return sum; 
  }
  
  static int hashIndex(int value) {
    return value % CAPACITY; 
  }
}

/*
A = 65
B=  66
hashCode(A) = 65
hashCode(B) = 66
hashCode(AB) = 131
hashIndex(A) = 5
hashIndex(B) = 6
hashIndex(AB) = 1    
 */

```

위에 주석부분에 실행 결과를 적었다.

모든 문자는 본인만의 고유한 숫자로 표현할 수 있다.

예를 들어서 'A'는 65, 'B'는 66으로 표현된다. (아스키 코드 표 참고)

가장 단순하게 char형을 int형으로 캐스팅하면 문자의 고유한 숫자를 확인할 수 있다. 

### 3. 해시 코드와 해시 인덱스 

여기서는 hashCode()라는 메서드를 통해서 문자를 기반으로 고유한 숫자를 만들었다. 

이렇게 만들어진 숫자를 해시 코드라 한다. 

해시 인덱스는 코드에서 CAPACITY를 10으로 지정했으니까

어떤 숫자를 10으로 나눈 나머지는 0~9이다.

그러면 이 0~9가 해시 인덱스가 된다.

A와 B는 각각 해시코드 값이 65,66이므로

해시인덱스는 65 % 10 = 5, 66 % 10 = 6 이렇게 된다.

이렇게 생성된 해시 인덱스를 배열의 인덱스로 사용하면 된다.

### 4. 자바의 hashCode() 

해시 인덱스를 사용하는 해시 자료 구조는 데이터 추가, 검색, 삭제의 성능이 O(1)로 매우 빠르다. 따라서 많은 곳에서 자주 사용된다.

그런데 앞서 학습한 것 처럼 해시 자료 구조를 사용하려면 정수로 된 숫자 값인 해시 코드가 필요하다. 

자바에는 정수 int, Integer 뿐만 아니라 char, String, Double, Boolean등 수 많은 타입이 있다. 뿐만 아니라

개발자가 직접 정의한 Member, User와 같은 사용자 정의 타입도 있다.

이 모든 타입을 해시 자료 구조에 저장하려면 모든 객체가 숫자 해시 코드를 제공할 수 있어야 한다. 

Object.hashCode() -> 자바의 모든 객체가 자신만의 해시 코드를 표현할 수 있는 기능을 제공한다. 

```java
public class Object {
  public int hashCode();
}
```

- 이 메서드를 그대로 사용하기 보다는 보통 재정의(오버라이딩)해서 사용한다.

- 이 메서드의 기본 구현은 객체의 참조값을 기반으로 해시 코드를 생성한다. 

- 쉽게 이야기해서 객체의 인스턴스가 다르면 해시 코드도 다르다.

코드를 구현해보자. 

```java
package collection.set.member;

import java.util.Objects;

public class Member {
   
  private String id;
  
  public Member(String id) {
    this.id = id;
  }
  
  public String getId() {
    return id;
  }
  
  @Override
  public boolean equals(Object o) {
    if(this == o) { // 서로의 참조값이 같을 때, true를 반환하는데 이거는 Object 클래스의 equals 메서드와 동일하다.
      return true; 
    }
    
    if(o == null || getClass() != o.getClass()) { 
      return false;
    }
    /*
     o가 null이거나 o의 클래스와 현재 클래스가 서로 다를때 return false; 
     */
    
    Member member = (Member) o; // o와 현재 클래스가 서로 같으면 다운 캐스팅 
    
    return Objects.equals(id, member.id);  // 다운 캐스팅한 변수의 id라는 멤버변수와 현재 클래스의 멤버변수가 같은지를 판별하고 반환. 
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(id); // id를 바탕으로 한 hashCode 계산하는 메서드 
  }
  
  @Override
  public String toString() {
    return "Member{" + "id='" + id + '\'' +
        '}';
  }
  
}


```

```java
package collection.set;

import collection.set.member.Member;

import java.sql.SQLOutput;

public class JavaHashCodeMain {

  public static void main(String[] args) {
    //Object의 기본 hashCode는 객체의 참조값을 기반으로 생성 
    Object obj1 = new Object();
    Object obj2 = new Object();
    System.out.println("obj1.hashCode() = " + obj1.hashCode());
    System.out.println("obj2.hashCode() = " + obj2.hashCode());

    //각 클래스마다 hashCode를 이미 오버라이딩 해두었다.
    Integer i = 10;
    String strA = "A";
    String strAB = "AB";
    System.out.println("10.hashCode = " + i.hashCode());
    System.out.println("'A'.hashCode = " + strA.hashCode());
    System.out.println("'AB'.hashCode = " + strAB.hashCode());
    
    //hashCode는 마이너스 값이 들어올 수 있다.
    System.out.println("-1.hashCode = " + Integer.valueOf(-1).hashCode());
    
    //둘은 같을까 다를까?, 인스턴스는 다르지만, equals는 같다.
    Member member1 = new Member("idA");
    Member member2 = new Member("idA");

    System.out.println("(member1 == member2) == " +(member1 == member2));
    System.out.println("member1 equals member2 = " + member1.equals(member2));
    System.out.println("member1.hashCode() = " + member1.hashCode());
    System.out.println("member2.hashCode() = " + member2.hashCode());
    
    
  }
}

/*
obj1.hashCode() = 189568618
obj2.hashCode() = 664223387
obj1 = java.lang.Object@b4c966a
10.hashCode() = 10
strA.hashCode() = 65
strAB.hashCode() = 2081
-1.hashCode() = -1
(member1 == member2) = false
(member1 equals member2) = true
member1.hashCode() = 104101
member2.hashCode() = 104101    
 */
```

위 코드의 결과는 주석에 달아뒀다.

여기서 주목해야 할 것은 각 문자열이나 참조형은 다 hashCode값을 갖고 있는데 

논리적인 동등성을 구현한 equals()메서드가 있을땐 안에 있는 멤버 변수로 두 객체가 같은지를 판별하기 때문에

멤버 변수가 같으면 해시 코드의 값도 같게 나오는 것이다. (같은 객체라고 인정을 했으니까)

**Object의 해시 코드 비교**

- Object가 기본으로 제공하는 hashCode()는 객체의 참조값을 해시 코드로 사용한다. 따라서 각각의 인스턴스 마다
서로 다른값을 반환한다.

**자바의 기본 클래스의 해시 코드**

- Integer, String 같은 자바의 기본 클래스들은 대부분 내부 값을 기반으로 해시 코드를 구할수 있도록 
hashCode() 메서드를 재정의해 두었다. 

- 따라서 데이터 값이 같으면 같은 해시 코드를 반환한다.

- 해시 코드의 경우 정수를 반환하기 때문에 마이너스 값이 나올 수 있다. 

### 5. 직접 구현하는 Set2

아까 MyHashSetV1는 Integer 숫자만 저장할 수 있었다. 여기서는 모든 타입을 저장할 수 있는 set을 만들어보자.

자바의 hashCode()를 사용하면 타입과 관계없이 해시 코드를 편리하게 구할 수 있다.

```java
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
    for(int i = 0; i < capacity; i++) {
      buckets[i] = new LinkedList<>();
    }
  }
  
  public boolean add(Object value) {
    int hashIndex = hashIndex(value);
    LinkedList<Object> bucket = buckets[hashIndex];
    if(bucket.contains(value)) {
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
    boolrean result = bucket.remove(value);
    
    if(result) {
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
  
  @Override
  public String toString() {
    return "MyHashSetV2{" +
        "buckets=" + Arrays.toString(buckets) +
        ", size = " + size +
        ", capacity = " + capacity +
        '}';
  } 
    
}
```

```java
package collection.set;

public class MyHashSetV2Main1 {
  public static void main(String[] args) {
    MyHashSetV2 set = new MyHashSetV2(10);

    set.add("A");
    set.add("B");
    set.add("C");
    set.add("D");
    set.add("SET");
    System.out.println(set);

    System.out.println("A.hashCode = " + "A".hashCode());
    System.out.println("B.hashCode = " + "B".hashCode());
    System.out.println("AB.hashCode = " + "AB".hashCode());
    System.out.println("SET.hashCode = " + "SET".hashCode());

    //검색
    String searchValue = "SET";
    boolean result = set.contains(searchValue);
    System.out.println("set.contains(" + searchValue + ") = " + result);
  }
}
```

```java
package collection.set;

import collection.set.Member.member;

public class MyHashSetV2Main2 {

  public static void main(String[] args) {
    MyHashSetV2 set = new MyHashSetV2(10);
    Member hi = new Member("hi");
    Member jpa = new Member("JPA");
    Member java = new Member("java");
    Member spring = new Member("spring");

    System.out.println("hi.hashCode() = " + hi.hashCode());
    System.out.println("jpa.hashCode() = " + jpa.hashCode());
    System.out.println("java.hashCode() = " + java.hashCode());
    System.out.println("spring.hashCode() = " + spring.hashCode());
    
    set.add(hi);
    set.add(jpa);
    set.add(java);
    set.add(spring);
    System.out.println(set);
    
    //검색
    Member searchValue = new Member("JPA");
    boolean result = set.contains(searchValue);
    System.out.println("set.contains(" + searchValue + ") = " + result);
  }
}

/*
hi.hashCode() = 3360
jpa.hashCode() = 73690
java.hashCode() = 3254849
spring.hashCode() = -895679956
MyHashSetV2{buckets=[[Member{id='hi'}, Member{id='JPA'}], [], [], [], [], [], [Member{id='spring'}], [], [], [Member{id='java'}]], size=4, capacity=10}
set.contains(Member{id='JPA'}) true
 */

```

결과는 위와 같다. 

잠깐 HashCode와 HashIndex에 대해서 말하기 전에 

MyHashSetV2{buckets=[[Member{id='hi'}, Member{id='JPA'}], [], [], [], [], [], [Member{id='spring'}], [], [], [Member{id='java'}]], size=4, capacity=10}

이러한 결과를 볼 수 있는데..

```java
public String toString() {
    Iterator<E> it = iterator();
    if (! it.hasNext())
        return "[]";

    StringBuilder sb = new StringBuilder();
    sb.append('[');
    for (;;) {
        E e = it.next();
        sb.append(e == this ? "(this Collection)" : e);
        if (! it.hasNext())
            return sb.append(']').toString();
        sb.append(',').append(' ');
    }
}
```

이 메서드는 LinkedList의 toString 메서드다 저기서 append(e)를 할 때, 그 객체에 해당하는 toString을 호출해서 결과가

특이하게 나온다. 

Member의 hashCOde()를 id 값을 기반으로 재정의 해두었다. 

```java
@Override
public int hashCode() {
  return Objects.hash(id);
}
```

hashIndex(Object value)에서 value.hashCode()를 호출하면 실제로 Member에서 재정의한 hashCode()가 호출된다.

이렇게 반환된 해시 코드를 기반으로 해시 인덱스를 생성한다. 

equals() 사용처? -> 만약에 id가 같은데 equals()를 안쓰면 똑같은 인덱스에 값이 들어갈것임. (이거부터 설명)

hashCode()와 equals()가 얼마나 중요한지를 보기 위해 두 메서드가 없는 경우, 한 메서드만 있는 경우, 두 메서드만 있는 경우를 살펴보자.

### 6. hashCode(), equals() 활용

1. 먼저 hashCode(), equals() 둘 다 없는 경우를 살펴보자.

```java
package collection.set.member;

public class MemberNoHashNoEq {
    
   private String id;
   
   public MemberNoHashNoEq(String id) {
     this.id = id;
   }
   
   public String getId() {
     return id;
   }
   
   @Override
   public String toString() {
     return "MemberNoHashNoEq{" +
         "id='" + id + '\'' +
         '}';
   }
}
```

이제 이 상황에서 hashCode(), equals()를 main 메서드에서 써보자.

```java
package collection.set.member;

import collection.set.MyHashSetV2;

public class HashAndEqualsMain1 {
  public static void main(String[] args) {
    //중복 등록
    MyHashSetV2 set = new MyHashSetV2(10);
    MemberNoHashNoEqual m1 = new MemberNoHashNoEq("A");
    MemberNoHashNoEqual m2 = new MemberNoHashNoEq("A");

    System.out.println("m1.hashCode() = " + m1.hashCode());
    System.out.println("m2.hashCode() = " + m2.hashCode());
    System.out.println("m1.equals(m2) = " + m1.equals(m2));
    
    set.add(m1);
    set.add(m2);

    System.out.println(set);
    
    //검색 실패
    MemberNoHashNoEqual searchValue = new MemberNoHashNoEqual("A");
    System.out.println("searchValue.hashCode() = " + searchValue.hashCode());
    boolean contains = set.contains(searchValue);
    System.out.println("contains = " + contains);


  }
  /* 실행 결과
  //m1.hashCode() = 1922154895
  //m2.hashCode() = 960604060
  //m1.equals(m2) = false
  //MyHashSetV2{buckets=[[MemberNoHashNoEqual{id='A'}], [], [], [], [], [MemberNoHashNoEqual{id='A'}], [], [], [], []], size=2, capacity=10}
  //searchValue.hashCode() = 1996181658
  //contains = false  
   */
}  

```

위 코드는 hashCode(), equals() 메서드를 @Override 하지 않았다.

Object클래스의 hashCode()는 참조값 기반으로 만들어지므로 객체를 생성할때마다 참조값은 다르니까

id가 같다 하더라도 hashCode 값은 다 다를수 밖에 없다. id가 같다 하더라도 다른 해시 인덱스에 위치하는 이유다.

2. hashCode()는 구현했지만 equals()를 구현하지 않은 경우

```java
package collection.set.member;

import java.util.Objects;

public class MemberOnlyHash {
  private String id;
  
  public MemberOnlyHash(String id) {
    this.id = id; 
  }
  
  public String getId() {
    return id;
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
  
  @Override
  public String toString() {
    return "MemberOnlyHash{" +
        "id='" + id + '\'' +
        '}';
  }
}
```
```java
package collection.set.member;

import collection.set.MyHashSetV2;

public class HashAndEqualsMain2 {

  public static void main(String[] args) {
    //중복 등록
    MyHashSetV2 set = new MyHashSetV2(10);
    MemberOnlyHash m1 = new MemberOnlyHash("A");
    MemberOnlyHash m2 = new MemberOnlyHash("A");

    System.out.println("m1.hashCode() = " + m1.hashCode());
    System.out.println("m2.hashCode() = " + m2.hashCode());
    System.out.println("m1.equals(m2) = " + m1.equals(m2));
    
    set.add(m1);
    set.add(m2);
    System.out.println(set);
    
    //검색 실패 
    MemberOnlyHash searchValue = new MemberOnlyHash("A");
    System.out.println("searchValue.hashCode() = " + searchValue.hashCode());
    boolean contains = set.contains(searchValue);
    System.out.println("contains = " + contains);

  }
}

/*
m1.hashCode() = 65
m2.hashCode() = 65
m1.equals(m2) = false
MyHashSetV2{buckets=[[], [], [], [], [], [MemberOnlyHash{id='A'}, MemberOnlyHash{id='A'}], [], [], [], []], size=2, capacity=10}
searchValue.hashCode() = 65
contains = false
 */
```

결과는 주석 부분에 적어놨다. 

당연히 hashCode()는 같을 것이다. @Override한 메서드를 다시 보자

```java
import java.util.Objects;

public int hashCode() {
  return Objects.hash(id);
}
```

id를 기반으로 hashCode()를 만들기 때문에 다 "A"라는 같은 문자열을 쓰니까 hashCode() 값은 같다.

그런데 중요한건 LinkedList에 들어갈땐 해시 인덱스 값이 같으니까 같은 인덱스 위치에 데이터가 들어간다. 

데이터가 들어갈때 Object item; item에 들어간다. 물론 m1은 참조형이니까 item엔 참조값이 들어갈것이다.

id가 같더라도 참조값 자체는 다르므로 LinkedList안에 있는 Node 클래스의 item 변수엔 다른 값이 들어갈것이므로 

m1,m2는 서로 다른 노드의 item에 들어간다. 따라서 데이터를 조회한다하더라도 참조값을 기반으로 조회하기 때문에 당연히 

boolean contains = set.contains(searchValue); 이 구문은 false가 된다. 

3. hashCode()와 equals()를 구현한 경우 

```java
package collection.set.member;

import collection.set.MyHashSetV2;

public class HashAndEqualsMain3 {
  
  public static void main(String[] args) {
    //중복 등록 안됨
    MyHashSetV2 set = new MyHashSetV2(10);
    Member m1 = new Member("A");
    Member m2 = new Member("A");
    System.out.println("m1.hashCode() = " + m1.hashCode());
    System.out.println("m2.hashCode() = " + m2.hashCode());
    System.out.println("m1.equals(m2) = " + m1.equals(m2));
    
    set.add(m1);
    set.add(m2);
    System.out.println(set);
    
    //검색 성공
    Member searchValue = new Member("A");
    System.out.println("searchValue.hashCode() = " + searchValue.hashCode());
    boolean contains = set.contains(searchValue);
    System.out.println("contains = " + contains);
  }
  
}
```

먼저 id를 기반으로 hashCode를 생성하기 때문에 m1.hashCode() 와 m2.hashCode()는 같다.

그리고 equals메서드를 재정의 했을때 id를 기반으로 오버라이드 한거기 때문에 당연히 id는 서로 같으니까 m1.equals(m2)는 true다.

set.add(m1); set.add(m2);에서는 같은 해시코드값을 가진 m1과 m2를 set에 넣는건데 그러면 중요한건 m1과 m2를 넣을때 같은 해시인덱스에 넣었으니

이제 m1,m2를 item이라는 변수에 초기화하고 다른 노드에 삽입을 해야한다. 그러나 contains메서드에는 다음 노드로 넘어가기전에 equals 메서드를 이용해서 데이터 조회를 한다. 

매개변수로 넣는 값은 Member형이기 때문에 equals 메서드도 Member 클래스에 오버라이드한 equals 메서드를 호출한다. 그럼 true가 나올 것이다. 그럼 데이터가 있는 것이므로

참조값이 달라도 id를 기반으로 한 동등성을 보는거기때문에 데이터가 중복되지 않는다. 





  
























  
  