package concurrent;

public class PrintABC {

    private int num = 0;
    private static final Object Lock = new Object();

    private void printABC(String name, int targetNum){
        while (true){
            synchronized (Lock){
                while (num%3!=targetNum) {
                    try {
                        Lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                num++;
                System.out.println(name);
                Lock.notifyAll();
            }
        }

    }


    public static void main(String[] args) {
        PrintABC printABC = new PrintABC();

        new Thread(
                ()-> {
                    printABC.printABC("A", 0);
                },"A"
        ).start();
        new Thread(
                ()-> {
                    printABC.printABC("B", 1);
                },"B"
        ).start();
        new Thread(
                ()-> {
                    printABC.printABC("C", 2);
                },"C"
        ).start();
    }


}
