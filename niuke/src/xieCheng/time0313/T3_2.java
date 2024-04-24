package xieCheng.time0313;

import java.util.*;

public class T3_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        sc.close();

        List<Long> res = new ArrayList<>();
        List<Long> counts = new ArrayList<>();

        str = str.replace("[","");
        str = str.replace("]","");
        String[] nums = str.split(",");

        for (int i = 0; i < nums.length; i++) {
            String[] splitNums = nums[i].split("\\(");
            long a = Long.parseLong(splitNums[0]);
            long b = Long.parseLong(splitNums[1].replace(")", ""));
            if (!res.isEmpty()){
                if (res.get(res.size()-1)==a){
                    //和前边一致
                    long count = counts.get(counts.size()-1);
                    counts.remove(counts.size()-1);
                    counts.add(count+b);
                }else {
                    res.add(a);
                    counts.add(b);
                }

            }else {
                res.add(a);
                counts.add(b);
            }
        }

        String resStr = "[";
        for (int i = 0; i < res.size(); i++)  {
            String tmp = String.valueOf(res.get(i));
            tmp = tmp.concat("(");
            tmp = tmp.concat(String.valueOf(counts.get(i)));
            tmp = tmp.concat("),");
            resStr = resStr.concat(tmp);
        }
        resStr = resStr.substring(0, resStr.length()-1);//删除最后一个逗号
        resStr = resStr.concat("]");
        System.out.println(resStr);


    }
}
