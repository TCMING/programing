package exercise.test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author tianchengming
 * @Date 2020年7月23日 20:49
 * @Version 1.0
 */
public class ConcurrentHashmapTest {

    public static ConcurrentHashMap<String, AtomicInteger> nextServerCounter = new ConcurrentHashMap<String,AtomicInteger>();

    public static void main(String[] args) {
        nextServerCounter.containsKey("1");
    }

}
