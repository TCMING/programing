package exercise.array_question;

public class RemoveElement27 {

    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length <= 0){
            return 0;
        }
        //最终返回结果范围 (-1,k]
        int j = nums.length;
        for(int i=0; i < j;){
            if(nums[i] != val){
                i++;
            }else{
                nums[i] = nums[j-1];
                nums[j-1] = val;
                j--;
            }
        }
        return j;
    }

}
