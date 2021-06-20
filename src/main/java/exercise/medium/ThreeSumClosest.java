package exercise.medium;

import java.util.Arrays;

/**
 * @Author tianchengming
 * @Date 2021年3月21日 19:11
 * @Version 1.0
 */
public class ThreeSumClosest {

    public static void main(String[] args) {

        SolutionError solution = new SolutionError();
        int[] nums = {-10,0,-2,3,-8,1,-10,8,-8,6,-7,0,-7,2,2,-5,-8,1,-4,6};
        solution.threeSumClosest(nums,18);
    }


}

/**
 * 边界有问题
 */
class SolutionError {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int approNum = target >= 0? Integer.MAX_VALUE : Integer.MIN_VALUE;
        for(int i=0; i < nums.length-2; i++){
            int start = i+1;
            int end = nums.length - 1;
            while(start < end){
                while(start < end && (start > i+1) && nums[start] == nums[start-1]){
                    start++;
                }
                while(start < end && (end < (nums.length-1)) && nums[end] == nums[end+1]){
                    end--;
                }
                //退出后 此时可能 start >= end 需要判断下
//                if(start >= end){
//                    break;
//                }
                int sum = nums[i]+nums[start]+nums[end];
                if(sum == target){
                    return target;
                }

                if(Math.abs(approNum - target) > Math.abs( sum- target)){
                    approNum = sum;
                }
                if(sum > target){
                    end--;
                }else{
                    start++;
                }
            }
        }
        return approNum;
    }
}



class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        //赋值要考虑 Math.abs(Integer.MAX_VALUE-(-1))  Math.abs(Integer.MIN_VALUE-0) 结果都是Integer.MIN_VALUE
        int approNum = target >= 0? Integer.MAX_VALUE : Integer.MIN_VALUE;
        for(int i=0; i < nums.length-2; i++){
            int start = i+1;
            int end = nums.length - 1;
            while(start < end){
                int sum = nums[i]+nums[start]+nums[end];
                if(sum == target){
                    return target;
                }
                //(start  要跳过开始，是指i,并不只是1
                if(start < end && (start > i+1) && nums[start] == nums[start-1]){
                    start++;
                    continue;
                }
                if(start < end && (end < (nums.length-1)) && nums[end] == nums[end+1]){
                    end--;
                    continue;
                }

                if(Math.abs(approNum - target) > Math.abs( sum- target)){
                    approNum = sum;
                }
                if(sum > target){
                    end--;
                }else{
                    start++;
                }
            }
        }
        return approNum;
    }

}
