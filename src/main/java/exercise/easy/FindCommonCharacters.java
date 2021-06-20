package exercise.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengming.tcm
 * @version 1.0
 * @date 2020/10/14 23:21
 */
public class FindCommonCharacters {

    public static void main(String[] args) {
        FindCommonCharacters comString = new FindCommonCharacters();

        System.out.println(comString.commonChars(new String[]{"bella","label","roller"}));
    }

    public List<String> commonChars(String[] A) {
        String res = A[0];
        for(int i=1; i < A.length; i++){
            res = comString(res,A[i]);
        }
        List<String> resList = new ArrayList<String>();
        for(int i=0; i < res.length(); i++){
            resList.add(res.charAt(i)+"");
        }
        return resList;
    }

    public String comString(String first,String second){
        int[] array = new int[26];
        for(int i=0; i < first.length(); i++){

            array[first.charAt(i)-'a']++;
        }
        StringBuilder res = new StringBuilder();
        for(int i=0; i< second.length(); i++){
            int index = second.charAt(i)-'a';
            if(array[index] > 0){
                res.append((char)('a'+index));
                array[index]--;
            }
        }
        return res.toString();
    }
}


