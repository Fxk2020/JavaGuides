package java1;

public class TestAdd {
    public static void main(String[] args) {
//        int i = 1;
//        i = ++i;
//        System.out.println(i);

        int count = 0;
        for(int i = 0;i < 100;i++)
        {
            count = count++;
        }
        System.out.println("count = "+count);

        //使用StringBuilder拼接字符串更为高效

    }
}
