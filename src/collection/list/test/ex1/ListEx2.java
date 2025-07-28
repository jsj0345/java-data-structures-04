package collection.list.test.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListEx2 {

  public static void main(String[] args) {
    ArrayList<Integer> intList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    System.out.println("n개의 정수를 입력하세요 (종료 0)");
    while(true) {
      int a = scanner.nextInt();
      scanner.nextLine();
      if(a == 0) {
        break;
      }
      intList.add(a); // 오토 박싱
    }

    String a = print(intList);
    System.out.println(a);

  }

  private static String print(List<Integer> list) {
    System.out.println("출력");
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < list.size(); i++) {
      sb.append(list.get(i));
      if(i != list.size() - 1) {
        sb.append(", ");
      }
    }

    return sb.toString();
  }
}
