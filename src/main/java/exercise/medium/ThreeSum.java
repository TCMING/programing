package exercise.medium;

import java.util.*;

/**
 * @Author tianchengming
 * @Date 2021年3月21日 17:47
 * @Version 1.0
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] num = {-1,0,1,2,-1,-4};
//        threeSum.threeSum(num);

        StringBuilder resString = new StringBuilder();
        resString.append(1).append(2).append(3);
        resString.toString().intern();
    }


}

/**
 * 利用排序+双指针
 */
class Solution2 {

    public List<List<Integer>> threeSum(int[] nums) {
        if( nums == null || nums.length < 2 ){
            return new ArrayList();
        }
//        System.out.printf(print);
        return null;
    }
}

/**
 * 利用set集合去重
 */
class Solution1 {
    //利用排序后+ 双指针再做一遍
    public List<List<Integer>> threeSum(int[] nums) {
        if( nums == null || nums.length == 0){
            return new ArrayList();
        }
        //初始化
        List<List<Integer>> res = new LinkedList<>();
        Set<String> deDuplication = new HashSet<>();
        for(int i=0; i < nums.length; i++){
            Set<Integer> temp = new HashSet<>();
            for(int j=i+1; j < nums.length; j++){
                if(temp.contains(-nums[i]-nums[j])){
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(-nums[i]-nums[j]);
                    int min = Math.min(Math.min(nums[i],nums[j]),-nums[i]-nums[j]);
                    int max = Math.max(Math.max(nums[i],nums[j]),-nums[i]-nums[j]);
                    StringBuilder resString = new StringBuilder();
                    resString.append(min).append(-min-max).append(max);
                    if(deDuplication.contains(resString.toString())){
                        continue;
                    }
                    deDuplication.add(resString.toString().intern());
                    res.add(list);
                }else{
                    temp.add(nums[j]);
                }

            }
        }
        return res;
    }
}
