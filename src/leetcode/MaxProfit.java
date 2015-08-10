package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: sujith.j
 * Date: 23/06/15
 * Time: 10:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;


        int localMin = prices[0];
        int maxProfit = 0;
        int localProfit = 0;

        for(int x:prices)
        {
            if(x < localMin)
                localMin = x;
            localProfit = x - localMin;
            if(localProfit > maxProfit)
                maxProfit = localProfit;
        }

        return maxProfit;


    }
}
