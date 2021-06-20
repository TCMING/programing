package exercise.easy;

/**
 * @Author tianchengming
 * @Date 2021年4月14日 20:03
 * @Version 1.0
 */
public class StringChange {

    public static void main(String[] args) {
        System.out.println(changeString("RXXLRXRXL","XRLXXRRLX"));
    }

    public static boolean changeString(String start,String end){
        if(start.length() != end.length()){
            return false;
        }
        char[] startArray = start.toCharArray();
        char[] endArray = end.toCharArray();
        for(int i=0; i < startArray.length-1; i++){
            if(startArray[i] != endArray[i]){
                if(startArray[i] == 'L' && startArray[i+1] == 'X'){
                    startArray[i] = 'X';
                    startArray[i+1] = 'L';
                    i--;
                }else if(startArray[i] == 'X' && startArray[i+1] == 'L'){
                    startArray[i] = 'L';
                    startArray[i+1] = 'X';
                    i--;
                }
                else if(startArray[i] == 'R' && startArray[i+1] == 'X'){
                    startArray[i] = 'X';
                    startArray[i+1] = 'R';
                    i--;
                }
                else if(startArray[i] == 'X' && startArray[i+1] == 'R'){
                    startArray[i] = 'R';
                    startArray[i+1] = 'X';
                    i--;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
