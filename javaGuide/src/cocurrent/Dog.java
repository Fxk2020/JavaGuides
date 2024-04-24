package cocurrent;

public class Dog implements Runnable{


    public static void main(String[] args) {
//        new Dog().run();
        new Thread(new Dog()).start();
        System.out.println(Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("线程是："+Thread.currentThread().getName());
        while (true){
            System.out.println("旺旺");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
