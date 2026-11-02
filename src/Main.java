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
      Set<Integer> keyset2 = prices.keySet();

      List<Product> list = new ArrayList<>(); // 제품 보관 리스트
      list.add(product);
      list.add(product2);
      list.add(product3);


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

      /*
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
      */

      List<Order> orderList = new ArrayList<>(); // 주문 보관할 리스트.

      for(String s : requests) {

        String[] order_info = s.split(":");

        Order order = new Order();

        for(int i = 0; i < order_info.length; i++) {
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

        if(orderList.isEmpty()) { // 처음엔 주문 리스트가 없으니까 넣어야하는데 그냥 넣지말고 재고랑 비교한 다음에 넣기.

          for(Product pro : list) {

            if(pro.getId() == order.getId()) {

              if(pro.getStock() > order.getQuantity()) { // 재고보다 더 많으면 주문을 허용.
                pro.setStock(pro.getStock() - order.getQuantity());
                orderList.add(order);
              }

            }

          }

        }

        for(Order o : orderList) {

          if(order.getOrderId().equals(o.getOrderId())) {

            //주문 ID가 같으면 데이터 수정
            if(order.getStatus().equals("CANCELLED")) { // 취소 했을때

              for(Product pro : list) {
                if(order.getId() == pro.getId()) {

                }
              }


            } else { // 주문 했을때

            }

          } else {

            for(Product pro : list) {

              if(pro.getId() == order.getId()) {

                if(pro.getStock() > order.getQuantity()) { // 재고보다 더 많으면 주문을 허용.
                  pro.setStock(pro.getStock() - order.getQuantity());
                  orderList.add(order);
                }

              }

            }

          }

        }


      }

  }



}

//        String[] order_info = s.split(":");
//
//        for(int i = 0; i < order_info.length; i++) {
//
//          Order order = null;
//
//          if(orderList.isEmpty()) {
//            order = new Order();
//          } else {
//
//            order = new Order(); // 일단 데이터 넣기
//
//            for(Order o : orderList) {
//              if(o.getOrderId().equals(order_info[1])) {
//
//                // 주문 ID가 같으면 데이터를 수정하자.
//                if(o.getStatus().equals("CANCELLED")) {
//
//                }
//
//              }
//            }
//
//          }
//
//
//          switch(i) {
//            case 0:
//              order.setStatus(order_info[i]);
//              break;
//            case 1:
//              order.setOrderId(order_info[i]);
//              break;
//            case 2:
//              order.setId(Integer.parseInt(order_info[i]));
//              break;
//            case 3:
//              order.setQuantity(Integer.parseInt(order_info[i]));
//              orderList.add(order);
//              break;
//          }
//
//
//
//        }
