package exercise.array_string;

public class RemoveDuplicatesFromSortedArray26 {

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length <= 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        int l = 0, i = 1;
        while(i < nums.length){
            if(nums[i] != nums[l]){
                nums[++l] = nums[i++];
            }else{
                i++;
            }
        }
        return l+1;
    }

}
