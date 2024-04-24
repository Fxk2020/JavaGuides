package java1;

import java.math.BigDecimal;

public class Test3 {
    public static void main(String[] args) {
        float a = 2.0f - 1.9f;
        float b = 1.8f - 1.7f;
        System.out.println(a);// 0.100000024
        System.out.println(b);// 0.099999905
        System.out.println(a == b);// false

        BigDecimal a1 = new BigDecimal("2.00");
        BigDecimal a2 = new BigDecimal("1.90");
        BigDecimal b1 = new BigDecimal("1.80");
        BigDecimal b2 = new BigDecimal("1.70");

        BigDecimal x = a1.subtract(a2);
        BigDecimal y = b1.subtract(b2);

        System.out.println(x.compareTo(y));// 0
        System.out.println(x.equals(y));//还会比较精度

    }
}
