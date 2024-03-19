package xieCheng.time0313;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 游游拿到了一个数组，她希望你将数组相同的相邻元素压缩在一起。你能帮帮她吗？
 *给定的数组是已经被压缩了一部分的形式，请你继续将其压缩到不能再压缩为止。举个例子，数组[2,3,5,5,5,3]会被压缩成[2(1),3(1),5(3),3(1)]。
 *
 *输入描述
 *
 * 一个字符串，代表待压缩的数组。字符串长度不超过10^5，且括号内的一定是不超过10^9的正整数。数组中每个元素的值域范围是[-10^9,10^9]
 *
 * 输出描述
 *
 * 一个字符串，表示压缩后的数组。
 *
 */
public class T3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        sc.close();

        HashMap<Long, Long> res = new HashMap<>();

        str = str.replace("[","");
        str = str.replace("]","");
        String[] nums = str.split(",");

        for (int i = 0; i < nums.length; i++) {
            String[] splitNums = nums[i].split("\\(");
            long a = Long.parseLong(splitNums[0]);
            long b = Long.parseLong(splitNums[1].replace(")", ""));
            if (res.containsKey(a)){
                res.put(a, res.get(a)+b);
            }else {
                res.put(a, b);
            }
        }

        String resStr = "[";
        for (Map.Entry<Long, Long> entry:
             res.entrySet()) {
            String tmp = String.valueOf(entry.getKey());
            tmp = tmp.concat("(");
            tmp = tmp.concat(String.valueOf(entry.getValue()));
            tmp = tmp.concat("),");
            resStr = resStr.concat(tmp);
        }
        resStr = resStr.substring(0, resStr.length()-1);//删除最后一个逗号
        resStr = resStr.concat("]");
        System.out.println(resStr);
    }

}
