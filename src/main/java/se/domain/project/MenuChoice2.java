package se.domain.project;

public class MenuChoice2 {

  public static void displayAverage(HourlyPrice[] prices) {
    int total = 0;
    int count = 0;

    for (HourlyPrice price : prices) {
      if (price != null) {
        total += price.getPrice();
        count++;
      }
    }

    if (count == 0) {
      System.out.println("Inga priser hittades.");
    } else {
      double average = (double) total / count;
      System.out.println("Dagens elpriser har ett medelvärde på: " + average + " öre per kWh.");
    }
  }

  public static void minValue(HourlyPrice[] prices) {
    HourlyPrice minPrice = null;

    for (HourlyPrice price : prices) {
      if (price != null && (minPrice == null || price.getPrice() < minPrice.getPrice())) {
        minPrice = price;
      }
    }
    if (minPrice == null) {
      System.out.println("Inga priser hittades.");
    } else {
      System.out.println("Klockan " + minPrice.getHourRange() + " är priest som lägst: "+ minPrice.getPrice() + " öre per kWh." );
    }
  }

  public static void maxValue(HourlyPrice[] prices) {
    HourlyPrice maxPrice = null;

    for (HourlyPrice price : prices) {
      if (price != null && (maxPrice == null || price.getPrice() > maxPrice.getPrice())) {
        maxPrice = price;
      }
    }
    if (maxPrice == null) {
      System.out.println("Inga priser hittades.");
    } else {
      System.out.println("Klockan " + maxPrice.getHourRange() + " är priset som högst: "+ maxPrice.getPrice() + " öre per kWh." );
    }
  }
}
