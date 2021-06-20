package exercise.medium;

import java.util.*;

/**
 * @Author tianchengming
 * @Date 2021年3月21日 21:02
 * @Version 1.0
 */
public class LetterCombinationsOfPhoneNumber {

    public static void main(String[] args) {
        SolutionLetterCombinationsOfPhoneNumber solution = new SolutionLetterCombinationsOfPhoneNumber();
        List<String> res = solution.letterCombinations("22");
        System.out.println();
        List<Character> list = new ArrayList<Character>(Arrays.asList('(','{','['));
        Stack<String> stack = new Stack<>();
        stack.push("");

    }

}

/**
 *
 */


class SolutionLetterCombinationsOfPhoneNumber {

    private char[] chars  = new char[]{'a','b','c','d','e','f','g','h','i','g','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        List<List<Character>> map = new ArrayList<>();
        int sum = 1;
        for(int i=0; i < digits.length(); i++){
            List<Character> mapChar = new ArrayList<>();
            int cur = digits.charAt(i) - '1';
            if(cur <=5 ){
                for(int j=(cur-1)*3; j < cur*3; j++){
                    mapChar.add(chars[j]);
                }
            }else if(cur == 6){
                for(int j=15; j < 19; j++){
                    mapChar.add(chars[j]);
                }
            }else if(cur == 7){
                for(int j=19; j < 22; j++){
                    mapChar.add(chars[j]);
                }
            }else{
                for(int j=22; j < 26; j++){
                    mapChar.add(chars[j]);
                }
            }
            sum *= mapChar.size();
            map.add(mapChar);
        }
        if(sum == 1){
            return new ArrayList<>();
        }
        System.out.println(sum);
        List<StringBuilder> list1 = new ArrayList<>();
        List<StringBuilder> list2 = new ArrayList<>();
        for(int i=0; i < map.get(0).size(); i++){
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append(map.get(0).get(i));
            list1.add(strBuilder);
        }
        for(int i=1; i < map.size(); i++){
            if(list1.size() != 0){
                for(int j=0; j < map.get(i).size(); j++){
                    for(StringBuilder strB : list1){
                        StringBuilder temp = new StringBuilder(strB);
                        temp.append(map.get(i).get(j));
                        list2.add(temp);
                    }
                }
                list1.clear();
            }else{
                for(int j=0; j < map.get(i).size(); j++){
                    for(StringBuilder strB : list2){
                        StringBuilder temp = new StringBuilder(strB);
                        temp.append(map.get(i).get(j));
                        list1.add(temp);
                    }
                }
                list2.clear();
            }

        }
        List<String> res = new LinkedList<>();
        if(list1.size() != 0){
            for(StringBuilder str: list1){
                res.add(str.toString());
            }
        }else{
            for(StringBuilder str: list2){
                res.add(str.toString());
            }
        }
        return res;

    }
}

