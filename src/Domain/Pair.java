package Domain;
import java.utils.*;

public class Pair <A,B> {
    private A first;
    private B second;

    public Pair (A first, B second) {
        super();
        this.first  = first;
        this.second = second;
    }

    public static <A,B> Pair<A,B> of(A first, B second) {
        return new Pair<A, B>(first,second);
    }

    public boolean equals(Object o) {
        if (!(o instanceof Pair)) return false;
        Pair pairo = (Pair) o;
        return this.left.equals(pairo.getLeft()) && this.right.equals(pairo.getRight());
    }

}
