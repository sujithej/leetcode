/**
 * Created by sujith.j on 06/04/16.
 */
public class MaxProfit3 {
    public int maxProfit(int[] prices) {

        int length = prices.length;
        if(length == 0)
            return 0;
        int[] profit1 = new int[length];
        int[] profit2 = new int[length];
        int min=prices[0];
        int max = prices[length -1];
        int maxProfit = 0;
        for (int i = 0; i < length; i++) {
            if(prices[i] < min)
                min = prices[i];
            maxProfit = Math.max(maxProfit,prices[i] - min);
            profit1[i] = maxProfit;
        }
        maxProfit = 0;
        for(int i= length -1; i>=0;i--){
            if(prices[i] > max)
                max = prices[i];
            maxProfit = Math.max(maxProfit,max - prices[i]);
            profit2[i] = maxProfit;
        }
        maxProfit = profit1[0] + profit2[0];
        for(int i=0 ; i<length ;i++)
            maxProfit = Math.max(maxProfit,profit1[i] + profit2[i]);
        return maxProfit;
    }
}
