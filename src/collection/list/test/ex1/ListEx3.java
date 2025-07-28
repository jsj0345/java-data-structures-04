package collection.list.test.ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class ListEx3 {

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
      intList.add(a);
    }

    int total = 0;
    double average = 0;

    for (int i = 0; i < intList.size(); i++) {
      total += intList.get(i).intValue();
    }

    average = (double) total / intList.size();

    System.out.println("입력한 정수의 합계: " + total);
    System.out.println("입력한 정수의 평균: " + average);




  }
}
