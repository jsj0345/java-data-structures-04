package collection.list;

public class BatchProcessorMain {
  public static void main(String[] args) {
    MyLinkedList<Integer> list = new MyLinkedList<>();
    BatchProcessor processor = new BatchProcessor(list);
    processor.logic(100_000);

  }
}

/*

package collection.list;

public class BatchProcessorMain {

  public static void main(String[] args) {

    MyArrayList<Integer> list = new MyArrayList<>();
    //MyLinkedList<Integer> list = new MyLinkedList<>();

    BatchProcessor processor = new BatchProcessor(list);
    processor.logic(50_000);
  }

}
교재 13page를 보면 점선 화살표와 실선 화살표가 있음

화살표는 의존 관계를 의미. 점선 화살표는 자식은 부모를 알지만 부모는 자식을 모른다는 것을 의미.

실선 화살표는 상대방에 대해서 아는 것. 의존 관계 포함.

화살표가 향하는 방향은 향하는쪽을 의존한다를 의미.

간접 의존 = 인터페이스 / 추상 클래스에 의존

직접 의존 = 구체 클래스에 의존
 */
