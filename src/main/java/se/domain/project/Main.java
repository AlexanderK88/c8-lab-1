package se.domain.project;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean displayMenu = true;
    HourlyPrice[] prices = new HourlyPrice[24];

    while (displayMenu) {
      NavigationMenu.navigationMenu();
      String choice = sc.nextLine().toLowerCase();
      System.out.println();

      switch (choice) {
        case "1":
          System.out.println("=================");
          System.out.println("\tInmatning");
          System.out.println("=================");

          prices = MenuChoice1.electricPriceInput();
          System.out.println();
          break;
        case "2":
          System.out.println("====================");
          System.out.println("Min, Max och Medal");
          System.out.println("====================");

          if (isEmptyOrInvalidPrices(prices)) {
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
          break;
        case "3":
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
          break;
        case "4":
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
          break;
        case "e":
          displayMenu = false;
          break;
        default:
          System.out.println("\nOgiltigt val var god välj ett nummer mellan 1 och 4 eller E för att avsluta\n");
          break;
      }
    }
  }

  public static boolean isEmptyOrInvalidPrices(HourlyPrice[] prices) {
    for (HourlyPrice price : prices) {
      if (price != null) {
        return false;
      }
    }
    return true;
  }
}
