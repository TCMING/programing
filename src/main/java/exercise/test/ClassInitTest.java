package exercise.test;

public class ClassInitTest {

    public static void main(String[] args) {
        //普通类变量使用导致变量所在类初始化
//        System.out.println(SubClass.value);
        //常亮使用不会引起类初始化 此常量的值“hello world”直接存储在当前类的常量池中
//        System.out.println(SubClass.HELLO_WORLD);
        //数组也不会引起初始化
        SuperClass[] sca = new SuperClass[10];
    }
}

class SuperClass{

    public static String value = "value";

    public static final String HELLO_WORLD  = "hello world";

    static{
        System.out.println("supper class init");
    }

}

class SubClass extends SuperClass{

    static{
        System.out.println("sub class init");
    }

}






