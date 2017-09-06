package generic;


/**
 * Created by qiulin on 2017-4-3.
 */
public class Main {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<String>();
        stringBox.setT("haha");

        Box<Boolean> booleanBox = new Box<Boolean>();
        booleanBox.setT(Boolean.TRUE);


    }
}
