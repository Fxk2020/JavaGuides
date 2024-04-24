package cocurrent2;

import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumerExample implements Runnable{
    static ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
    int id;//0生产者，1消费者
    private static final int capacity = 100;

    public ProducerConsumerExample(int id) {
        this.id = id;
    }

    @Override
    public void run() {

        if (id==0){
            for (int i = 0; i < capacity; i++) {
                try {
                    queue.put(i);
                    System.out.println("生产者生产了第"+(i+1)+"个产品");
//                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }else {
            while (true){
                try {
                    int product = queue.take();
                    System.out.println("消费者消费了第"+(product+1)+"个产品");
                    if (product+1==capacity) break;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }

    }


    public static void main(String[] args) {
        ProducerConsumerExample producer = new ProducerConsumerExample( 0);
        ProducerConsumerExample consumer = new ProducerConsumerExample(1);

        new Thread(producer).start();
        new Thread(consumer).start();
    }

}
