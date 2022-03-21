import org.junit.Test;

import java.util.Arrays;

public class ArraysSort {

    @Test
    public void sort(){
        int[] array = new int[]{3,2,1,4};
        print("排序前",array);
        Arrays.sort(array);
        print("排序后",array);
    }

    private void print(String msg,int[] array){
        System.out.println(msg);
        for(int i : array){
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
