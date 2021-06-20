package exercise.input;

import java.util.Scanner;

/**
 * @Author tianchengming
 * @Date 2021年4月6日 21:07
 * @Version 1.0
 */
public class IntegerInput {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int initValue = 300;
        while (in.hasNext()) {
            String record = in.nextLine();
            String[] infos = record.split(",");
            int value = Integer.parseInt(infos[0]);
            int preDays = Integer.parseInt(infos[1]);
            int finalDays = Integer.parseInt(infos[2]);
            initValue = process(initValue,value,preDays,finalDays);

        }
        System.out.println(initValue);
    }

    public static int process(int initValue,int value,int preDays,int finalDays){
        if(initValue < value){
            return initValue;
        }
        int price = 0;
        int extra = Math.max((finalDays - preDays), 0);

        if(value >= 100){
            if(preDays > 15){
                price = 15*5 + (preDays-15) * 3;
            }else{
                price = finalDays *5;
            }

        }else if(value >= 50){
            if(preDays > 15){
                price = 15*3 + (preDays-15) * 2;
            }else{
                price = finalDays *3;
            }
        }else {
            price = finalDays;
        }
        price = price + extra;
        return Math.max(initValue-price,0);

    }
}



