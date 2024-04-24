package cocurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class Ticket implements Runnable {

    private AtomicInteger ticket = new AtomicInteger(10000);
    private boolean loop = true;


    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }

    private void sell() {
//        synchronized (this) {
//            if (ticket == 0) {
//                System.out.println("售票结束");
//                loop = false;
//                return;
//            }
//
//            int res = 10000 - (--ticket);
//
//            System.out.println(Thread.currentThread().getName() +
//                    "卖出了第" + res + "票");
//        }
//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        if (ticket.get()==0) {
            System.out.println("售票结束");
            loop = false;
            return;
        }

        int res = 10000 - (ticket.decrementAndGet());

        System.out.println(Thread.currentThread().getName() +
                "卖出了第" + res + "票");


    }


    public static void main(String[] args) {
        Ticket ticket1 = new Ticket();

        new Thread(ticket1).start();
        new Thread(ticket1).start();
        new Thread(ticket1).start();

    }
}
