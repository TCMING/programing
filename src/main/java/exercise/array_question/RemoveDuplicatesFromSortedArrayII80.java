package exercise.array_question;

public class RemoveDuplicatesFromSortedArrayII80 {

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length <= 0){
            return 0;
        }
        if(nums.length <= 2){
            return nums.length;
        }
        int l = 1, i = 2;
        while(i < nums.length){
            int value = nums[l] ^ nums[l-1] ^ nums[i];
            if(nums[i] != nums[l] || nums[i] != value){
                nums[++l] = nums[i++];
            }else{
                i++;
            }
        }
        return l+1;
    }

}
