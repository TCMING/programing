package leetcode.input;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 10
 * 2 3 5
 * 2 3 5 6 7
 * @Author tianchengming
 * @Date 2021年4月6日 21:06
 * @Version 1.0
 */
public class StringInput {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        String lengthStr = in.nextLine();
        String jumpInfo  = in.nextLine();
        String stoneInfo = in.nextLine();
        int    length    = Integer.parseInt(lengthStr);

        String[] jumpInfos  = jumpInfo.split(" ");
        int      minJump    = Integer.parseInt(jumpInfos[0]);
        int      maxJump    = Integer.parseInt(jumpInfos[1]);
        int      stoneLen   = Integer.parseInt(jumpInfos[2]);
        String[] stoneInfos = stoneInfo.split(" ");
        if (stoneInfos.length == stoneLen) {
            int[] stones = new int[stoneLen];
            for(int i=0; i < stoneLen; i++ ){
                stones[i] = Integer.parseInt(stoneInfos[i]);
            }
            System.out.println(jump(stones, minJump, maxJump, length));
        }

    }
    public static int jump(int[] stones,int minJump,int maxJump,int length){
        Arrays.sort(stones);
        minJump++;
        maxJump++;
        if(length <= maxJump){
            return Integer.MAX_VALUE;
        }
        if(maxJump < stones[0]){
            return Integer.MAX_VALUE;
        }
        if(maxJump+stones[stones.length-1] < length){
            return Integer.MAX_VALUE;
        }

        int[] dp = new int[101];
//        Arrays.fill(dp, Integer.MAX_VALUE);

        for(int i=0; i < stones.length; i++){
            if(stones[i] <= maxJump){
                dp[stones[i]] = 1;
                continue;
            }
            int max = dp[stones[i-1]];
            for(int j=stones[i-1]-1; j >= (stones[i]-maxJump); j--){
                if(dp[j] != 0){
                    max = Math.min(max,dp[j]);
                }
            }
            dp[stones[i]] = max+1;
        }

        int finalMax = dp[stones[stones.length-1]];
        for(int j=length-1; j >= (length-maxJump); j--){
            if(dp[j] != 0){
                finalMax = Math.min(finalMax,dp[j]);
            }
        }
        return finalMax;
    }
}
