package se.domain.project.menuchoices;

import se.domain.project.HourlyPrice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MenuChoice5 {

  public static HourlyPrice[] loadPricesFromFile() {
    String file = "src/main/resources/elpriser.csv";
    HourlyPrice[] prices = new HourlyPrice[24];
    int i = 0;

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      reader.readLine();

      String line;
      while ((line = reader.readLine()) != null && i < prices.length) {
        String[] row = line.split(",");

        if (row.length == 2) {
          try {
            String time = row[0].trim();
            int price = Integer.parseInt(row[1].trim());
            prices[i] = new HourlyPrice(time, price);
            i++;
          } catch (NumberFormatException e) {
            System.out.println("Det är något fel med prisformatet.");
            return new HourlyPrice[0];
          }
        } else {
          System.out.println("Det är något fel med dataformatet.");
          return new HourlyPrice[0];
        }
      }
    } catch (IOException e) {
      System.out.println("Fel vid läsning av fil: " + e.getMessage());
      return new HourlyPrice[0];
    }

    return prices;
  }
}