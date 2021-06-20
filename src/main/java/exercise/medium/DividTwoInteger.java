package exercise.medium;

/**
 * @Author tianchengming
 * @Date 2021年4月11日 21:35
 * @Version 1.0
 */
public class DividTwoInteger {
}


class Solution29 {
    public int divide(int dividend, int divisor) {
        boolean sign = (dividend > 0) ^ (divisor > 0);
        if(dividend > 0){
            dividend = -dividend;
        }
        if(divisor > 0){
            divisor = -divisor;
        }
        int result = 0;
        while(dividend <= divisor){
            int tempRes = -1;
            int tempDivisor = divisor;
            while(dividend <= (tempDivisor << 1)){
                if(dividend <= (Integer.MIN_VALUE >> 1)){
                    break;
                }
                tempRes = tempRes << 1;
                tempDivisor = tempDivisor << 1;
            }
            dividend -= tempDivisor;
            result += tempRes;
        }
        if(!sign){
            if(result <= Integer.MIN_VALUE){
                return  Integer.MAX_VALUE;
            }
            result = -result;
        }
        return result;
    }
}
