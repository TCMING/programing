package exercise.medium;

/**
 * @Author tianchengming
 * @Date 2020年12月22日 19:35
 * @Version 1.0
 */
public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        RemoveDuplicateLetters test = new RemoveDuplicateLetters();
        System.out.println(test.removeDuplicateLetters( "bcabc"));
    }

    public String removeDuplicateLetters(String s) {
        if(s == null || s.length() <= 0){
            return "";
        }
        int[] res = new int[s.length()];
        for(int i=0; i < s.length(); i++){
            res[i] = s.charAt(i);
        }
        for(int i=0; i < s.length(); i++){
            if(checkExist(res,0,i,res[i])){
                res[i] = 0;
                continue;
            }
            for(int j=i+1; j < s.length(); j++) {
                if (res[i] > res[j] && (!checkSmall(res, i+1, j, res[i]))) {
                    if (checkExist(res, j, res.length, res[i])) {
                        res[i] = 0;
                    }
                    break;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i < s.length();i++){
            if(res[i] != 0){
                stringBuilder.append((char)res[i]);
            }
        }
        return stringBuilder.toString();
    }

    private boolean checkSmall(int[] array,int start,int end,int num){
        for(; start < end;start++){
            if(num < array[start]){
                return true;
            }
        }
        return false;
    }


    private boolean checkExist(int[] array,int start,int end,int num){
        for(; start < end;start++){
            if(num == array[start]){
                return true;
            }
        }
        return false;
    }
}
