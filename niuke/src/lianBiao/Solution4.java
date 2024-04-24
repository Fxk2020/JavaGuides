package lianBiao;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 */
public class Solution4 {


    public String addStrings(String num1, String num2) {

        int n1 = num1.length()-1;
        int n2 = num2.length()-1;
        int add = 0;
        StringBuffer str = new StringBuffer();
        while (n1>=0||n2>=0||add!=0){
            int x = n1>=0?num1.charAt(n1--)-'0':0;
            int y = n2>=0?num2.charAt(n2--)-'0':0;
            int res = x+y+add;
            str.append(res%10);
            add = res/10;
        }
        return str.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(new Solution4().addStrings("1", "9"));
    }
}
