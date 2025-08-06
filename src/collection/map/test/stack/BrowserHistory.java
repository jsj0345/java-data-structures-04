package collection.map.test.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
다시 작성 해보기
 */

public class BrowserHistory {
  // 코드 작성


  Stack<String> stack = new Stack<>();

  String url = "";

  public void visitPage(String webPage) {

    System.out.println("방문: " + stack.push(webPage));
  }

  public String goBack() {
    String backPage = stack.peek();
    System.out.println("뒤로 가기: " + backPage);

    return backPage;
  }




 /*
  private Deque<String> history = new ArrayDeque<>();
  private String currentPage = null;

  public void visitPage(String url) {
    if (currentPage != null) {
      history.push(currentPage);
    }
    currentPage = url;
    System.out.println("방문: " + url);
  }

  public String goBack() {
    if (!history.isEmpty()) {
      currentPage = history.pop();
      System.out.println("뒤로 가기: " + currentPage);
      return currentPage;
    }
    return null;
  }

  */


}
