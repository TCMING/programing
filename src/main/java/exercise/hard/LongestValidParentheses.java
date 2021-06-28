package exercise.hard;

import java.util.Stack;

/**
 * @Author tianchengming
 * @Date 2021年6月20日 14:57
 * @Version 1.0
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        Solution32 solution32 = new Solution32();
        int res = solution32.longestValidParentheses("(())");
        System.out.println(res);
    }
}


class Solution32 {
    /**
     * 思路不对，有些‘(’ 是用不上的
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if(s == null || s.length() <= 1){
            return 0;
        }
        Stack<Character> stack    = new Stack<>();
        int              validLen = 0;
        int maxValidLen = 0;
        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ')'){
                if(stack.size() > 0){
                    char stackChar = stack.pop();
                    validLen+=2;
                }else{
                    maxValidLen = Math.max(validLen,maxValidLen);
                    validLen = 0;
                    stack.clear();
                }
            }else{
                stack.push(c);
            }
        }
        return Math.max(maxValidLen,validLen);
    }

    /**
     * 不直接保留 ‘(’，而是保留 坐标
     */
    class Solution {
        public int longestValidParentheses(String s) {
            if(s == null || s.length() <= 1){
                return 0;
            }
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            int maxValidLen = 0;
            for(int i=0; i < s.length(); i++){
                char c = s.charAt(i);
                if(c == ')'){
                    stack.pop();
                    if(stack.size() > 0){
                        int head = stack.peek();
                        maxValidLen = Math.max(maxValidLen,i-head);
                    }else{
                        stack.push(i);
                    }
                }else{
                    stack.push(i);
                }
            }
            return maxValidLen;
        }
    }

    /**
     * 动态规划
     */

}
