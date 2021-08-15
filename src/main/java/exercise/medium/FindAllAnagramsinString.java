package exercise.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author tianchengming
 * @Date 2021年7月4日 21:40
 * @Version 1.0
 */
public class FindAllAnagramsinString {

    public static void main(String[] args) {
        Solution438 solution438 = new Solution438();
        solution438.findAnagrams("aa","bb");
    }

}


class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if(s == null || p == null || s.length() < p.length()){
            return res;
        }
        int[] pCount = new int[27];
        for(int i=0; i < p.length(); i++){
            pCount[p.charAt(i) - 'a']++;
        }
        int[] window = new int[27];
        for(int i=0; i < p.length(); i++){
            window[s.charAt(i) - 'a']++;
        }
        if(checkEqual(pCount,window)){
            res.add(0);
        }
        int head = p.length();
        int tail = 0;
        while(head < s.length()){
            int headc = s.charAt(head++) - 'a';
            int tailc = s.charAt(tail++) - 'a';
            window[headc]++;
            window[tailc]--;
            if(checkEqual(pCount,window)){
                res.add(tail);
            }
        }
        return res;
    }

    public boolean checkEqual(int[] p,int[] cur){
        for(int i=0; i < p.length; i++){
            if(p[i] != cur[i]){
                return false;
            }
        }
        System.out.println(p[0] + " " + p[1]);
        System.out.println(cur[0] + " " + cur[1]);
        return true;
    }

}
