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
          if (!hasValidPrices(prices)) {
            System.out.println("\nInga priser hittades");
          } else {
            MenuChoice2.minValue(prices);
            MenuChoice2.maxValue(prices);
            MenuChoice2.displayAverage(prices);
          }
          System.out.println();
          break;
        case "3":
          MenuChoice3.sortPrices(prices);
          break;
        case "4":
          System.out.println("\nMenyval 4\n");
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

  private static boolean hasValidPrices(HourlyPrice[] prices) {
    for (HourlyPrice price : prices) {
      if (price != null) {
        return true;
      }
    }
    return false;
  }
}
