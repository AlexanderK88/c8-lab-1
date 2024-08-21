package se.domain.project;

public class HourlyPrice {
  private final String hourRange;
  private final int price;

  public HourlyPrice(String hourRange, int price) {
    this.hourRange = hourRange;
    this.price = price;
  }

  public int getPrice() {
    return price;
  }

  public String getHourRange() {
    return hourRange;
  }
}