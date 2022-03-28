import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class Stack {

    @Test
    public void stack(){
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.pop();
        stack.poll();
        stack.push(1);
        stack.peek();
    }
}
