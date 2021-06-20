package exercise.test;

import java.util.PriorityQueue;

/**
 * @Author tianchengming
 * @Date 2021年4月16日 10:08
 * @Version 1.0
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(1);
        int[] condition = {2,3,5};
        for(int i=0; i < 8; i++){
            int curUgly = queue.poll();
            System.out.println(curUgly+" ");
            for(int c: condition){
                if(!queue.contains(c * curUgly)){
                    queue.offer(c * curUgly);
                }
            }
        }

    }

}
