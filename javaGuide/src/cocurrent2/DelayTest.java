package cocurrent2;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
class DelayTask implements Delayed{

    private long executeTime;
    private Runnable task;

    public DelayTask(long delay, Runnable task) {
        this.executeTime = System.currentTimeMillis()+delay;
        this.task = task;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(executeTime-System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.compare(this.executeTime, ((DelayTask)o).executeTime);
    }

    public void execute(){
        task.run();
    }
}
public class DelayTest {

    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayTask> delayQueue = new DelayQueue<>();
        delayQueue.add(new DelayTask(2000, ()-> System.out.println("Task2")));

        delayQueue.add(new DelayTask(1000, ()-> System.out.println("Task1")));

        delayQueue.add(new DelayTask(3000, ()-> System.out.println("Task3")));

        while (!delayQueue.isEmpty()){
            DelayTask take = delayQueue.take();
            take.execute();
        }
    }

}
