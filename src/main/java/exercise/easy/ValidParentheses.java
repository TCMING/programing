package exercise.easy;

import java.util.Stack;

/**
 * @Author tianchengming
 * @Date 2021年3月21日 21:41
 * @Version 1.0
 */
public class ValidParentheses {
    public static void main(String[] args) {
        SolutionValidParentheses solution = new SolutionValidParentheses();
        System.out.println(solution.isValid("()[]{}"));
    }
}

/**
 * 需要注意 {}是具有顺序性，不能 判断只能由一种case，即  cur==')' && topChar == '('
 * 不需要判断 cur=='(' && topChar == ')'
 */
class SolutionValidParentheses {
    public boolean isValid(String s) {
        if(s == null || s.length() % 2 == 1){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(int i=0; i < s.length() ; i++){
            char cur = s.charAt(i);
            char topChar = stack.size() > 0 ?stack.peek() : 'a';
            if(cur==')' && topChar == '('){
                stack.pop();
                continue;
            }
            if(cur=='}' && topChar == '{'){
                stack.pop();
                continue;
            }

            if(cur==']' && topChar == '['){
                stack.pop();
                continue;
            }
            stack.push(cur);
        }
        return stack.size() == 0;
    }
}
