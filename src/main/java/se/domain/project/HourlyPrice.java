package se.domain.project;

public record HourlyPrice(String hourRange, int price) {
  public HourlyPrice {
    if (hourRange == null || hourRange.isEmpty() || price < 0)
      throw new IllegalArgumentException();
  }
}