package se.domain.project;

public class HourlyPrice {
  private final String hourRange;
  private final int price;

  public HourlyPrice(String hourRange, int price) {
    if (hourRange == null || hourRange.isEmpty() || price < 0)
      throw new IllegalArgumentException();
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