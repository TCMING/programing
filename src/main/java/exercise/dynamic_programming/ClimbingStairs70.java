package exercise.dynamic_programming;

/**
 * 该题目与斐波那契数列一致，不再写
 */
public class ClimbingStairs70 {

    /**
     * 递归
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n < 1 || n > 45){
            throw new RuntimeException("Invalid Param");
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }


}
