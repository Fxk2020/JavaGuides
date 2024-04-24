package meiTuan;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Orders {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int number = in.nextInt();
        double[] prices = new double[number];
        double[] discountedPrice = new double[number];

        int i = 0;
        // 注意 hasNext 和 hasNextLine 的区别
        while (i<number) { // 注意 while 处理多个 case
            prices[i] = in.nextDouble();
            discountedPrice[i] = in.nextDouble();
            i++;
        }

        double cutAgoPrice = in.nextDouble();
        double cutPrice = in.nextDouble();

        if (cutPrice>cutAgoPrice||cutPrice<=0||cutAgoPrice<=0) {
            System.out.println("error");
            return;
        }

        double price1 = 0;
        double priceAll = 0;
        for (int j = 0; j < number; j++) {

            if (discountedPrice[j]>prices[j]||discountedPrice[j]<=0||prices[j]<=0){
                System.out.println("error");
                return;
            }

            //全选折扣的价格
            price1+=discountedPrice[j];
            priceAll+=prices[j];
        }

        if (priceAll<cutAgoPrice) {
            System.out.println(format2(price1));
            return;
        }

        double price2 = priceAll - cutPrice;

        if (price1>price2){
            System.out.println(format2(price2));
        }else {
            System.out.println(format2(price1));
        }

//        System.out.println(format2(27.999999999999996));

    }

    public static String format2(double value) {

        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return decimalFormat.format(value);
    }

}
