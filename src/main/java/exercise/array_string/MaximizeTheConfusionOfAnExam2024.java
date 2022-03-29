package exercise.array_string;

public class MaximizeTheConfusionOfAnExam2024 {

    public static void main(String[] args) {
        MaximizeTheConfusionOfAnExam2024 test = new MaximizeTheConfusionOfAnExam2024();
        System.out.println(test.maxConsecutiveAnswers("FFFTTFTTFT",3));
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        if(answerKey == null || answerKey.length() <= k){
            return answerKey.length();
        }
        //(left,right] 范围内不是全F就是全T
        int n = answerKey.length();
        int left = -1;
        int right = 0;
        int tNum = 0;
        int res = 0;
        boolean flag = true;
        while(left < right && right < n){
            int len = right - left;
            if(flag){
                tNum = 'T' == answerKey.charAt(right)?  tNum + 1: tNum;
            }else{
                tNum = 'T' == answerKey.charAt(left)?  tNum - 1: tNum;
            }
            if(tNum <= k || (len-tNum) <= k){
                res = Math.max(res,len);
                right++;
                flag = true;
            }else{
                left++;
                flag = false;
            }
        }
        return res;
    }

}
