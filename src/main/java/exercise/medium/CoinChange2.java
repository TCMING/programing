package exercise.medium;

/**
 * @Author tianchengming
 * @Date 2021年6月10日 20:58
 * @Version 1.0
 */
public class CoinChange2 {

    public static void main(String[] args) {
        Solution518 solution518 = new Solution518();
        int[] num = {1,2,5};
        System.out.println(solution518.change(5,num));
    }

}



class Solution518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        for(int i=1; i <= amount; i++){
            for(int j=0; j < coins.length; j++){
                if(i - coins[j] >= 0){
                    dp[i] += dp[i-coins[j]] + 1;
                }else{
                    break;
                }
            }
        }
        return dp[amount];
    }
}
