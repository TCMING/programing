package exercise.easy;

class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        if(name == null){
            return false;
        }
        if(name.length() == 0 && typed.length() > 0){
            return false;
        }
        if(name.length() == 0 && typed.length() <= 0){
            return true;
        }
        if(name.length() > typed.length()){
            return false;
        }
        boolean flag = false;
        char preChar = name.charAt(0);
        int i=0,j=0;
        for(; i < name.length(); i++){
            char nameChar = name.charAt(i);
            if(j == typed.length()){
                break;
            }else{
                while(j < typed.length()){
                    if((j < typed.length() - 1)
                            && nameChar != preChar
                            && preChar == typed.charAt(j)){
                        j++;
                        continue;
                    }else if(nameChar == typed.charAt(j)){
                        j++;
                        preChar = nameChar;
                        break;
                    }
                    return false;
                }
            }

        }
        for( ; j < typed.length(); j++){
            if(preChar != typed.charAt(j)){
                return false;
            }
        }
        return j==typed.length() && i == name.length();
    }
}
