package collection.list;

public class BatchProcessor{

  private final MyList<Integer> list; //추상적인 MyList 인터페이스에 의존. 재사용성 Up

  //MyList = new ArrayList
  //MyList = new LinkedList
  public BatchProcessor(MyList<Integer> list) { // 의존관계
    this.list = list;
  }

  public void logic(int size) {
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < size; i++) {
      list.add(0,i);
    }
    long endTime = System.currentTimeMillis();
    System.out.println("크기: " + size + ", 계산 시간: " + (endTime - startTime) + "ms");
  }


}

//////////////////////////////////////////////////////
/*
package collection.list;

public class BatchProcessor{

  private final MyList<Integer> list; //추상적인 MyList 인터페이스에 의존.

  //MyList = new ArrayList
  //MyList = new LinkedList
  public BatchProcessor(MyList<Integer> list) { // 의존관계
    this.list = list;
  }

  public void logic(int size) {
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < size; i++) {
      list.add(0,i);
    }
    long endTime = System.currentTimeMillis();
    System.out.println("크기: " + size + ", 계산 시간: " + (endTime - startTime) + "ms");
  }


}

 */

/////////////////////////////////////////////////////


/*
public class BatchProcessor {

  private final MyList<Integer> list;

  public BatchProcessor(MyList<Integer> list) {
    this.list = list;
  }

  public void logic(int size) {
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < size; i++) {
      list.add(0, i);
    }
    long endTime = System.currentTimeMillis();
    System.out.println("크기: " + size + ", 계산 시간: " + (endTime - startTime) + "ms");
  }

}


logic(int size) 메서드는 매우 복잡한 비즈니스 로직을 다룬다고 가정하자.

이 메서드는 list의 앞 부분에 데이터를 추가한다.

어떤 MyList list의 구현체를 선택할 지는 실행 시점에 생성자를 통해서 결정한다.

생성자를 통해서 MyList 구현체가 전달된다.

MyArrayList의 인스턴스가 들어올 수도 있고, MyLinkedList의 인스턴스가 들어올 수도 있다.

이것은 BatchProcessor의 외부에서 의존관계가 결정되어서 BatchProcessor 인스턴스에 들어오는 것 같다.

마치 의존관계가 외부에서 주입되는 것 같다고 해서 이것을 의존관계 주입이라 한다.

참고로 생성자를 통해서 의존관계를 주입했기 때문에 생성자 의존관계 주입이라 한다.




//////////////////////////////////////////
public class BatchProcessor {

  private final MyArrayList<Integer> list = new MyArrayList<>(); // 코드 변경

  public void logic(int size) {
    for (int i = 0; i < size; i++) {
      list.add(0, i);
    }
  }

}

MyArrayList를 보면 데이터를 추가 할 때, 데이터를 오른쪽으로 밀어 넣는 상황이 발생한다.

이러한 상황으로 인해 런타임이 길어지고 코드의 효율성이 떨어진다.

따라서 MyLinkedList를 사용하도록 코드를 변경 해보고싶다.

BatchProcessor의 내부 코드도 MyArrayList에서 MyLinkedList를 사용하도록 함께 변경 해야 한다.

public class BatchProcessor {

  private final MyLinkedList<Integer> list = new MyLinkedList<>();

  public void logic(int size) {
    for (int i = 0; i < size; i++) {
      list.add(0, i); // 앞에 추가
    }
  }

 }

 BatchProcessor는 구체적인 MyArrayList 또는 MyLinkedList를 사용하고 있다.

 이것을 BatchProcessor가 구체적인 클래스에 의존한다고 표현한다. 이렇게 구체적인 클래스에 직접 의존하면
 MyArrayList를 MyLinkedList로 변경할 때 마다 여기에 의존하는 BatchProcessor의 코드도 함께 수정해야 한다.

 BatchProcessor가 구체적인 클래스에 의존하는 대신 추상적인 MyList 인터페이스에 의존하는 방법도 있다.

 public class BatchProcessor {

   private final MyList<Integer> list;

   public BatchProcessor(MyList<Integer> list) {
     this.list = list;
   }

   public void logic(int size) {
     for (int i = 0; i < size; i++) {
       list.add(0,i);
     }
   }

 }

클라이언트 코드의 변경 없이 추상적인 것을 의존함으로써 전략을 언제든지 갈아 낄 수 있는 것이 전략 패턴임.

사용 하려는 타입에 대한 결정을 늦추면 재사용성이 높아짐.



 */