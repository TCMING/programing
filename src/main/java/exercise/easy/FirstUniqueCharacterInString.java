package exercise.easy;

/**
 * 387 First Unique Character in a String
 * @Author tianchengming
 * @Date 2020年12月23日 09:44
 * @Version 1.0
 */
public class FirstUniqueCharacterInString {

    public static void main(String[] args) {
        FirstUniqueCharacterInString uniqueChar = new FirstUniqueCharacterInString();
        System.out.println(uniqueChar.firstUniqChar("exercise"));
    }

    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0){
            return -1;
        }
        int[] container = new int[256];
        for(int i=0; i < s.length(); i++){
            container[s.charAt(i)]++;
        }
        for(int i=0; i < s.length(); i++){
            if(container[s.charAt(i)] == 1){
                return i;
            }
        }
        return -1;
    }
}
