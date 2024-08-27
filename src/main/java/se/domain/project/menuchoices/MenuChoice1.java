package se.domain.project.menuchoices;

import se.domain.project.HourlyPrice;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class MenuChoice1 {
  public static HourlyPrice[] electricPriceInput() {
    Scanner sc = new Scanner(System.in);
    HourlyPrice[] prices = new HourlyPrice[24];
    String[] TIME_INTERVALS = {
            "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00",
            "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00",
            "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"
    };

    String stringInputRandomData;
    while (true) {
      System.out.println("Vill du ange priser själv? J/N: ");
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
        System.out.println("Pris klockan " + TIME_INTERVALS[i] + " satt till: " + prices[i].getPrice() + " öre per kWh");
      }
    }

    return prices;
  }
}