package exercise.recruitment;

/**
 * 题目描述：一个链表，奇数位升序偶数位降序，让链表变成升序的。
 *
 * 比如：1 8 3 6 5 4 7 2 9，最后输出1 2 3 4 5 6 7 8 9。
 *
 * @Author tianchengming
 * @Date 2021年6月20日 12:27
 * @Version 1.0
 */
public class ListSort {

    public static void main(String[] args) {
        ListSort listSort = new ListSort();
        int[] array = {1,8,3,6,5,4,7,2,9};
        int[] result = listSort.sort(array);
        for(int i=0; i < result.length; i++){
            System.out.print(result[i]+" ");
        }
    }
    public int[] sort(int[] array){
        if(array == null || array.length <= 1){
            return array;
        }
        int[] result = new int[array.length];
        int odd = 0;  //升序
        int even = 0;
        if(array.length %2 == 1){
            even = array.length - 2;
        }else{
            even = array.length - 1;
        }
        int i = 0;
        while(odd < array.length && even >= 0){
            if(array[odd] <= array[even]){
                result[i] = array[odd];
                odd += 2;
            }else{
                result[i] = array[even];
                even -= 2;
            }
            if(i < array.length-1){
                i++;
            }
        }
        while(odd < array.length){
            result[i] = array[odd];
            odd+=2;
            if(i < array.length-1){
                i++;
            }
        }
        while(even >= 0){
            result[i] = array[even];
            even-=2;
            if(i < array.length-1){
                i++;
            }
        }
        return result;
    }

}
