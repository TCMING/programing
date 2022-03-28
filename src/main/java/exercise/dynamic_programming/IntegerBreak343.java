package exercise.dynamic_programming;

public class IntegerBreak343 {

    public static void main(String[] args) {
        IntegerBreak343 integerBreak343 = new IntegerBreak343();
        integerBreak343.integerBreak(10);
    }

    public int integerBreak(int n) {
        if(n <= 2 ){
            return 1;
        }
        int product = 1;
        for(int i=1; i < n/2; i++){
            product = Math.max(product,integerBreakRecursion(i) * integerBreakRecursion(n-i));
        }
        return product;
    }

    public int integerBreakRecursion(int n) {
        if(n < 2 ){
            return 1;
        }
        int product = n;
        for(int i=1; i <= n/2; i++){
            product = Math.max(product,integerBreakRecursion(i) * integerBreakRecursion(n-i));
        }
        return product;
    }
}
