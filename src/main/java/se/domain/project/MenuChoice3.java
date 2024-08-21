package se.domain.project;

public class MenuChoice3 {
  public static void sortPrices(HourlyPrice[] prices) {
    boolean swapsOccured;

    for (int i = 0; i < prices.length - 1; i++) {
      swapsOccured = false;

      for (int j = 0; j < prices.length - i - 1; j++) {
        if (prices[j].getPrice() > prices[j + 1].getPrice()) {
          HourlyPrice temp = prices[j];
          prices[j] = prices[j + 1];
          prices[j + 1] = temp;
          swapsOccured = true;
        }
      }
      if (!swapsOccured) {
        break;
      }
    }
    System.out.println("Sorterade priser:");

    for (HourlyPrice price : prices) {
      System.out.println(price.getHourRange() + " : " + price.getPrice() + " öre per kWh.");
    }

    System.out.println();
  }
}