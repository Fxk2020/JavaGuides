package concurrent;

public class TestSynchronized {

    public static synchronized void printA(){
        int i = 0;
        while (i<1000){
            System.out.println("A");
            i++;
        }

    }

    public static synchronized void printB(){
        System.out.println("B");
    }

    public static void main(String[] args) {
        new Thread(
                TestSynchronized::printA
        ).start();
        new Thread(
                TestSynchronized::printB
        ).start();
    }
}
