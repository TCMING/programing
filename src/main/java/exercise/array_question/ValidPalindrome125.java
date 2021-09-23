package exercise.array_question;

public class ValidPalindrome125 {

    public static void main(String[] args) {
        String input = "race a car";
        ValidPalindrome125 test = new ValidPalindrome125();
        boolean res = test.isPalindrome(input);
        System.out.println(res);
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        for (int i = 0, j = s.length() - 1; i <= j; i++,j--) {
            while(i <= j && !judgeChar(s,i) ){
                i++;
            }
            while(i <= j && !judgeChar(s,j)){
                j--;
            }
            if(i > j){
                return true;
            }
            char c1 = s.charAt(i);
            if(c1 >= 'A' && c1 <= 'Z'){
                c1 = (char)(c1 + 32);
            }
            char c2 = s.charAt(j);
            if(c2 >= 'A' && c2 <= 'Z'){
                c2 = (char)(c2 + 32);
            }
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }

    public boolean judgeChar(String s,int index){
        char c = s.charAt(index);
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z');
    }
}
