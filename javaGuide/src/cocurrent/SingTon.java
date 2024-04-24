package cocurrent;

public class SingTon {

    private volatile static SingTon singTon;//volatile关键字

    private SingTon(){}//构造方法是私有的

    public static SingTon getSingTon(){
        if (singTon==null){

            synchronized (SingTon.class){//对类加锁
                if (singTon==null){
                    singTon = new SingTon();
                }
            }
        }
        return singTon;
    }
}
