/**
 * Created by sujith.j on 06/04/16.
 */
public class MaxProfit4 {
    public int maxProfit(int k, int[] prices) {


        int length = prices.length;
        if (k >= length) {
            int sum = 0;
            for (int i = 1; i < length; i++) {
                if(prices[i] < prices[i-1]){
                    sum += prices[i] - prices[i-1];
                }
            }

        }

        if (length == 0)
            return 0;
        int[] profit = new int[length];
        int[] tempProfit;
        int tempMax;
        for (int i = 1; i <= k; i++) {
            tempProfit = new int[length];
            tempMax = -prices[0];
            for (int j = 1; j < length; j++) {
                tempProfit[j] = Math.max(tempProfit[j - 1], tempMax + prices[i]);
                if (profit[j] - prices[j] > tempMax)
                    tempMax = profit[j] - prices[j];
            }
            profit = tempProfit;

        }
        return profit[length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        int profit = (new MaxProfit4()).maxProfit(1, nums);
        System.out.println(profit);
    }


}
