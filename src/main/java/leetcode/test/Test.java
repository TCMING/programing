package leetcode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author tianchengming
 * @Date 2020年9月1日 23:03
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(3);
        list.add(6);
        String tmp = FastJsonUtils.parseToString(list);
        System.out.println(tmp);
        try {
            FastJsonUtils.stringToList(tmp,Integer.class);
        }catch (Exception e){

        }



    }
}
