package se.domain.project;

public class NavigationMenu {

  public static void navigationMenu() {
    System.out.println("================");
    System.out.println("\tElpriser");
    System.out.println("================");
    System.out.println("1. Inmatning");
    System.out.println("2. Min, Max och Medal");
    System.out.println("3. Sortera");
    System.out.println("4. Bästa Laddningstid (4h)");
    System.out.println("e. Avsluta\n");
    System.out.print("Välj ett meny alternativ: ");
  }

  public static HourlyPrice[] handleInput() {
    System.out.println("=================");
    System.out.println("\tInmatning");
    System.out.println("=================");
    HourlyPrice[] prices = MenuChoice1.electricPriceInput();
    System.out.println();
    return prices;
  }

  public static void handleMinMaxMedel(HourlyPrice[] prices) {
    System.out.println("====================");
    System.out.println("Min, Max och Medal");
    System.out.println("====================");
    if (Main.isEmptyOrInvalidPrices(prices)) {
      System.out.println("\nInga priser hittades");
    } else {
      HourlyPrice minPrice = MenuChoice2.minValue(prices);
      if (minPrice != null) {
        System.out.println("Lägsta pris: " + minPrice.getPrice() + " öre per kWh under perioden " + minPrice.getHourRange());
      } else {
        System.out.println("Inga priser hittades");
      }

      HourlyPrice maxPrice = MenuChoice2.maxValue(prices);
      if (maxPrice != null) {
        System.out.println("Högsta pris: " + maxPrice.getPrice() + " öre per kWh under perioden " + maxPrice.getHourRange());
      } else {
        System.out.println("Inga priser hittades");
      }

      double averagePrice = MenuChoice2.average(prices);
      System.out.println("Genomsnittligt pris: " + averagePrice + " öre per kWh.");
    }
    System.out.println();
  }

  public static void handleSortPrices(HourlyPrice[] prices) {
    HourlyPrice[] pricesCopy = prices.clone();
    HourlyPrice[] sortedPrices = MenuChoice3.sortPrices(pricesCopy);
    if (sortedPrices != null) {
      System.out.println("Sorterade priser:");
      for (HourlyPrice price : sortedPrices) {
        if (price != null) {
          System.out.println(price.getHourRange() + " : " + price.getPrice() + " öre per kWh.");
        }
      }
    } else {
      System.out.println("Inga priser hittades");
    }
    System.out.println();
  }

  public static void handleBestChargingHours(HourlyPrice[] prices) {
    HourlyPrice[] bestHours = MenuChoice4.findBestChargingHours(prices);
    if (bestHours != null) {
      System.out.println("Bästa laddningstid:");
      for (HourlyPrice price : bestHours) {
        System.out.println(price.getHourRange() + " : " + price.getPrice() + " öre per kWh.");
      }
      double averageBestPrice = MenuChoice2.average(bestHours);
      System.out.println("Medelpris under dessa 4 timmar: " + averageBestPrice + " öre per kWh.");
    } else {
      System.out.println("Inga priser hittades");
    }
    System.out.println();
  }

  public static void handleExit() {
    System.out.println("Programmet avslutas...");
  }

  public static void handleInvalidOption() {
    System.out.println("\nOgiltigt val var god välj ett nummer mellan 1 och 4 eller E för att avsluta\n");
  }
}
