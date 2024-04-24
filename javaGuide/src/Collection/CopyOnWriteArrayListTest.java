package Collection;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest {
    // 创建一个 CopyOnWriteArrayList 对象
    private static  final CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

    public static void init(){
        list.add("Java");
        list.add("Python");
        list.add("C++");
        System.out.println("初始列表：" + list);
    }
    public void testWrite(){
        while (true){
            list.add("test"+ Math.random());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void testRead(){
        while (true){
            System.out.println(list);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        CopyOnWriteArrayListTest.init();
        new Thread(
                ()->{
                    new CopyOnWriteArrayListTest().testRead();
                }
        ).start();

        new Thread(
                ()->{
                    new CopyOnWriteArrayListTest().testWrite();
                }
        ).start();

        new String();


    }


}
