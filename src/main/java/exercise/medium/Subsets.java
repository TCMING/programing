package exercise.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author tianchengming
 * @Date 2021年6月25日 20:41
 * @Version 1.0
 */
public class Subsets {

    public static void main(String[] args) {
        Solution78 solution78 = new Solution78();
        int[] nums = {1,2,3};
//        solution78.subsets(nums);
        System.out.println(1<<3);
//        Arrays.fill();
    }

}


class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList());
        for(int i=0; i < nums.length;i++){
            List<List<Integer>> tmp = new ArrayList<>();
            for(int j=0; j < result.size(); j++){
                List<Integer> copy = new ArrayList<>(result.get(j));
                tmp.add(copy);
            }
            result.addAll(tmp);
        }
        return result;
    }
}
