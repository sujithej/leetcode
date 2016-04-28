/**
 * Created by sujith.j on 17/04/16.
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int []dp = new int [amount+1];
        int min;
        for(int i = 1 ;i <= amount;i++){
            min = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length ;j++){
                int tempIter = i - coins[j];
                if(tempIter >= 0 && dp[tempIter] != Integer.MAX_VALUE && dp[tempIter] +1 < min ){
                    min = dp[tempIter] +1;
                }
            }
            dp[i] = min;
        }
        if(dp[amount] == Integer.MAX_VALUE){
            return -1;
        }
        return dp[amount];
    }

    public static void main(String []args){
        int []coins  = {1,2,3,5};
        int min = (new CoinChange()).coinChange(coins,13);
        System.out.println(min);

    }

}
