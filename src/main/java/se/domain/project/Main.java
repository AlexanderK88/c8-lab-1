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
          backToMenu();
          break;
        case "2":
          NavigationMenu.handleMinMaxMedel(prices);
          backToMenu();
          break;
        case "3":
          NavigationMenu.handleSortPrices(prices);
          backToMenu();
          break;
        case "4":
          NavigationMenu.handleBestChargingHours(prices);
          backToMenu();
          break;
        case "5":
          prices = NavigationMenu.handleLoadingPricesFromFile();
          backToMenu();
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

  public static void backToMenu() {
    System.out.print("Tryck på ENTER för att återgå till menyn");
    Scanner wait = new Scanner(System.in);
    wait.nextLine();
  }
}