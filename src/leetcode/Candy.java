public class Candy {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;
        int length = ratings.length;
        int candies[] = new int[length];
        candies[0] = 1;
        for (int i = 1; i < candies.length; i++) {
            if (ratings[i] > ratings[i - 1])
                candies[i] = 1 + candies[i - 1];
            else
                candies[i] = 1;
        }

        int curr = 1;
        int total = candies[length-1];
        for (int i = length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i+1])
                curr += 1;
            else
                curr =1;
            total += Math.max(curr,candies[i]);
        }
        return total;
    }
}
