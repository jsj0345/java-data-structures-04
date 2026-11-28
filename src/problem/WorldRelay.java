package problem;

import java.util.*;

// 끝말잇기 문제
class WorldRelay {

  /*
  n=3	["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"] -> [3,3]

         0 1 2  3 4 5  6 7 8 (원래 인덱스)
	       0 1 2  0 1 2  0 1 2 (n으로 나눴을때 나머지)

	원래 인덱스를 n(사람수)으로 나눴을때의 나머지를 기준으로 몇번째 사람인지 판단하기
  나머지를 기반으로 + 1 해주면 몇번째 사람인지 판단 가능하다.

  n=5  ["hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"]
  -> [0,0]

  n=2 ["hello", "one", "even", "never", "now", "world", "draw"]
  -> [1,3]

  */

  public int[] solution(int n, String[] words) {
    int[] answer = {};

    List<String> wordRelayList = new ArrayList<>(); // 끝말 잇기는 순서가 중요하므로 어레이리스트를 활용.
    Map<String, Integer> wordMap = new HashMap<>(); // 단어들 모음


    for(int i = 0; i < words.length; i++) {
      wordRelayList.add(i, words[i]);

      wordMap.put(words[i], wordMap.getOrDefault(words[i], 0) + 1);
      // 반복되는 단어가 있으면 나오는 횟수를 계산하기 위해 getOrDefault를 쓴다.
      // 11/28 수정 -> getOrDefault 메서드를 쓰는건 좋은데 기존 값에다가 더해야하는데 안더했음.

    }

    // System.out.println(wordMap);

    int oridinalNumber = 0; // 몇 번째 인지를 나타내는 변수
    int tryCount = 0;  // 시도를 몇 번 했는지를 나타내는 변수

    // subString(문자열 길이 -1); 을 이용하여 마지막 문자만 빼내자.
    for(int i = 0; i < wordRelayList.size(); i++) {

      if (i <= wordRelayList.size() -2) { // size() -1 번째 까지 포함시키면 인덱스 에러발생.

        if(endExtraction(wordRelayList.get(i)).equals(startExtraction(wordRelayList.get(i + 1)))) {
          //wordMap.put(wordRelayList.get(i), wordMap.get(wordRelayList.get(i)) - 1); // 이전에 나왔던 단어의 횟수를 감소시키기.

          /*
          11/26 -> 지금 중복 처리를 해결하지 못함.
          아래 코드를 수정해야 한다.
          문제점은 다음과 같다.
          else if에서 단어가 등장한 값이 1일때만 중복 처리를 하려고함.
          근데 단어가 나온 횟수 변화가 한번이라도 있으면 바로 중복 처리해야함.
          이 부분을 고려해보도록 하자.
          */

          if(wordMap.get(wordRelayList.get(i + 1)) >= 2) {

            /*
            마지막에 중복 되는 단어가 발생하면 답이없음.

            그래서 i + 1번째로 비교해야 한다.

            어차피 조건에 현재번째와 그 다음 번째를 비교하니까 그 다음 번째를 기준으로 생각하면 된다.
            */

            int index = wordRelayList.indexOf(wordRelayList.get(i + 1)); // 중복되는 키워드가 최초로 있는 지점을 파악.

            if((i + 1) != index) {
              oridinalNumber = ((i + 1) % n) + 1;
              tryCount = ((i + 1) / n) + 1;

              answer = new int[]{oridinalNumber, tryCount};

              return answer;

            }

          }

          continue;
        } else {

          //System.out.println(i); // 디버깅
          //System.out.println(n); // 디버깅

          // 몇번째 사람이 틀렸는지, 그리고 그사람의 끝말잇기 시도횟수가 몇번째인지를 계산해야함.
          oridinalNumber = ((i + 1) % n) + 1; // 몇 번째 인지를 계산.
          // 끝말잇기를 할 때는 뒤가 틀렸으니까 뒤를 기준으로 계산 해야함. 그래서 (i + 1)을 둠.

          // 시도횟수
          tryCount = ((i + 1) / n) + 1;
          // 끝말잇기를 할 때는 뒤가 틀렸으니까 뒤를 기준으로 계산 해야함. 그래서 (i + 1)을 둠.


          answer = new int[]{oridinalNumber, tryCount};

          return answer;
        }

      }

    }

    answer = new int[]{oridinalNumber, tryCount};

    return answer;
  }

  public String endExtraction(String word) { // 끝 문자열 추출
    return word.substring(word.length() -1);
  }

  public String startExtraction(String word) { // 시작 문자열 추출
    return word.substring(0, 1);
  }



  public static void main(String[] args) {

    WorldRelay worldRelay = new WorldRelay();

    int n = 3; // 사람 인원 수
    String[] words = new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

    System.out.println(Arrays.toString(worldRelay.solution(n, words)));

    n = 5;
    words = new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};

    System.out.println(Arrays.toString(worldRelay.solution(n, words)));

    n = 2;
    words = new String[]{"hello", "one", "even", "never", "now", "world", "draw"};

    System.out.println(Arrays.toString(worldRelay.solution(n, words)));

  }

}
