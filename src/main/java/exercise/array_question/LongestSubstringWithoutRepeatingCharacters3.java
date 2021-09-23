package exercise.array_question;

public class LongestSubstringWithoutRepeatingCharacters3 {

    public int lengthOfLongestSubstring(String s) {
        int[] chars = new int[256];
        int l = 0, r = -1;
        int res = 0;
        while(l < s.length()){
            if( r+1 < s.length() && chars[s.charAt(r + 1)] == 0){
                chars[s.charAt(++r)] = 1;
            }else{
                chars[s.charAt(l++)] = 0;
            }
            res = Math.max(res,r - l + 1);
        }
        return res;
    }

}
