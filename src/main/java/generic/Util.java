package generic;

import java.util.Comparator;
import java.util.Objects;

/**
 * Created by qiulin on 2017-4-3.
 */
public class Util {

    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return Objects.equals(p1.getK(), p2.getK()) &&
                Objects.equals(p1.getV(), p2.getV());
    }


    public static <T extends Comparable<T>> int countGreaterThan(T[] array, T elem) {
        int count = 0;
        if (array == null) {
            return count;
        }
        for(T t: array) {
            if (t.compareTo(elem) > 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair1 = new Pair<Integer, String>(1, "apple");
        Pair<Integer, String> pair2 = new Pair<Integer, String>(2, "pear");
        boolean theSame = compare(pair1, pair2);
        System.out.println(theSame);
    }

}

class Pair<K, V> {
    private K k;

    private V v;

    public Pair(K k, V v) {
        this.k = k;
        this.v = v;
    }

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }
}
