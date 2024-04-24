package cocurrent2;

public class TicketThread {

    public static void main(String[] args) {
        TicketGrabbing ticketThread = new TicketGrabbing();
        new Thread(ticketThread,"小王").start();
        new Thread(ticketThread,"小伍").start();
    }
}


class TicketGrabbing implements Runnable{
    //票数
    private int ticket = 10;

    @Override
    public void run() {
        while(true){
            if (ticket <=0){
                break;
            }
            //延时
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"抢到了第："+ticket--+"票");
        }
    }
}


