package exercise.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[] {9,4,6,8,3,10,4,6};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public int[] sort(int[] nums){
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    public void quickSort(int[] nums,int l,int r){
        int position = nums[l];
        int start = l;
        int end = r;
        //注意终止条件
        if(l >= r){
            return ;
        }
        while(l < r){
            //目的是找到更小的,相等也要跳过
            while(l<r && nums[r] >= position){
                r--;
            }
            while(l<r && nums[l] <= position){
                l++;
            }
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
        nums[start] = nums[l];
        nums[l] = position;
        quickSort(nums,start,r-1);
        quickSort(nums,r+1,end);
    }

}
