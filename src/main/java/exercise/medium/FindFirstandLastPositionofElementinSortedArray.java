package exercise.medium;

import java.util.Arrays;

/**
 * @Author tianchengming
 * @Date 2021年6月20日 17:38
 * @Version 1.0
 */
public class FindFirstandLastPositionofElementinSortedArray {
    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        int[] nums = {2,2};
        solution34.searchRange(nums,2);
    }
}

class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        Arrays.fill(res,-1);
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target == nums[mid]){
                int lowS = start ;
                int lowH = mid;
                while(lowS <= lowH){
                    int lowMid = lowS + (lowH - lowS) / 2;
                    if(target == nums[lowMid]){
                        if(lowMid > 0 && nums[lowMid-1] != target){
                            res[0] = lowMid;
                            break;
                        }else if(lowMid == 0){
                            res[0] = lowMid;
                            break;
                        }
                    }
                    if(target > nums[lowMid]){
                        lowS = lowMid + 1;
                    }else{
                        lowH = lowMid - 1;
                    }

                }
                int highS = mid;
                int highH = end;
                while(highS <= highH){
                    int highMid = highS + (highH - highS) / 2;
                    if(target == nums[highMid]){
                        if(highMid < nums.length-1 && nums[highMid+1] != target){
                            res[1] = highMid;
                            break;
                        }else if(highMid == nums.length-1){
                            res[1] = highMid;
                            break;
                        }
                    }
                    if(target < nums[highMid]){
                        highH = highMid - 1;
                    }else{
                        highS = highMid + 1;
                    }
                }
                break;
            }
            if(target < nums[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return res;
    }
}
