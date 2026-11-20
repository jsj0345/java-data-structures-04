package problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

  public int solution(int[] nums) {
    int answer = 0;

    int selectNumber = (nums.length / 2); // 선택할 수 있는 폰켓몬 수

    Set<Integer> select = new HashSet<>(); // 선택할 수 있는 최대 경우의 수 모음.

    for(int i = 0; i < nums.length; i++) {

      if(select.size() < selectNumber) { // 여기서 <=로 하면 [3,1,2,3] 같은 경우에 한번 더 오버카운트 하므로 <로 해야한다.
        select.add(nums[i]); // 중복은 안될 것이다. 2로 나눈 경우의 수까지 생각해줘야 한다.
      } else {
        break;
      }

    }

    answer = select.size();

    return answer;
  }

  public static void main(String[] args) {

    Solution solution = new Solution();
    // Math.random() 0이상 1미만

    int monster_number = (int) ((10000*Math.random()) + 1); // 폰켓몬 마리수를 설정하기 위한 변수
    // 1이상 10000이하. (짝수여야 한다.)

    if(monster_number % 2 != 0) { // 만약에 짝수가 아니면 강제로 1을 더해서 짝수로 만들자.
      monster_number = monster_number + 1;
    }

    // System.out.println(monster_number);

    int[] nums = new int[monster_number];

    for (int i = 0; i < nums.length; i++) {
      nums[i] = (int) ((Math.random() * 200000) + 1);
      // 폰켓몬의 종류 번호는 1이상 200,000이하의 자연수로 나타내야 하므로 다음과 같다.
    }

    System.out.println(solution.solution(nums));

  }

}
