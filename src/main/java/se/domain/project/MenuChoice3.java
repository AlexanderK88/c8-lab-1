package se.domain.project;

public class MenuChoice3 {

  public static HourlyPrice[] sortPrices(HourlyPrice[] prices) {
    if (prices == null || prices.length == 0 || Main.isEmptyOrInvalidPrices(prices)) {
      return null;
    }

    boolean swapsOccurred;

    for (int i = 0; i < prices.length - 1; i++) {
      swapsOccurred = false;

      for (int j = 0; j < prices.length - i - 1; j++) {
        if (prices[j] != null && prices[j + 1] != null) {
          if (prices[j].getPrice() > prices[j + 1].getPrice()) {
            HourlyPrice temp = prices[j];
            prices[j] = prices[j + 1];
            prices[j + 1] = temp;
            swapsOccurred = true;
          }
        }
      }

      if (!swapsOccurred) {
        break;
      }
    }

    return prices;
  }

}