package tengxunyinyue;

public class T1 {

    public String change (String mystr) {

        mystr = mystr.replace('r', '1');
        mystr = mystr.replace('e', '2');
        mystr = mystr.replace('d', '3');
        mystr = mystr.replace('1', 'e');
        mystr = mystr.replace('2', 'd');
        mystr = mystr.replace('3', 'r');
        return mystr;
    }


}
