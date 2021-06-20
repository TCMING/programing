package exercise.easy;

/**
 * @author chengming.tcm
 * @version 1.0
 * @date 2020/6/26 22:04
 */
public class RunningSumOfArray1480 {

    public int[] runningSum(int[] nums) {
        if(nums == null || nums.length == 0){
            return nums;
        }
        int[] result = new int[nums.length];
        //1.初始化
        result[0] = nums[0];
        //2.因为result[i-1]=sum(nums[0]```nums[i-1]),此时只需要加上当前nums[i]的值
        for(int i=1; i < nums.length; i++){
            result[i] = result[i-1] + nums[i];
        }
        return result;
    }
}
