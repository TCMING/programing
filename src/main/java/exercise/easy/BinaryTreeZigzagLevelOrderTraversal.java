package exercise.easy;

import exercise.definition.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author tianchengming
 * @Date 2020年12月22日 10:05
 * @Version 1.0
 */
public class BinaryTreeZigzagLevelOrderTraversal {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<TreeNode> treeNodeLeft = new ArrayList<TreeNode>();
        List<TreeNode> treeNodeRight = new ArrayList<TreeNode>();
        //true left-> right false  right->left
        treeNodeLeft.add(root);
        while(!treeNodeLeft.isEmpty() || !treeNodeRight.isEmpty()){
            List<Integer> values = new ArrayList<Integer>();
            if(!treeNodeLeft.isEmpty() ){
                for(int i=0; i < treeNodeLeft.size(); i++){
                    if(treeNodeLeft.get(i) != null){
                        values.add(treeNodeLeft.get(i).val);
                    }
                }
                for(int i=0; i < treeNodeLeft.size(); i++){
                    if(treeNodeLeft.get(i) != null){
                        treeNodeRight.add(treeNodeLeft.get(i).left);
                        treeNodeRight.add(treeNodeLeft.get(i).right);
                    }
                    if(i == treeNodeLeft.size()-1){
                        treeNodeLeft.clear();
                    }
                }
            }else {
                for(int i=treeNodeRight.size()-1;i >= 0; i--){
                    if(treeNodeRight.get(i) != null){
                        values.add(treeNodeRight.get(i).val);
                    }
                }
                for(int i=0; i < treeNodeRight.size(); i++){
                    if(treeNodeRight.get(i) != null){
                        treeNodeLeft.add(treeNodeRight.get(i).left);
                        treeNodeLeft.add(treeNodeRight.get(i).right);
                    }
                    if(i == treeNodeRight.size()-1){
                        treeNodeRight.clear();
                    }
                }
            }
            if(!values.isEmpty()){
                result.add(values);
            }
        }
        return result;
    }

}


