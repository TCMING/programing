package exercise.designpattern.proxy;

public class StaticProxy implements SmsService{

    private SmsService smsService;

    public StaticProxy(SmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public void send(String message) {
        System.out.println("before method send()");
        smsService.send(message);
        System.out.println("after method send()");
    }
}
