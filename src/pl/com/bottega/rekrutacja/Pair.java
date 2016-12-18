package pl.com.bottega.rekrutacja;

/**
 * Created by macie on 11.12.2016.
 */
public class Pair {
    private int x,y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;

    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pair))
            return false;
        Pair p = (Pair) obj;
        return (this.x == p.x && this.y == p.y) || (this.x == p.y && this.y == p.x);
    }

    @Override
    public int hashCode() {
        return x + y;
    }

    public String toString(){
        return "(" + x + ", " + y + ")";
    }
}
