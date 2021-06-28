package exercise.medium;

/**
 * @Author tianchengming
 * @Date 2021年6月23日 22:01
 * @Version 1.0
 */
public class JumpGame {

    public static void main(String[] args) {
        Solution55 solution55 = new Solution55();
        int[] nums = {3,0};
        System.out.println(solution55.canJump(nums));
    }

}


class Solution55 {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length <= 1){
            return true;
        }
        //总是记录从当前往后跳的最远距离
        int step = nums[0];
        for(int i=1;i < nums.length;i++){
            if(step > 0){
                step--;
                step = Math.max(step,nums[i]);
                if(i == nums.length-1){
                    return true;
                }
            }else{
                break;
            }
        }
        return false;
    }
}
