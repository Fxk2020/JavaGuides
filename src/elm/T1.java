package elm;

import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] t1 = new String[n];
        String[] t2 = new String[n];
        String[] t3 = new String[n];

        for (int i = 0; i < n; i++) {
            t1[i] = sc.next();
            t2[i] = sc.next();
            t3[i] = sc.next();
        }
        sc.close();

        for (int i = 0; i < n; i++) {

            int time2 = getTime(t2[i], t1[i]);
            int time3 = getTime(t3[i], t1[i]);

            if (time2>=time3) System.out.println("No");
            else System.out.println("yes");


        }
//        System.out.println(Integer.parseInt("00"));

    }

    private static int getTime(String end, String start) {
        String[] time1 = end.split(":");
        int hour1 = Integer.parseInt(time1[0]);
        int minute1 = Integer.parseInt(time1[1]);

        String[] time2 = start.split(":");
        int hour2 = Integer.parseInt(time2[0]);
        int minute2 = Integer.parseInt(time2[1]);

        int hour = 0;
        int minutes = 0;
        //不会超过2小时,所以只有start超过22时才有效
        if (hour2>=22){
            if (hour1<=1){
                hour1+=24;
            }
        }

        hour = hour1-hour2;
        minutes = minute1-minute2;
        return hour*60+minutes;
    }


}
