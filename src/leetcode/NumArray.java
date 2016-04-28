public class NumArray {
    int[] cumulativeSum;

    public NumArray(int[] nums) {
        cumulativeSum = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            cumulativeSum[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        if(i ==0) {
            return cumulativeSum[j];
        }
        else {
            return cumulativeSum[j] - cumulativeSum[i-1];
        }
    }
}
