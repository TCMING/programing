package exercise.multithreading;

/**
 * @Author tianchengming
 * @Date 2020年10月11日 17:10
 * @Version 1.0
 */
public class AlternatePrint {

    private  int value = 0;

    public  synchronized void printOdd() {
        while(value <= 100){
            if(value % 2 == 1){
                System.out.println(value);
                value++;
                this.notify();
            }else {
                try {
                    this.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public  synchronized void printEven(){
        while(value <= 100){
            if(value % 2 == 0){
                System.out.println(value);
                value++;
                this.notify();
            }else {
                try {
                    this.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        final AlternatePrint alternatePrint = new AlternatePrint();
        Thread threadOdd = new Thread(new Runnable() {
            public void run() {
                alternatePrint.printOdd();
            }
        });

        Thread threadEven = new Thread(new Runnable() {
            public void run() {
                alternatePrint.printEven();
            }
        });

        threadEven.start();
        threadOdd.start();
    }

}
