package exercise.easy;


import exercise.definition.TreeNode;


/**
 * @author chengming.tcm
 * @version 1.0
 * @date 2020/7/3 13:42
 */
public class SortedArrayToBST108 {

    public static void main(String[] args) {
        SortedArrayToBST108 sortedArrayToBST = new SortedArrayToBST108();
        System.out.println(sortedArrayToBST.sortedArrayToBST(new int[]{-10,-3,0,4,5}));
    }


//执行结果：通过 显示详情 显示详情
//执行用时：0 ms, 在所有 Java 提交中击败了100.00%
//内存消耗：39.6 MB, 在所有 Java 提交中击败了8.70%

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        return subArrayToBST(nums,0,nums.length-1);
    }

    private TreeNode subArrayToBST(int[] nums,int start,int end){
        if(start > end){
            return null;
        }
        if(start == end){
            return new TreeNode(nums[start]);
        }
        int mid = (start + end)/2;
        TreeNode midTreeNode = new TreeNode(nums[mid]);
        midTreeNode.left = subArrayToBST(nums,start,mid-1);
        midTreeNode.right = subArrayToBST(nums,mid+1,end);
        return midTreeNode;
    }
}
