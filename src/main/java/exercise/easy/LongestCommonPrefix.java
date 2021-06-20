package exercise.easy;



/**
 * @Author tianchengming
 * @Date 2021年3月21日 16:43
 * @Version 1.0
 */
public class LongestCommonPrefix {



}
/**
 * 二分查找方法
 */
class Solution3{

    public String longestCommonPrefix(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }
        int minLen = strs[0].length();
        for(int i=1; i < strs.length; i++){
            minLen = Math.min(minLen,strs[i].length());
        }
        if(minLen < 1){
            return "";
        }
        int left = 0;
        int right = minLen - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(isCommonString(strs,mid)){
                left = mid+1;
            }else{
                right = mid - 1;
            }
        }
        return strs[0].substring(0,left);
    }

    public boolean isCommonString(String[] strs,int len){
        for(int i=0; i <= len; i++){
            char curChar = strs[0].charAt(i);
            for(int j=0; j < strs.length; j++){
                if(strs[j].charAt(i) != curChar){
                    return false;
                }
            }
        }
        return true;
    }
}


/**
 * 分治法
 */
class Solution2 {

    public String longestCommonPrefix(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }
        return divStringArray(strs,0,strs.length-1);

    }
    public String divStringArray(String[] strs,int start,int end){
        if(start == end){
            return strs[start];
        }
        int mid = start + (end - start)/2;
        String leftComString = divStringArray(strs, start, mid);
        String rightComString = divStringArray(strs, mid+1, end);
        return commonString(leftComString,rightComString);
    }

    public String commonString(String str1,String str2){
        int minLen = Math.min(str1.length(),str2.length());
        for(int i=0; i < minLen; i++){
            if(str1.charAt(i) != str2.charAt(i)){
                return str1.substring(0,i);
            }
        }
        return str1.substring(0,minLen);
    }

}


/**
 * 横向比较 时间复杂度O(mn),空间复杂度O(1)
 */
class Solution1 {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        int min = Integer.MAX_VALUE;
        for(String str : strs){
            min = Math.min(min,str.length());
        }

        String preString = strs[0];
        for(int i=1; i < strs.length; i++){
            if(min < 1){
                return "";
            }
            preString = findLongestPreString(min,preString,strs[i]);

            min = Math.min(min,preString.length());
        }
        return preString;
    }

    private String findLongestPreString(int min,String str1,String str2){
        StringBuilder res = new StringBuilder();
        for(int i=0; i < min; i++){
            if(str1.charAt(i) == str2.charAt(i)){
                res.append(str1.charAt(i));
            }else{
                break;
            }
        }
        return res.toString();
    }
}
