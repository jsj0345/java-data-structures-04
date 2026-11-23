package problem;

import java.util.*;

class Function {

  // 임시로 void로 바꿈. 결과물을 보기위함.
  // int[]로 이따 바꿔야한다. (반환형)
  public int[] solution(int[] progresses, int[] speeds) {

    List<Integer> progressList = new ArrayList<>();
    List<Integer> speedList = new ArrayList<>();

    List<Integer> completeList = new ArrayList<>(); // 100% 완성까지 걸리는 날짜 모음.

    List<Integer> completeTask = new ArrayList<>();

    for(int i = 0; i < progresses.length; i++) {
      progressList.add(i, progresses[i]); // 리스트에 요소 넣기
    }

    for(int i = 0; i < speeds.length; i++) {
      speedList.add(i, speeds[i]); // 리스트에 요소 넣기
    }

    for(int i = 0; i < progressList.size(); i++) {
      int progress = progressList.get(i); // 각 번째에 맞는 진행도를 갖고온다.
      int speed = speedList.get(i); // 각 번째에 맞는 속도를 갖고온다.

      for(int j = 1; ; j++) {
        /*
        위 조건식에서 j를 0으로 시작하면
        94,0 -> 95,1 -> 96,2 -> 97,3 -> 98,4 -> 99,5 -> 100,6 -> 101,7

        (여기서 , 앞에는 progress + speed, 뒤에는 completeList에 삽입될 값.)

        당일날 카운트가 안돼서 문제가 발생한다.
        그래서 j = 1로 시작한다면?
        94,1 -> 95,2 -> 96,3 -> 97,4 -> 98,5 -> 99,6 -> 100,7 이다!
        */

        progress = progress + speed; // 94,1 95,2 96,3 97,4 98,5, 99,6 100,7

        if(progress >= 100) {
          completeList.add(i, j);
          break;
        }
      }

    }

    int count = 0;

    int first = completeList.getFirst();

    for(int i = 0; i < completeList.size(); i++) {

        if(first >= completeList.get(i)) { // 첫번째 작업이 완료된 시간이 더 긴 경우에는 무조건 그 뒷작업들은 배포가 가능함.
           count = count + 1;

           if(i == completeList.size() - 1) {
             completeTask.add(count);
           }
        } else {
          completeTask.add(count);
          count = 1;
          first = completeList.get(i);

          if(i == completeList.size() - 1) {
            completeTask.add(count);
          }

//          if(completeList.get(i) == completeList.getLast()) {
//            completeTask.add(count);
//          }

          /*
          예를 들어서, completeList에 [7, 3, 9] 가 있다고 생각해보자.
          그러면 7일째 까지는 배포되는 기능의 개수는 2개다 왜냐하면
          문제를 보면 첫번째껀 작업이 배포되는데 7일 걸리고 두번째는 3일걸리는데 항상 첫번째를 시작해야함.
          그래서 두개임.
          근데 9일 걸리는 기능은 배포를 못함 하루에 한번만 가능함.
          그래서 9일째 일때는 새롭게 count = 1로 해야한다. 어차피 자신의 기능은 무조건 배포가 가능하므로.
          first 를 바꿔야하는 이유는 7에서 시작하면 9에서는 count를 증가시키지 못한다.
          기준 대상이 바껴야한다.
           */
        }

    }

    //System.out.println(completeList.toString());
    //System.out.println(completeTask.toString()); // 출력물 점검용.

    int[] completeTask_array = new int[completeTask.size()];

    for(int i = 0; i < completeTask.size(); i++) {
      completeTask_array[i] = completeTask.get(i);
    }

    return completeTask_array;

  }

  public static void main(String[] args) {

    Function function = new Function();

    int[] progresses = new int[]{93,30,55};
    int[] speeds = new int[]{1,30,5};

    // int[] completes = function.solution(progresses, speeds);
    System.out.println(Arrays.toString(function.solution(progresses, speeds)));

    progresses = new int[]{95, 90, 99, 99, 80, 99};
    speeds = new int[]{1, 1, 1, 1, 1, 1};

    System.out.println(Arrays.toString(function.solution(progresses, speeds)));

    // System.out.println(Arrays.toString(completes));

  }

}
