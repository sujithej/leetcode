/**
 * Created by sujith.j on 20/04/16.
 */
public class JumpGame2 {
    public int jump(int[] nums) {
        int length = nums.length;
        int[] counts = new int[length];
        for (int i = 0; i < length; i++) {
            counts[i] = Integer.MAX_VALUE;
        }
        counts[0] = 0;
        for(int i = 0 ; i < length ; i++){
            for(int j = Math.min(nums[i],length - 1 - i) ; j > 0  ; j--){
                if(counts[i] + 1 < counts[i+j]) {
                    counts[i+j] = counts[i] + 1;
                } else {
                    break;
                }

            }

        }
        return counts[length -1];
    }

    public  static void main(String []args) {
        int []arr = {2,2,1,1,4};
        int count = (new JumpGame2()).jump(arr);
        System.out.println(count);
    }
}
