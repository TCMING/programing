package exercise.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author tianchengming
 * @Date 2021年6月27日 12:39
 * @Version 1.0
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        Solution128 solution128 = new Solution128();
        int[] nums = {100,4,200,1,3,2};
        System.out.println(solution128.longestConsecutive(nums));
    }
}


class Solution128 {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i < nums.length; i++){
            int count = map.getOrDefault(nums[i]-1,0);
            map.put(nums[i],count + 1);
            int key = nums[i]+1;
            int value = map.getOrDefault(key,0);
            int lastValue = count+1;
            while(value != 0){
                map.put(key,value + lastValue);
                lastValue += value;
                value = map.getOrDefault(++key,0);
            }
        }
        int consecutive = 0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            consecutive = Math.max(consecutive,entry.getValue());
        }
        return consecutive;
    }
}
