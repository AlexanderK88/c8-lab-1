package se.domain.project;

public class MenuChoice4 {

  public static HourlyPrice[] findBestChargingHours(HourlyPrice[] prices) {
    if (prices == null || prices.length < 4 || Main.isEmptyOrInvalidPrices(prices)) {
      return null;
    }

    int k = 4;
    int min_sum = Integer.MAX_VALUE;
    int best_start_index = -1;

    for (int i = 0; i <= prices.length - k; i++) {
      int current_sum = 0;

      for (int j = 0; j < k; j++) {
        current_sum += prices[i + j].getPrice();
      }

      if (current_sum < min_sum) {
        min_sum = current_sum;
        best_start_index = i;
      }
    }

    HourlyPrice[] bestHours = new HourlyPrice[k];
    for (int j = 0; j < k; j++) {
      bestHours[j] = prices[best_start_index + j];
    }

    return bestHours;
  }
}
