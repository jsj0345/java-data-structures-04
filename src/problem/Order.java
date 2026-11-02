package problem;

public class Order {

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

  private String status; // 주문 상태
  private String orderId; // 주문 ID
  private int id; // 상품 번호
  private int quantity; // 주문 수량

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
