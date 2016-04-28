public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int nonZeroPointer = 0;
        while (nonZeroPointer < nums.length && nums[nonZeroPointer] != 0){
            nonZeroPointer++;
        }
        while (nonZeroPointer < nums.length && nums[nonZeroPointer] == 0){
            nonZeroPointer++;
        }
        for (int i = 0; i < nums.length; i++) {
            if(nonZeroPointer == nums.length ) {
                break;
            }
            if(nums[i] == 0) {
                swap(nums,i,nonZeroPointer);
                while (nonZeroPointer < nums.length && nums[nonZeroPointer] == 0){
                    nonZeroPointer++;
                }

            }
        }
    }

    public void swap(int []nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String []args) {
        int []nums = {0, 1, 0, 3, 12};
        (new MoveZeroes()).moveZeroes(nums);
        System.out.println("hold");

    }
}
