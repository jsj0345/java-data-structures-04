package problem;

import java.util.HashMap;
import java.util.Random;
import java.util.Map;
import java.util.Set;

class Race {

  /*
  1. 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자 이름으로 이루어짐.
  2. 참가자 중에는 동명이인이 있을 수 있다.
  3. completion의 길이는 participant의 길이보다 1 작습니다.
  4. 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하이다.
  5. 마라톤 미완주자는 단 한명뿐.
  */


  public String solution(String[] participant, String[] completion) {

    Map<String, Integer> participantMap = new HashMap<>();

    for(String s : participant) {
      participantMap.put(s, participantMap.getOrDefault(s, 0) + 1);
      // Map의 value값을 바꿔서 생각해보자.
      // 이미 있는 사람이면 인원수를 늘린다.

      // 원래는 key를 바꾸려고만 생각함.
    }

    for(String s : completion) {
      participantMap.put(s, participantMap.get(s) - 1); // key는 그대로 둔 다는 성질을 이용하여 인원수만 내리기.
    }

    Set<String> participantSet = participantMap.keySet(); // 지금 걸림돌이가 되는 것은 keySet() 이여서 데이터를 중복 등록하지 않음.
    // 즉, mislav를 두번 등록하는 것이 아닌 한번만 등록하는 것이 문제다.
    // key를 중복으로 등록하지 않게 해야 이 문장이 유효하다. (즉, key 값을 겹치지 않게 한다.)

    String nonFinisher = null; // 미완주자를 저장하는 변수

    // 미완주자 탐색
    for(String s : participantSet) {

      if (participantMap.get(s) > 0) {
        nonFinisher = s;
        break;
      }


//      if(!(participantMap.get(s).equals(completionMap.get(s)))) { // 다른 데이터만 추출해야 한다.
//        nonFinisher = participantMap.get(s);
//        break;
//      } else {
//        completionMap.remove(s);
//      }

    }

    return nonFinisher;
  }



  public static void main(String[] args) {

    Race race = new Race();

    String participants = "leo,kiki,eden";
    String completions = "eden,kiki";

    String[] participant = participants.split(",");
    String[] completion = completions.split(",");

    System.out.println(race.solution(participant, completion));

    participants = "marina,josipa,nikola,vinko,filipa";
    completions = "josipa,filipa,marina,nikola";

    participant = participants.split(",");
    completion = completions.split(",");

    System.out.println(race.solution(participant, completion));

    participants = "mislav,stanko,mislav,ana";
    completions = "stanko,ana,mislav";

    participant = participants.split(",");
    completion = completions.split(",");

    System.out.println(race.solution(participant, completion));

  }


}
