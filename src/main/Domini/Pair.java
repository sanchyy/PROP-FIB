package Domini;

public class Pair <A,B> {

    private A first;
    private B second;

    public Pair (A first, B second) {
        super();
        this.first  = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    public static <A,B> Pair<A,B> of(A first, B second) {
        return new Pair<A, B>(first,second);
    }

    public boolean equals(Object o) {
        if (!(o instanceof Pair)) return false;
        Pair pairo = (Pair) o;
        return this.first.equals(pairo.getFirst()) && this.second.equals(pairo.getSecond());
    }

    public String toString() {
        return "(" + first.toString() + "," + second.toString() + ")";
    }

}
