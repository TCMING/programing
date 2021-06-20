package exercise.medium;

import java.util.*;

/**
 * @Author tianchengming
 * @Date 2021年4月15日 19:40
 * @Version 1.0
 */
public class FindUglyNum {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(8));
    }

    public static int nthUglyNumber(int n) {
        if(n <= 6){
            return n;
        }

        Set<Long> exist = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        exist.add(1L);
        heap.offer(1L);
        long ugly = 0;
        for(int i=0; i < n; i++){
            ugly = heap.poll();
            if(!exist.contains(2*ugly)){
                exist.add(2*ugly);
                heap.offer(2*ugly);
            }
            if(!exist.contains(3*ugly)){
                exist.add(3*ugly);
                heap.offer(3*ugly);
            }
            if(!exist.contains(5*ugly)){
                exist.add(5*ugly);
                heap.offer(5*ugly);
            }
        }
        return (int)ugly;
    }

}
