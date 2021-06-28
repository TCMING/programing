package exercise.hard;

/**
 * @Author tianchengming
 * @Date 2021年6月20日 21:54
 * @Version 1.0
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution42.trap(height));
    }

}


class Solution42 {
    public int trap(int[] height) {
        if(height == null  || height.length <= 2){
            return 0;
        }
        int start = 0;
        int end = height.length - 1;
        int lH = height[start];
        int rH = height[end];
        int water = Math.min(lH,rH) * (end - start - 1) - countBar(height,start,end,Math.min(lH,rH));
        boolean flag = true;
        while(start < end){
            int tempLH = lH;
            int tempRH = rH;
            if(flag){
                while(++start < end){
                    if(height[start] > tempLH){
                        tempLH = height[start];
                        break;
                    }
                }
                flag = false;
            }else{
                while(start < --end){
                    if(height[end] > tempRH){
                        tempRH = height[end];
                        break;
                    }
                }
                flag = true;
            }
            water = water + (Math.min(tempLH,tempRH) - Math.min(lH,rH)) * (end - start - 1)
                    - countBar(height,start,end,Math.min(tempLH,tempRH)) + countBar(height,start,end,Math.min(rH,lH));
            lH = tempLH;
            rH = tempRH;
        }
        return water;

    }

    public int countBar(int[] height,int start ,int end,int h){
        int bars = 0;
        for(int i = start+1; i < end; i++){
            int bar = Math.min(height[i],h);
            bars += bar;
        }
        return bars;
    }
}
