package cocurrent2;

import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap并不能保证复合操作是原子的
 */
public class ConcurrentHashMapTest implements Runnable{

    private ConcurrentHashMap<Integer, String> test = new ConcurrentHashMap<>();
    private String value;

    public String getValue() {
        return value;
    }

    public ConcurrentHashMap<Integer, String> getTest() {
        return test;
    }

    public void setTest(ConcurrentHashMap<Integer, String> test) {
        this.test = test;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ConcurrentHashMapTest(String value){
        this.value = value;
    }


    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMapTest concurrentHashMapTest = new ConcurrentHashMapTest("value");
        new Thread(concurrentHashMapTest).start();
//        Thread.sleep(500);
        concurrentHashMapTest.setValue("anotherValue");
        new Thread(concurrentHashMapTest).start();

        Thread.sleep(2000);
        System.out.println(concurrentHashMapTest.getTest().get(1));
    }


    @Override
    public void run() {
        test.putIfAbsent(1, value);
    }
}
