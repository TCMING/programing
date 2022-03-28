import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArraysSort {

    @Test
    public void sort(){
        int[] array = new int[]{3,2,1,4};
        print("排序前",array);
        Arrays.sort(array);
        print("排序后",array);
    }

    @Test
    public void arraystream(){
        int[] array = new int[]{3,2,1,4};
        System.out.println("arraySum = " + Arrays.stream(array).sum());
        //测试list
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        ;

    }

    private void print(String msg,int[] array){
        System.out.println(msg);
        for(int i : array){
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
