package collection.link;

public class MyLinkedListV1Main {
  public static void main(String[] args) {
    MyLinkedListV1 list = new MyLinkedListV1();
    System.out.println("==데이터 추가==");
    System.out.println(list); // MyLinkedListV1{first=null, size=0}
    list.add("a");
    System.out.println(list); // MyLinkedListV1{first=[a], size=1}

    list.add("b");
    System.out.println(list); // MyLinkedListV1{first=[a->b], size=2}

    list.add("c");
    System.out.println(list); // MyLinkedListV1{first=[a->b->c], size=3}

    System.out.println("==기능 사용==");
    System.out.println("list.size() = " + list.size()); // 3
    System.out.println("list.get(1) = " + list.get(1)); // b
    System.out.println("list.indexOf('c') = " + list.indexOf("c")); //2
    System.out.println("list.set(2,'z') = " + list.set(2, "z")); // c
    System.out.println(list); // MyLinkedListV1{first=[a->b->z],size=3}


    list.add("d");
    System.out.println(list); // MyLinkedListV1{first=[a->b->z->d],size=4}
    list.add("e");
    System.out.println(list); // MyLinkedListV1{first=[a->b->z->d->e],size=5}

    //범위 초과, capacity가 늘어나지 않으면 예외 발생.
    list.add("f");
    System.out.println(list); // MyLinkedListV1{first=[a->b->z->d->e->f],size=6}
  }
}

/*
package collection.link;

public class MyLinkedListV1Main {

  public static void main(String[] args) {
    MyLinkedListV1 list = new MyLinkedListV1();
    System.out.println("==데이터 추가==");
    System.out.println(list); // MyLinkedListV1{first=null, size=0}
    list.add("a");
    System.out.println(list); // MyLinkedListV1{first=[a], size=1}
    list.add("b");
    System.out.println(list); // MyLinkedListV1{first=[a->b], size=2}
    list.add("c");
    System.out.println(list); // MyLinkedListV1{first=[a->b->c], size=3}

    System.out.println("==기능 사용==");
    System.out.println("list.size(): " + list.size()); // 2
    System.out.println("list.get(1): " + list.get(1)); // b
    System.out.println("list.indexOf('c'): " + list.indexOf("c")); //2
    System.out.println("list.set(2,'z'), oldValue: " + list.set(2,"z")); // c
    System.out.println(list); // MyLinkedListV1{first=[a->b->z], size=3}

    System.out.println("==범위 초과==");
    list.add("d");
    System.out.println(list);
    list.add("e");
    System.out.println(list);
    list.add("f");
    System.out.println(list);

  }

}


 */
