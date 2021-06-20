package exercise.easy;

/**
 * @Author tianchengming
 * @Date 2020年12月21日 10:23
 * @Version 1.0
 */
public class MinCostClimbingStairs {


    public static void main(String[] args) {
        MinCostClimbingStairs solution = new MinCostClimbingStairs();
        int[] cost = {1,100,1,100,1,100,1,100};
        System.out.println(solution.minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        if(cost == null || cost.length <= 1){
            return 0;
        }
        int[] sumCost = new int[cost.length];
        sumCost[0] = cost[0];
        sumCost[1] = cost[1];
        for(int i=2; i < cost.length; i++){
            sumCost[i] = Math.min(sumCost[i-1]+cost[i],sumCost[i-2]+cost[i]);
        }
        return sumCost[cost.length-1];
    }
}
