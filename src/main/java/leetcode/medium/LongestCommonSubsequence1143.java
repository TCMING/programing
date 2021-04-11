package leetcode.medium;

/**
 * @Author tianchengming
 * @Date 2021年4月3日 18:23
 * @Version 1.0
 */
public class LongestCommonSubsequence1143 {
    public static void main(String[] args) {
        Solution1143 solution1143 = new Solution1143();
        System.out.println(solution1143.longestCommonSubsequence("abcde","ace"));
    }

}


class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        if((text1 == null || text1.length() <= 0)
                ||(text2 == null || text2.length() <= 0) ){
            return 0;
        }
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i=1; i <= text1.length();i++){
            for(int j=1; j <= text2.length(); j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = Math.max(dp[i-1][j-1] + 1,dp[i][j-1]+1);
                }else{
                    dp[i][j] = Math.max(dp[i-1][j-1],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];

    }
}
