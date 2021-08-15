package exercise.designpattern.proxy;

public class ProxyPatternTest {

    public static void main(String[] args) {
        SmsService staticTest = new SmsServiceImpl();
        StaticProxy proxy = new StaticProxy(staticTest);
        proxy.send("Static proxy message test!");

        SmsService dynamicTest = (SmsService) DynamicProxyFactory.getProxy(new SmsServiceImpl());
        dynamicTest.send("Dynamic proxy message test!");
    }

}
