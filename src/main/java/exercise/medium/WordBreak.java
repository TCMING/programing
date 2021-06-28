package exercise.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author tianchengming
 * @Date 2021年6月27日 14:45
 * @Version 1.0
 */
public class WordBreak {

    public static void main(String[] args) {
        Solution139 solution139 = new Solution139();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        System.out.println(solution139.wordBreak("applepenapple",wordDict));
    }

}

//搞了一小时超时了，还是需要动态规划
class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() <= 0){
            return false;
        }
        Set<Integer> lens = new HashSet<>();
        int minLen = Integer.MAX_VALUE;
        for(String word : wordDict){
            lens.add(word.length());
            minLen = Math.min(minLen,word.length());
        }
        return spiltWord(s,wordDict,lens,minLen);
    }

    public boolean spiltWord(String s,List<String> wordDict,Set<Integer> lens,int minLen){
        if(s.length() < minLen){
            return false;
        }
        if(lens.contains(s.length()) && wordDict.contains(s)){
            return true;
        }
        for(Integer len: lens){
            if(s.length() < len){
                continue;
            }
            String subString = s.substring(0,len);
            if(!wordDict.contains(subString)){
                continue;
            }
            String left = s.substring(len,s.length());

            boolean subRes = false;
            if(left.length() == 0){
                subRes = true;
            }else{
                subRes = spiltWord(left,wordDict,lens,minLen);
            }
            if(subRes){
                return true;
            }
        }
        return false;

    }

}
