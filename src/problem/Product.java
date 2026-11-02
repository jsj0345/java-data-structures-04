package problem;

public class Product {

  private int id; // 상품ID
  private String productName; // 상품명
  private int price; // 가격
  private int stock;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  @Override
  public String toString() {
    return "Product{" +
        "id=" + id +
        ", productName='" + productName + '\'' +
        ", price=" + price +
        ", stock=" + stock +
        '}';
  }
}
