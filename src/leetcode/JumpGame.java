/**
 * Created by sujith.j on 26/10/15.
 */
public class JumpGame {
    public static void main(String []args)
    {
        int []nums = {3,2,1,1,4};
        System.out.println((new JumpGame()).canJump(nums));



    }

    public boolean canJump(int[] nums) {
//        int []maxJump = new int[nums.length];
        int max;
        max = nums[0];
        int length = nums.length;
        if(max <= 0 && length > 1 ) {
            return false;
        }
        for (int i=1;i< length;i++) {
            max = Math.max(max-1,nums[i]);
            if(max == 0)
                return false;
            if(max+i >= length-1)
                return true;
        }

        return true;
    }

}
