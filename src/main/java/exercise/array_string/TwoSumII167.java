package exercise.array_string;

public class TwoSumII167 {
    //暴力解法
    public int[] twoSum1(int[] numbers, int target) {
        int[] res = new int[2];
        for(int i=0; i < numbers.length; i++){
            for(int j=0; j < numbers.length; j++){
                if(j != i && numbers[i] + numbers[j] == target){
                    res[0] = i+1;
                    res[1] = j+1;
                    return res;
                }
            }
        }
        throw new IllegalArgumentException();
    }

    //二分搜索法  可解决十万，百万
    public int[] twoSum2(int[] numbers, int target) {
        int[] res = new int[2];
        for(int i=0; i < numbers.length; i++){
            int left = target - numbers[i];
            int l = 0, r = numbers.length-1;
            while(l <= r){
                int mid = l + (r - l)/2;
                if(mid != i && left == numbers[mid]){
                    res[0] = i+1;
                    res[1] = mid+1;
                    return res;
                }
                if(numbers[mid] > left){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
        }
        throw new IllegalArgumentException();
    }


    //对撞指针
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for(int i=0,j=numbers.length-1; i <= j; ){
            if(numbers[i] + numbers[j] == target){
                res[0] = i+1;
                res[1] = j+1;
                return res;
            }else if(numbers[i] + numbers[j] > target){
                j--;
            }else{
                i++;
            }
        }
        throw new IllegalArgumentException();
    }

}
