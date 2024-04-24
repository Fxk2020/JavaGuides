package singleton;

public class LazySingleton {
    private LazySingleton(){}
    private volatile static LazySingleton lazySingleton;

//    public static LazySingleton getInstance() throws InterruptedException {
//        if (lazySingleton==null){
//            Thread.sleep(10);
//            lazySingleton = new LazySingleton();
//        }
//
//        return lazySingleton;
//    }

    public static LazySingleton getInstance() throws InterruptedException {
        if (lazySingleton==null){
            synchronized (LazySingleton.class){
                if (lazySingleton==null){
                    Thread.sleep(10);
                    lazySingleton = new LazySingleton();
                }
            }
        }

        return lazySingleton;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(
                    ()->{
                        try {
                            System.out.println("实例名"+LazySingleton.getInstance());
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
            ).start();
        }
    }
}
