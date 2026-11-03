import problem.Order;
import problem.Product;

import java.util.*;

public class Main {

  public static void main(String[] args) {

      /*
      상품ID(101) , 키보드, 50000원 10개
      상품ID(102) , 마우스, 30000원 5개
      상품ID(103) , 모니터, 200000원 3개
      */

      /*
      구현 요구사항
      1. 주문처리
      -> 상품 ID를 기준으로 상품을 찾는다.
      -> 주문 수량이 현재 재고 이하이면 주문을 승인한다.
      -> 주문 승인 시 재고를 차감한다.
      -> 재고가 부족하면 주문을 거절한다.
      -> 거절된 주문은 주문 내역에 저장하지 않는다.

      2. 주문 취소
      -> 기존에 승인된 주문만 취소할 수 있다.
      -> 주문을 취소하면 해당 상품의 재고를 복구한다.
      -> 이미 취소된 주문을 다시 취소할 수 없다.
      -> 존재하지 않는 주문도 취소할 수 없다.

      3. 주문 ID 중복 처리
      -> 이미 승인된 주문 ID로 새로운 주문을 생성할 수 없다.
      -> 취소된 주문 ID도 다시 사용할 수 없다.
      -> 주문 ID 중복 요청이 들어오면 기존 주문과 재고를 변경하지 않는다.

      4. 최종 결과 출력
      -> 상품별 남은 재고
      -> 승인된 주문 중 취소되지 않은 주문 목록
      -> 각 주문의 총 금액
      -> 취소되지 않은 주문의 전체 매출 합계


      */

      // 상품별 재고
      Map<Integer, Integer> stocks = new HashMap<>();

      stocks.put(101, 10);
      stocks.put(102, 5);
      stocks.put(103, 3);

      Map<Integer, Integer> prices = new HashMap<>();

      prices.put(101, 50000);
      prices.put(102, 30000);
      prices.put(103, 200000);

      // 요청 데이터
      List<String> requests = Arrays.asList(
          "ORDER:O001:101:3",
          "ORDER:O002:102:4",
          "ORDER:O003:101:8",
          "ORDER:O004:103:2",
          "CANCEL:O001:101:3",
          "ORDER:O005:101:8",
          "CANCEL:O002:102:4",
          "ORDER:O006:102:5",
          "CANCEL:O001:101:3"
      );

      /*
      일단 order 클래스와 product 클래스에 데이터를 넣고 생각.
      */

      Product product = new Product();
      Product product2 = new Product();
      Product product3 = new Product();

      Set<Integer> keyset = stocks.keySet();

      List<Product> list = new ArrayList<>(); // 제품 보관 리스트
      list.add(product);
      list.add(product2);
      list.add(product3);

      List<Order> orderList = new ArrayList<>(); // 주문 보관할 리스트.

      for(Integer id : keyset) {

        for(Product pro : list) {

          if(pro.getId() == 0) { // 초기에는 id가 0으로 설정되어 있으니까 데이터를 넣어야함. 넣으면 바로 반복문 탈출.
            // ArrayList는 순서를 보장하니까 이용함.
            pro.setId(id);
            pro.setStock(stocks.get(id));
            break;
          }

        }

      }

      for(Integer id : keyset) {

        for(Product pro : list) {
          if(pro.getId() == id.intValue()) {

            switch(pro.getId()) {

              case 101 :
                pro.setPrice(prices.get(id.intValue()));
                pro.setProductName("키보드");
                break;
              case 102 :
                pro.setPrice(prices.get(id.intValue()));
                pro.setProductName("마우스");
                break;
              case 103 :
                pro.setPrice(prices.get(id.intValue()));
                pro.setProductName("모니터");
                break;

            }



          }
        }

      }

      // (원래 위치) List<Order> orderList = new ArrayList<>(); // 주문 보관할 리스트.

      for(String s : requests) { // 주문 요구사항을 일단 넣고 언제 넣고 안넣을지를 정하기.

        String[] order_info = s.split(":");

        Order order = new Order(); // 주문 객체 생성

        for(int i = 0; i < order_info.length; i++) { // 주문 넣기
          switch(i) {
            case 0:
              order.setStatus(order_info[i]);
              break;
            case 1:
              order.setOrderId(order_info[i]);
              break;
            case 2:
              order.setId(Integer.parseInt(order_info[i]));
              break;
            case 3:
              order.setQuantity(Integer.parseInt(order_info[i]));
              break;
          }
        }

        Product pr = null; // 모든 조건을 다 충족했을때 객체를 할당하고 리스트에 추가했으면 다시 null로.

        // 최초 주문
        if(orderList.isEmpty()) { // 처음엔 주문 리스트가 없으니까 넣어야하는데 그냥 넣지말고 재고랑 비교한 다음에 넣기.

          for(Product pro : list) {

            if(pro.getId() == order.getId()) {

              if(pro.getStock() >= order.getQuantity() && order.getStatus().equals("ORDER")) { // 주문 상태이면서 재고보다 더 많으면 주문을 허용.
                pro.setStock(pro.getStock() - order.getQuantity());
                orderList.add(order); // 리스트 순회를 안하니까 추가해도 예외가 터지지 않는다.
                break; // 굳이 주문 목록을 더 볼 필요가 없기 때문에 탈출.
                // 여기서 만약에 요소를 추가하면 orderList.size() -> 1
              }

            }

          }

        } else { // 최초 주문이 아닐 때

          int count = 0; // orderList size와 비교할 변수.
          // 이 count가 orderList.size()와 같을 때 요소를 추가해보자.
          // 여기서 0으로 초기화 안하면 size보다 더 클 수 있음.

          for(Order o : orderList) { // 주문이 등록된 리스트에 있는 주문들을 순회.
            // 논리적인 오점이 있는게 맨 처음 주문이랑은 계속 다를 수 있음. 주문을 다 보고나서 넣을지를 결정해야한다.
            // 순회 하는 동안에 count 값을 유지해야 하므로 int count = 0;은 for문 위에다가 둔다.

            if(order.getOrderId().equals(o.getOrderId())) { // 주문이 들어온것과 기존 주문의 ID가 같은지 일단 비교.

              //주문 ID가 같으면 데이터 수정
              if(order.getStatus().equals("CANCEL") && o.getStatus().equals("ORDER")) { // 취소 했을때, 그리고 orderList에 있는 주문 상태가 ORDER일 때만 변경.

                for(Product pro : list) {
                  if(order.getId() == pro.getId()) {

                    pro.setStock(pro.getStock() + order.getQuantity()); // 취소 했으니 재고 복구.
                    o.setStatus("CANCEL"); // 취소로 바꿔야함.
                    break; // 여기서는 주문 목록에 추가하면 안된다.

                  }

                }

              } else { // ID까진 같은데 주문 리스트에 있는 주문 상태가 ORDER가 아닌 경우
                break; // 이때는 등록하면 안됨. 무시해도된다. (요구사항에 맞음)
              }

            } else { // ID 다른 주문일 때(근데 모든 요소를 비교하고나서 else문을 실행해야함)
              // 지금 문제가 첫번째 요소랑 다르기만 하면 무조건적으로 주문을 넣는게 문제임.
              // 아니면 orderlist를 순회하는 for문 및 로직을 어떤식으로 처리할지 고민.

              count = count + 1; // 달랐을 때, count를 늘리기.
              // Product pr = null;

              if(count == orderList.size()) { // 이 조건을 만족해야 orderList에 있는 모든 요소를 거침.

                for(Product pro : list) {

                  if(pro.getId() == order.getId()) {

                    // 지금 문제가 아래 조건을 거치고나서 break를 통과한 다음에 count 비교로만 바로 주문을 추가함.
                    // 이러면 재고 비교의 의미가 전혀없음.
                    // 재고까지 비교하면서 추가를 하는 방법을 찾아야한다.
                    if(pro.getStock() >= order.getQuantity()) { // 재고가 더 많으면 주문을 허용.
                      pro.setStock(pro.getStock() - order.getQuantity());
                      pr = pro; // 이때 객체를 할당 시키자. 그리고나서 break를 통과했을때 추가.
                      // orderList.add(order); (여기서 추가하면 예외터짐)
                      break;
                    } else {
                      break; // 재고가 더 적으면 주문리스트에 추가 자체를 하면 안된다.
                    }

                  }

                }

              }



            }

          }

          if(count == orderList.size() && pr != null) {
            orderList.add(order);
            pr = null;

          }

        }

      }

    System.out.println("========== 최종 상품 재고 ==========");
    for(Product p : list) {
      System.out.println(p.getProductName() + " " + "(" + p.getId() + "):" + " " + p.getStock() + "개");
    }

    int total_price = 0; // 총 매출액 계산하기 위한 변수
    int order_count = 0; // 총 주문 건수
    int total_quantity = 0; // 총 매출액

    System.out.println("========== 최종 주문 목록 ==========");
    for(Order o : orderList) {
      if(o.getStatus().equals("ORDER")) {

        order_count = order_count + 1;

        for(Product p : list) {

          if(o.getId() == p.getId()) {
            total_price = total_price + o.getQuantity() * p.getPrice();
            total_quantity = total_quantity + o.getQuantity();
            System.out.println(o.getOrderId() + " | " + p.getProductName() + " | " +
                "수량: " + o.getQuantity() + " | " + "주문 금액: " + o.getQuantity() * p.getPrice() + "원");
          }

        }

      }
    }

    System.out.println("========== 최종 매출 ==========");
    System.out.println("총 주문 건수: " + order_count + "건");
    System.out.println("총 판매 수량: " + total_quantity + "개");
    System.out.println("총 매출액: " + total_price + "원");

  }

}
