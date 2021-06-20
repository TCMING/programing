package exercise.hard;

/**
 * @Author tianchengming
 * @Date 2020年12月24日 09:56
 * @Version 1.0
 */
public class Candy {

    public static void main(String[] args) {
        Candy candy = new Candy();
        int[] ratings = {2,3,4,5,2};
        System.out.println(candy.candy(ratings));
    }

    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0){
            return 0;
        }
        if(ratings.length == 1){
            return 1;
        }
        int[] candies = new int[ratings.length];
        for(int i=0; i < ratings.length;i++ ){
            if(i==0 ){
                if(ratings[i] <= ratings[i+1]){
                    candies[i] = 1;
                }
                continue;
            }
            if(i==(ratings.length-1)){
                if(ratings[i-1] >= ratings[i]){
                    candies[i] = 1;
                }
                continue;
            }
            if(ratings[i] <= ratings[i-1] && ratings[i] <= ratings[i+1]){
                candies[i] = 1;
            }
        }
        int loop=1;
        while(loop >= 0){
            for(int i=0; i < ratings.length; i++){
                if(i==0 ){
                    if(ratings[i] > ratings[i+1]){
                        if(candies[i+1] == 0){
                            loop++;
                        }
                        candies[i] = candies[i+1]+1;
                    }
                    continue;
                }
                if(i==(ratings.length-1) ){
                    if(ratings[i-1] < ratings[i]){
                        if(candies[i-1] == 0){
                            loop++;
                        }
                        candies[i] = candies[i-1]+1;
                    }
                    continue;
                }
                if(ratings[i] > ratings[i-1]){
                    if(candies[i-1] == 0){
                        loop++;
                    }
                    candies[i] = Math.max(candies[i] ,candies[i-1]+1);
                }
                if(ratings[i] > ratings[i+1]){
                    if(candies[i+1] == 0){
                        loop++;
                    }
                    candies[i] = Math.max(candies[i] ,candies[i+1]+1);
                }
            }
            loop--;
        }

        int sum = 0;
        for (int candy : candies) {
            sum = sum + candy;
        }
        return sum;
    }

}
