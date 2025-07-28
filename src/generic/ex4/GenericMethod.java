package generic.ex4;

public class GenericMethod {

  public static Object objMethod(Object obj) {
    System.out.println("Object print: " + obj);
    return obj;
  }

  public static<T> T genericMethod(T t) {
    System.out.println("generic print: " + t);
    return t;
  }

  /*
  원래 클래스 뒤에 Generic 기호인 <T>를 썼는데..
  그것은 클래스 전체 범위 안으로 해당 되는 것이고
  위처럼 메서드에 다이아몬드를 붙이면 메서드 내로 범위를 한정시킨 것.
   */

  public static <T extends Number> T numberMethod(T t) {
    System.out.println("bound print: " + t);
    return t;
  }

}

/*
package generic.ex4;

public class GenericMethod {

  public static Object objMethod(Object obj) {
    System.out.println("object print: " + obj);
    return obj;
  }

  public static <T> T genericMethod(T t) {
    System.out.println("generic print: " + t);
    return t;
  }

  public static <T extends Number> T numberMethod(T t) {
    System.out.println("bound print: " + t);
    return t;
  }

}

 */
