package exercise.easy;

/**
 * @author chengming.tcm
 * @version 1.0
 * @date 2020/6/28 23:47
 */
public class MinSizeSubarraySum209 {

    public static void main(String[] args) {
        MinSizeSubarraySum209 minSize = new MinSizeSubarraySum209();
        System.out.println(minSize.minSubArrayLen(7, new int[] {2, 1, 3, 2, 4, 3}));
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = 0;
        int min = nums.length;
        int sum = 0;
        int ahead = 0;
        int after = 0;
        boolean flag = false;
        while (ahead < nums.length || after < nums.length) {
            if (sum < s) {
                if (ahead < nums.length) {
                    sum += nums[ahead++];
                    len++;

                } else if (after < nums.length) {
                    sum -= nums[after++];
                    len--;
                }
            } else {
                if (len < min) {
                    min = len;
                }
                flag = true;
                sum -= nums[after++];
                len--;
            }
        }
        return flag ? min : 0;
    }
}
