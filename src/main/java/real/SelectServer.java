package real;

import java.util.concurrent.atomic.AtomicInteger;

public class SelectServer {

    private static AtomicInteger atomServerIndex = new AtomicInteger();

    public static void main(String[] args) {

        for(int i=0; i < 12; i++){
            for(int req=0; req < 10; req++){
                System.out.println("当前调度序号"+i+": "+ "请求序号" + req + ",最终机器" + incrementAndGetModulo(10,12,i));
            }
            System.out.println();
        }
    }

    private static synchronized int incrementAndGetModulo(int serverSize,int num,int index) {
        int curServer = atomServerIndex.get();
        int nextServer = curServer + 1;
        while (true) {
            if(nextServer % num == index){
                nextServer = nextServer % serverSize;
                if(atomServerIndex.compareAndSet(curServer,nextServer)){
                    return nextServer;
                }
            }
            nextServer++;
            if(nextServer > 1000){
                nextServer = 0;
            }
        }
    }

}
