package exercise.array_question;

import java.util.Random;

public class KthLargestElementInArray215 {

    public static void main(String[] args) {
        KthLargestElementInArray215 test = new KthLargestElementInArray215();
        int[] nums = {3,2,1,5,6,4};

        System.out.println(test.findKthLargest(nums,2));
    }

    /**
     * 基于快排
     */
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums,0,nums.length-1, nums.length - k);
    }

    public int quickSelect(int[] nums,int l,int r,int index){
        int cur = randomPartition(nums,l,r);
        if(cur == index){
            return nums[cur];
        }
        if(cur < index){
            return quickSelect(nums,cur+1,r,index);
        }else{
            return quickSelect(nums,l,cur-1,index);
        }
    }

    Random random = new Random();

    public int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    public int partition(int[] nums,int l,int r){
        int part = nums[l];
        int last = l;
        for(int i=l + 1; i <= r; i++){
            if(nums[i] < part){
                swap(nums,i,++last);
            }
        }
        swap(nums,l,last);
        return last;
    }


    /**
     * 基于堆排序
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {
        buildDump(nums,k);
        for(int i=k; i < nums.length; i++){
            if(nums[i] > nums[0]){
                swap(nums,0,i);
                adjustDump(nums,k,0);
            }
        }
        return  nums[0];
    }

    public void buildDump(int[] nums,int k){
        for(int i= k/2 - 1; i>= 0; i--){
            adjustDump(nums,k,i);
        }
    }

    public void adjustDump(int[] nums,int len,int index){
        // 堆数组长度 [0,len)
        int minPos = index;
        while(true){
            int l = 2 * index + 1;
            int r = 2 * index + 2;
            if (l < len && nums[l] < nums[minPos]) {
                minPos = l;
            }
            if (r < len && nums[r] < nums[minPos]) {
                minPos = r;
            }
            if (minPos == index) {
                break;
            }
            swap(nums,index,minPos);
            index = minPos;
        }
    }

    public void swap(int[] nums,int m,int n){
        int tmp = nums[m];
        nums[m] = nums[n];
        nums[n] = tmp;
    }

}
