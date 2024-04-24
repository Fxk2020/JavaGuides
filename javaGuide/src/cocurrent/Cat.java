package cocurrent;

public class Cat extends Thread{

    public static void main(String[] args) {
        new Cat().start();
        //主线程不会阻塞
        System.out.println(Thread.currentThread().getName());
        //可以创建多个线程
        new Cat().start();
    }


    @Override
    public void run() {
        System.out.println("线程名是"+Thread.currentThread().getName());
        while (true){
            System.out.println("cat~~~~~~~~~~~~~~~~~~");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
