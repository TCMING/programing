package exercise.array_question;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReverseVowelsOfString345 {

    List<Character> vowels = Arrays.asList('a','e','i','o','u','A','E','I','O','U');
    Set<Character> set = new HashSet<>(vowels);

    public String reverseVowels(String s) {
        if(s == null || s.length() <= 1){
            return s;
        }
        char[] charStr = s.toCharArray();
        for(int i=0, j = charStr.length-1; i < j ; i++,j--){
            while( i < j && !set.contains(charStr[i])){
                i++;
            }
            while( i < j && !set.contains(charStr[j])){
                j--;
            }
            if(i < j && charStr[i] != charStr[j]){
                char tmp = charStr[i];
                charStr[i] = charStr[j];
                charStr[j] = tmp;
            }
        }
        return String.copyValueOf(charStr);
    }

}
