package exercise.dynamic_programming;

import java.util.Arrays;


/**
 * 斐波那契数列 https://leetcode-cn.com/problems/fibonacci-number/
 */
public class FibonacciNumber509 {

    //递归
    public int fib1(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fib1(n-1) + fib1(n-2);
    }


    //记忆化搜索
    int[] memo;
    public int fib2(int n) {
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        memo = new int[n+1];
        Arrays.fill(memo,-1);
        memo[0] = 0;
        memo[1] = 1;
        return fib2_sub(n-1) + fib2_sub(n-2);
    }

    public int fib2_sub(int n){
        if(memo[n] == -1){
            memo[n] = fib2_sub(n-1) + fib2_sub(n-2);
        }
        return memo[n];
    }

    //动态规划
    public int fib3(int n) {
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2 ;i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

}
