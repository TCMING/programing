package leetcode.easy;

/**
 * @author chengming.tcm
 * @version 1.0
 * @date 2020/10/12 0:33
 */
public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        PartitionEqualSubsetSum equalSubsetSum = new PartitionEqualSubsetSum();
        equalSubsetSum.canPartition(new int[]{3,3,3,4,5});

    }
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length <= 1){
            return false;
        }
        int length= nums.length;
        int sum = 0;
        for(int i=0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum % 2 == 1){
            return false;
        }
        int target = sum/2;
        boolean[][] dp = new boolean[length][target+1];
        dp[0][nums[0]] = true;
        for(int i=1; i < length; i++){
            dp[i][nums[i]] = true;
            for(int j=0; j<= target; j++){
                dp[i][j] = dp[i-1][j];
                if(dp[i][j] && ((j+nums[i]) <= target)){
                    dp[i][j+nums[i]] = true;
                }
            }
        }
        return dp[length-1][target];
    }
}

