package exercise.designpattern.proxy;

public class SmsServiceImpl implements SmsService{

    @Override
    public void send(String message) {
        System.out.println("Send message：" + message);
    }
}
