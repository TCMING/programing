package exercise.medium;

/**
 * @Author tianchengming
 * @Date 2021年4月11日 21:13
 * @Version 1.0
 */
public class UglyNumberII {

    public static void main(String[] args) {
        Solution264 solution264 = new Solution264();
        solution264.nthUglyNumber(10);
    }
}

/**
 * 注意，如果 dp[p2]*2 与 dp[p3]*3相同，都要递增
 */
class Solution264 {
    public int nthUglyNumber(int n) {
        if(n <= 6){
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        for(int i=2; i <= n; i++){
            dp[i] = dp[p2]*2;
            dp[i] = Math.min(dp[i],dp[p3]*3);
            dp[i] = Math.min(dp[i],dp[p5]*5);
            if(dp[i] == dp[p2]*2){
                p2++;
            }
            if(dp[i] == dp[p3]*3){
                p3++;
            }
            if(dp[i] == dp[p5]*5){
                p5++;
            }
        }
        return dp[n];
    }
}
