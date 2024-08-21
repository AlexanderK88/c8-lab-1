package se.domain.project;

public class MenuChoice2 {

  public static void displayAverage(HourlyPrice[] prices) {
    int total = 0;
    int count = 0;

    for (int i = 0; i < prices.length; i++) {
      if (prices[i] != null) {
        total += prices[i].getPrice();
        count++;
      }
    }
    if (count == 0) {
      System.out.println("Inga priser hittades.");
    } else {
      double average = (double) total / count;
      System.out.println("Dagens elpriser har ett medelvärde på: " + average + " Öre.");
    }
  }

  public static void minValue(HourlyPrice[] prices) {
    HourlyPrice minPrice = null;

    for (int i = 0; i < prices.length; i++) {
      if (prices[i] != null && (minPrice == null || prices[i].getPrice() < minPrice.getPrice())) {
        minPrice = prices[i];
      }
    }
    if (minPrice == null) {
      System.out.println("Inga priser hittades.");
    } else {
      System.out.println("Klockan " + minPrice.getHourRange() + " är priest som lägst: "+ minPrice.getPrice() + " Öre" );
    }
  }

  public static void maxValue(HourlyPrice[] prices) {
    HourlyPrice maxPrice = null;

    for (int i = 0; i < prices.length; i++) {
      if (prices[i] != null && (maxPrice == null || prices[i].getPrice() > maxPrice.getPrice())) {
        maxPrice = prices[i];
      }
    }
    if (maxPrice == null) {
      System.out.println("Inga priser hittades.");
    } else {
      System.out.println("Klockan " + maxPrice.getHourRange() + " är priset som högst: "+ maxPrice.getPrice() + " Öre" );
    }
  }
}
