package understandjvm.chapter10;

/**
 * 参才深入理解Java虚拟机10.3。2章节
 *
 * Created by qiulin on 2017-5-12.
 */
public class _10_7 {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;

        System.out.println(c == d);            // true
        System.out.println(e == f);            // false
        System.out.println(c.equals(d));       // true
        System.out.println(c == (a + b));      // true， 包装类不遇到算术运算符是不会自动拆箱的
        System.out.println(c.equals(a+b));     // true
        System.out.println(g == (a + b));      // true, 包装类遇到算术运算会自动拆箱，且强转成一致类型
        System.out.println(g.equals(a + b));   // equals()不处理数据转型

    }
}
