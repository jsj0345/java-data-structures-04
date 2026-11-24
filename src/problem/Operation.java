package problem;

import java.util.*;

class Operation {

  public int solution(int[] priorities, int location) {

    // location -> 인덱스 개념
    // 인덱스 번째에 해당하는 요소가 몇번째로 프로세스를 하는가?를 리턴해야함.

    int answer = 0;

    List<Integer> priorList = new ArrayList<>();

    for(int i = 0; i < priorities.length; i++) {
      priorList.add(i, priorities[i]);
    }

    int locationValue = priorList.get(location); // location번째에 위치한 값 뽑아내기

    int max = 0; // 가장 우선순위가 높은 변수를 설정하기 위함.
    int maxIndex = 0; // 가장 우선순위가 높은 변수의 위치값을 설정하기 위함.

    for(int i = 0; i < priorList.size(); i++) {

      if(priorList.get(i) > max) { // 9,9,9,9 이런식으로 최댓값이 여러개가 있을 수도 있으니까 최댓값이 가장 먼저 있는 곳을 찾아야함.
        max = priorList.get(i); // 최댓값 파악
        maxIndex = i;  // 최댓값 위치 파악
      }
    }


    return answer;

  }

  public static void main(String[] args) {

    // priorities -> 원소는 1이상 9이하 여야함.
    // priorities -> 원소는 우선순위를 나타냄. 숫자가 클 수록 우선순위가 높음.

    // location은 인덱스 개념이므로 프로세스 수 - 1
    // priorites 의 가장 앞에 있으면 0, 두 번째에 있으면 1

    Operation operation = new Operation();

    //int[] priorities = new int[(int) ((100 * Math.random()) + 1)];  // 배열의 길이를 1이상 100 이하로 둠.
    //int location = (int) (100 * Math.random()); // 인덱스이므로 priorities - 1 까지만 허용.

    int[] priorites = new int[]{2, 1, 3, 2};
    int location = 2;
    System.out.println(operation.solution(priorites, location));

    priorites = new int[]{1, 1, 9, 1, 1, 1};
    location = 0;
    //operation.solution(priorites, location);
    System.out.println(operation.solution(priorites, location));


  }


}
