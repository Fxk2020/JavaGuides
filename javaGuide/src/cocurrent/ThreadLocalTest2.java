package cocurrent;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadLocalTest2 implements Runnable{

    //创建一个ThreadLocal变量
    public ThreadLocal<Integer> localVariable = new ThreadLocal<>();
    private ThreadLocal<String> localString = new ThreadLocal<>();
    private ThreadLocal<Boolean> loop = new ThreadLocal<>();

    public ThreadLocalTest2(int num){
        System.out.println("hello");
        localVariable.set(num);
        localString.set("售票员");
        loop.set(true);
    }

    @Override
    public void run() {
        while (loop.get()) {
            sell();
        }
    }

    private void sell() {
        if (localVariable.get() == 0) {
            System.out.println("售票结束");
            loop.set(false);
            return;
        }

        localVariable.set(localVariable.get()-1);
        int res = 100 - localVariable.get();
        System.out.println(Thread.currentThread().getName() +
                "卖出了第" + res + "票");

    }

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5,10,100, TimeUnit.SECONDS, new LinkedBlockingQueue<>(15)
        );

        for (int i = 0; i < 10; i++) {
            Runnable seller = new ThreadLocalTest2(100);
            threadPoolExecutor.execute(seller);
        }

        threadPoolExecutor.shutdown();
        while (!threadPoolExecutor.isTerminated());
        System.out.println("售票结束");



    }


}
