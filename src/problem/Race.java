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

    Map<String, String> participantMap = new HashMap<>();
    Map<String, String> completionMap = new HashMap<>();

    for(String s : participant) {
      participantMap.put(s, s);
    }

    for(String s : completion) {
      completionMap.put(s, s);
    }

    Set<String> participantSet = participantMap.keySet();

    String nonFinisher = null;

    for(String s : participantSet) {

      if(!(participantMap.get(s).equals(completionMap.get(s)))) { // 다른 데이터만 추출해야 한다.
        nonFinisher = participantMap.get(s);
        break;
      }

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
