package exercise.array_string;

public class MergeSortedArray88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //最终结果位于 [0,end]
        int res = m+n, l1 = m-1, l2 = n-1;
        while( l1 >=0  && l2 >= 0){
            if(nums1[l1] <= nums2[l2]){
                nums1[--res] = nums2[l2--];
            }else{
                nums1[--res] = nums1[l1--];
            }
        }
        while(l2 < n) {
            nums1[--res] = nums2[l2--];
        }
    }

}
