package exercise.medium;

import exercise.definition.TreeNode;

/**
 * @Author tianchengming
 * @Date 2021年6月26日 23:08
 * @Version 1.0
 */
public class ConstructBinaryTree105 {

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        Solution105 solution105 = new Solution105();
        solution105.buildTree(preorder,inorder);
    }
}


class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder== null || preorder.length <=0 || preorder.length != inorder.length){
            return null;
        }
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder,int prel,int prer, int[] inorder,int inl,int inr){
        TreeNode node = new TreeNode(preorder[prel]);
        int leftNum = 0;
        int rightNum = 0;
        int i= inl;
        for(; i <= inr; i++){
            if(inorder[i] == preorder[prel]){
                leftNum = i - inl;
                rightNum = inr - i;
                break;
            }
        }
        if(leftNum > 0){
            node.left = buildTree(preorder,prel+1,prel+leftNum,inorder,inl,i-1);
        }else{
            node.left = null;
        }
        if(rightNum > 0){
            node.left = buildTree(preorder,prel+leftNum+1,prer,inorder,i+1,inr);
        }else{
            node.right = null;
        }
        return node;
    }

}
