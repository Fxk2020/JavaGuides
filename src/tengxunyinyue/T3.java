package tengxunyinyue;

public class T3 {

    public long getNums (long l, long r) {

        int start = isJiweishu(l);
        int end = isJiweishu(r);

        boolean flagL = true;
        if (start%2!=0) {
            start++;
            flagL =false;
        }
        if (end<start) return 0;

        long num = (long) Math.pow(10, end)-(long)Math.pow(10,start-1);
        long res = 0;
        res+=num/2;

        while (end>start){
            if (end%2!=0){
                res-=Math.pow(10, end);
            }
            end--;
        }

        for (long i = r+1; i < (long) Math.pow(10, end); i++) {
            if (isHaoshu(i)){
                res--;
//                System.out.println(i);
            }
        }

        if (flagL){
            for (long i = (long)Math.pow(10,start-1); i < l; i++) {
                if (isHaoshu(i)){
                    res--;
                }
            }
        }


       return res;

    }

    private boolean isHaoshu(long num) {

        int oddCount = 0;
        int evenCount = 0;
        while (num!=0){
            int dight = (int) (num%10);
            if (dight%2==0) evenCount++;
            else oddCount++;
            num/=10;
        }
        return oddCount==evenCount;
    }

    private int isJiweishu(long i) {

        int count = 1;
        while (i/10!=0){
            i %= 10;
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(new T3().getNums(8, 12));
    }


}
