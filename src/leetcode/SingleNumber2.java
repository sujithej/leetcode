public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        int ones =0;
        int twos =0;
        int common = 0;
        for (int num : nums) {
            twos = twos |(num & ones );
            ones  = ones ^ num;
            common = ~(ones & twos);
            ones &= common;
            twos &= common;
        }
        return ones |twos;

    }
}
