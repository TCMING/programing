package exercise.array_string;

public class MinimumSizeSubarraySum209 {

    //暴力解法 o(n^3)

    //优化 o(n^2)

    //优化 o(n)

    public int minSubArrayLen(int target, int[] nums) {

        //sum 是(start,end]区间的数值总和
        int l=0,r=-1;
        int sum = 0;
        int len = nums.length + 1;
        while(l < nums.length){
            if( r+ 1 < nums.length && sum < target ){
                sum += nums[++r];
            }else {
                sum -= nums[l++];
            }
            if(sum >= target){
                len = Math.min(len,r-l+1);
            }
        }
        if(len == nums.length+1){
            return 0;
        }
        return len;
    }

    public static void main(String[] args) {
        // 7
        //[2,3,1,2,4,3]
    }

}
