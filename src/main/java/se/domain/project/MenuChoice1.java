package se.domain.project;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class MenuChoice1 {
  public static HourlyPrice[] electricPriceInput() {
    Scanner sc = new Scanner(System.in);
    HourlyPrice[] prices = new HourlyPrice[24];
    String[] TIME_INTERVALS = {
            "00-01", "01-02", "02-03", "03-04", "04-05", "05-06", "06-07", "07-08",
            "08-09", "09-10", "10-11", "11-12", "12-13", "13-14", "14-15", "15-16",
            "16-17", "17-18", "18-19", "19-20", "20-21", "21-22", "22-23", "23-00"
    };

    String stringInputRandomData;
    while (true) {
      System.out.println("Vill du ange priser priser själv? J/N: ");
      stringInputRandomData = sc.nextLine().toUpperCase();

      if (stringInputRandomData.equals("J") || stringInputRandomData.equals("N")) {
        break;
      } else {
        System.out.println("Ogiltigt input, ange J för att mata in priser eller N för att använda exempel data.");
      }
    }

    if (stringInputRandomData.equals("J")) {
      System.out.println("Välj elpriser för kommande 24 timmar");

      for (int i = 0; i < prices.length; i++) {
        while (true) {
          System.out.print("Ange priset för " + TIME_INTERVALS[i] + ": ");
          String stringInputPrice = sc.next();

          if (stringInputPrice.matches("^[1-9]\\d*$")) {
            int userInputPrice = Integer.parseInt(stringInputPrice);
            prices[i] = new HourlyPrice(TIME_INTERVALS[i], userInputPrice);
            break;
          } else {
            System.out.println("Ogiltigt input, ange ett positivt heltal som inte börjar med noll.");
          }
        }
      }
    } else {
      for (int i = 0; i < prices.length; i++) {
        int randomNumber = ThreadLocalRandom.current().nextInt(1, 101);
        prices[i] = new HourlyPrice(TIME_INTERVALS[i], randomNumber);
        System.out.println("Pris för " + TIME_INTERVALS[i] + ": " + prices[i].getPrice() + " öre per kWh");
      }
    }
    return prices;
  }
}
