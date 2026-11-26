package problem;

import java.util.*;

class Card {


  /*
  카드 뭉치 문제

  - 원하는 카드 뭉치에서 카드를 순서대로 한 장씩 사용합니다.
  - 한 번 사용한 카드는 다시 사용할 수 없습니다.
  - 카드를 사용하지 않고 다음 카드로 넘어갈 수 없습니다.
  - 기존에 주어진 카드 뭉치의 단어 순서는 바꿀 수 없습니다.

  첫 번째 카드 뭉치에 순서대로 ["i", "drink", "water"]
  두 번째 카드 뭉치에 순서대로 ["want", "to"] 가 적혀있을 때
  ["i" , "want", "to", "drink", "water"] 순서의 단어 배열을
  만들려고 한다면 첫 번째 카드 뭉치에서 "i"를 사용한 후 두 번째 카드 뭉치에서
  "want", "to"를 사용하고 첫 번째 카드뭉치에 "drink"와 "water"를 사용한다면
  원하는 순서의 단어 배열을 만들 수 있다.

  문자열로 이루어진 배열 cards1, cards2와 원하는 단어 배열 goal이 매개변수로 주어질 때,
  cards1 과 cards2 에 적힌 단어들로 goal를 만들었다면 "Yes"를, 만들 수 없다면 "No"를
  return하는 solution 함수를 완성하시오.

  cards1, cards2의 길이는 1이상 10이하이다.
  goal의 길이는 2이상 cards1의 길이 + cards2의 길이 이하이다.

  cards1, cards2, goal의 문자열들은 모두 알파벳 소문자로만 이루어져 있습니다.

   */

  public String solution(String[] cards1, String[] cards2, String[] goal) {
    String answer = "";

    // LinkedHashSet을 이용하여 문제를 해결해보자.
    // 중복을 허용하지 않고 순서를 보장하는 자료구조다.

    List<String> cards1List = new ArrayList<>();
    List<String> cards2List = new ArrayList<>();
    Set<String> goalSet = new LinkedHashSet<>();

    for(String s : cards1) {
      cards1List.add(s);
    }

    System.out.println(cards1List.toString());

    for(String s : cards2) {
      cards2List.add(s);
    }

    System.out.println(cards2List.toString());

    for(String s : goal) {
      goalSet.add(s);
    }

    System.out.println(goalSet);



    for(String s : goalSet) {
      int count = 0;

//        if (s.equals(cards1List.get(0)) && cards1List.size() != 0) { // 만약에 바로 꺼낼 수 있는 첫번째 요소라면 더이상 사용하지 못하게 제거한다.
//          // 지금 문제가 0번째 요소에 아무것도 없으면 바로 예외가 터짐.
//          cards1List.remove(s); // 제거를 하면 그 다음 요소를 쓸 수 있기 때문에 제거함.
//        } else if (s.equals(cards2List.get(0)) && cards2List.size() != 0) {
//          cards2List.remove(s);
//        } else {
//          answer = "No"; // 위 두 조건을 만족하지 않으면 No를 반환 시킨 다음에 끝낸다.
//          // 왜냐하면 문제에서는 첫 번째 요소에서 바로 꺼내야 한다는 제약 조건을 걸었기 때문.
//          return answer;
//        }

      if(cards1List.size() != 0) {
        if (s.equals(cards1List.get(0))) { // 매 첫 요소만 보면 된다. 문제 조건에서는 첫번째에 있는거부터 꺼내길 원하기 때문.
          cards1List.remove(s); // 요소를 계속 제거하다보면 0인 순간이 온다. 그래서 위에 size() != 0 조건을 걸어줘야 한다.
          count = count + 1; // 여기서 count에 1을 더했다는 것은 같은 요소가 있으니까 제거했다는 의미이다.
        }
      }

      if(cards2List.size() != 0) {

        if(s.equals(cards2List.get(0))) { // 위와 같은 논리.
          cards2List.remove(s);
          count = count + 1;
        }

      }

      if(count == 0) { // 0 이면 두 리스트의 첫 요소에는 같은게 없기 때문에 0인 것이다. 즉, 문장을 만들 수 없다는 의미다.
        answer = "No"; // No로 할당.
        return answer; // 순회 할 필요 없이 바로 멈추기.
      }

    }

    answer = "Yes"; // for문을 정상적으로 수행했으면 문장 완성을 할 수 있다는 의미에 Yes로 할당.

    return answer;
  }

  public static void main(String[] args) {

    Card card = new Card();

    String[] cards1 = new String[]{"i", "drink", "water"};
    String[] cards2 = new String[]{"want", "to"};
    String[] goal = new String[]{"i", "want", "to", "drink", "water"};

    String bool = card.solution(cards1, cards2, goal);

    System.out.println(bool);

    cards1 = new String[]{"i", "water", "drink"};
    cards2 = new String[]{"want", "to"};
    goal = new String[]{"i", "want", "to", "drink", "water"};

    bool = card.solution(cards1, cards2, goal);

    System.out.println(bool);


  }



}
