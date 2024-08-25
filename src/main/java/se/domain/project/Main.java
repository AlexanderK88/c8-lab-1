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
          prices = NavigationMenu.handleInput();
          break;
        case "2":
          NavigationMenu.handleMinMaxMedel(prices);
          break;
        case "3":
          NavigationMenu.handleSortPrices(prices);
          break;
        case "4":
          NavigationMenu.handleBestChargingHours(prices);
          break;
        case "e":
          NavigationMenu.handleExit();
          displayMenu = false;
          break;
        default:
          NavigationMenu.handleInvalidOption();
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
