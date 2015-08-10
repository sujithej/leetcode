package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 23/06/15
 * Time: 9:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class MxProfitII {
    public int maxProfit(int[] prices) {
        int totalProfit = 0;

        for(int i=0; i< prices.length -1 ; i++)
        {
            if(prices[i] < prices[i+1])
                totalProfit += prices[i+1] - prices[i];

        }
        return totalProfit;
    }
}
