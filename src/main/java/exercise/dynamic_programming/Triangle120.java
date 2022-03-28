package exercise.dynamic_programming;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/triangle/
 */
public class Triangle120 {

    public static void main(String[] args) {
        Triangle120 triangle120 = new Triangle120();
        List<List<Integer>> triangle = new LinkedList<List<Integer>>();
        List<Integer> layer1 = Arrays.asList(2);
        List<Integer> layer2 = Arrays.asList(3,4);
        List<Integer> layer3 = Arrays.asList(6,5,7);
        List<Integer> layer4 = Arrays.asList(4,1,8,3);
        triangle.add(layer1);
        triangle.add(layer2);
        triangle.add(layer3);
        triangle.add(layer4);

        int res = triangle120.minimumTotal1(triangle);
        System.out.println(res);
    }

    /**
     * 递归
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() <= 0){
            return 0;
        }
        List<Integer> numArrays = triangle.get(triangle.size()-1);
        if(numArrays.size() <= 0){
            return 0;
        }
        int sum = triangle.size() * 10000;
        for(int i=0 ; i< numArrays.size(); i++){
            int curSum = minimumTotal_recursion(triangle,numArrays.size()-1,i);
            sum = Math.min(sum,curSum);
        }
        return sum;
    }

    public int minimumTotal_recursion(List<List<Integer>> triangle,int layer,int index){
        if(layer < 0 || layer >= triangle.size()){
            return  10000;
        }
        List<Integer> numArrays = triangle.get(layer);
        if(index < 0 || index >= numArrays.size()){
            return 10000;
        }
        if(index == 0 && layer == 0){
            return numArrays.get(index);
        }
        int left = minimumTotal_recursion(triangle,layer-1,index-1);
        int right = minimumTotal_recursion(triangle,layer-1,index);

        return numArrays.get(index) + Math.min(left,right);
    }

    /**
     * 记忆化搜索
     * @param triangle
     */
    int[][] memo;
    public int minimumTotal2(List<List<Integer>> triangle) {
        int minNum = 10000;
        int lastIndex = triangle.size() - 1;
        if(lastIndex == 0){
            return triangle.get(lastIndex).get(0);
        }
        memo = new int[triangle.size()][triangle.size()];
        for(int i=0; i < memo.length; i++){
            Arrays.fill(memo[i],10001);
        }
        for(int i=0; i < triangle.get(lastIndex).size(); i++){
            int left = minimumTotal2_sub(triangle,lastIndex-1,i-1);
            int right = minimumTotal2_sub(triangle,lastIndex-1,i);
            minNum = Math.min(minNum,triangle.get(lastIndex).get(i) + Math.min(left,right));
        }
        return minNum;
    }

    public int minimumTotal2_sub(List<List<Integer>> triangle,int layer,int index){
        if(layer < 0 || index < 0){
            return 10000;
        }
        if(index >= triangle.get(layer).size()){
            return 10000;
        }
        if(memo[layer][index] != 10001){
            return memo[layer][index];
        }
        if(layer == 0 && index == 0){
            memo[layer][index]  =  triangle.get(layer).get(index);
            return memo[layer][index];
        }
        int left = minimumTotal2_sub(triangle,layer-1,index-1);
        int right = minimumTotal2_sub(triangle,layer-1,index);
        memo[layer][index] = Math.min(left,right ) + triangle.get(layer).get(index);
        return memo[layer][index];
    }

    /**
     * 动态规划
     * @param triangle
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int column = triangle.get(row-1).size();

        if(row == 1){
            return triangle.get(row-1).get(0);
        }

        int[][] dp = new int[row][column];
        for(int i=0; i < triangle.size(); i++){
            Arrays.fill(dp[i],10000000);
        }
        dp[0][0] = triangle.get(0).get(0);
        for(int i=1; i < triangle.size(); i++){
            for(int j=0; j < triangle.get(i).size(); j++){
                int left = Integer.MAX_VALUE;
                if(j > 0){
                    left = dp[i-1][j-1];
                }
                int right =  dp[i-1][j];
                dp[i][j] = triangle.get(i).get(j) + Math.min(left,right);
            }
        }
        int minNum = Integer.MAX_VALUE;
        for(int i=0; i < column; i++){
            minNum = Math.min(minNum,dp[row-1][i]);
        }
        return minNum;
    }





}
