package exercise.array_question;

public class SortColors75 {

    //计数排序
    public void sortColors1(int[] nums) {
        int[] count = new int[3];
        for(int i=0; i < nums.length; i++){
            assert (nums[i] >= 0 && nums[i] <= 2);
            count[nums[i]]++;
        }
        int cur = 0;
        for(int i=0; i < count.length; i++){
            for(int j = 0; j< count[i]; j++){
                nums[cur++] = i;
            }
        }
    }
    //三路快排
    public void sortColors(int[] nums) {
        //[0,l) 是0, [l,r] 是 1, (r,nums.length)是2
        int l = 0;
        int r = nums.length - 1;
        int i= l;
        while(i <= r){
            if(nums[i] == 0){
                swap(nums,l,i);
                l++;
                i++;
            }else if(nums[i] == 2){
                swap(nums,i,r);
                r--;
            }else{
                i++;
            }
        }
    }

    private void swap(int[] nums,int a,int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        SortColors75 sortColors75 = new SortColors75();
        int[] nums = {1,2,0};
        sortColors75.sortColors(nums);
    }

}
