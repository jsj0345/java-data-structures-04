package problem;

import java.util.*;

class Phone {

  public boolean solution(String[] phone_book)  {
    boolean answer = true;

    Map<String, String> phoneMap = new HashMap<>();

    for(String phoneNumber : phone_book) {
      phoneMap.put(phoneNumber, phoneNumber);
    }

    Set<String> keySet = phoneMap.keySet();

    Set<Map.Entry<String, String>> entrySet = phoneMap.entrySet();

    for(String s : keySet) { // keySet, entrySet을 활용하여 문제를 풀었다.
      /*
      keySet에 있는 한 요소를 토대로 비교해야한다.
      */

      for(Map.Entry<String, String> entry : entrySet) {
        if(s.equals(entry.getValue())) { // phoneMap.put(phoneNumber, phoneNumber); 자기 자신을 비교하는 상황이 발생한다.
          // 같을때는 continue를 이용하여 다음 요소에 대해 검증을 진행한다.
          continue;
        } else if (entry.getValue().startsWith(s)) { // 접두어를 포함하면 false로 반환하게 조건을 걸어둔다.
          answer = false;
          return answer; // 여기서 리턴을 하는 이유는 접두어가 같은 순간만 보면 되기 때문이다.
        }
      }



    }


    return answer; // for문 안에서 return을 거치지 않으면 true를 반환하게 해야 하므로 한번더 리턴을 작성.
  }

  public static void main(String[] args) {

    Phone phone = new Phone();

    String[] phone_book = new String[]{"119", "97674223", "1195524421"}; // 테스트 데이터1
    boolean answer = phone.solution(phone_book);
    System.out.println(answer);

    String[] phone_book2 = new String[]{"123","456","789"}; // 테스트 데이터2
    answer = phone.solution(phone_book2);
    System.out.println(answer);

    String[] phone_book3 = new String[]{"12","123","1235","567","88"}; // 테스트 데이터3
    answer = phone.solution(phone_book3);
    System.out.println(answer);



  }


}
