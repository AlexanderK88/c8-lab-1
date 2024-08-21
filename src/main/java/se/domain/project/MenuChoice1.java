package se.domain.project;

import java.util.Scanner;

public class MenuChoice1 {
  public static HourlyPrice[] electricPriceInput() {
    Scanner sc = new Scanner(System.in);
    HourlyPrice[] prices = new HourlyPrice[2];
    String[] TIME_INTERVALS = {
            "00-01", "01-02", "02-03", "03-04", "04-05", "05-06", "06-07", "07-08",
            "08-09", "09-10", "10-11", "11-12", "12-13", "13-14", "14-15", "15-16",
            "16-17", "17-18", "18-19", "19-20", "20-21", "21-22", "22-23", "23-00"
    };

    System.out.println("Välj elpriser för kommande 24 timmar");

    for (int i = 0; i < prices.length; i++) {
      System.out.print("Ange priset för " + TIME_INTERVALS[i] + ": ");
      int userInput = sc.nextInt();
      prices[i] = new HourlyPrice(TIME_INTERVALS[i], userInput);
    }
    return prices;
  }
}
