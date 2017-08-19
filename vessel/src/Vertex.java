import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gogen on 02.05.17.
 */
public class Vertex {
    static int[] MAX = {10, 7, 4};
    int[] vessels;

    @Override
    public String toString() {
        return "Vertex{" +
                "vessels=" + Arrays.toString(vessels) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        return Arrays.equals(vessels, vertex.vessels);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(vessels);
    }

    public Vertex() {
        this.vessels = new int[3];
        this.vessels[0] = 0;
        this.vessels[1] = Vertex.MAX[1];
        this.vessels[2] = Vertex.MAX[2];
    }

    public Vertex(int[] vessels) {
        if (vessels[0] < 0 || vessels[0] > Vertex.MAX[0]) {
            throw new IllegalArgumentException("value " + vessels[0] + " is not between 0 and " + Vertex.MAX[0]);
        }
        if (vessels[1] < 0 || vessels[1] > Vertex.MAX[1]) {
            throw new IllegalArgumentException("value " + vessels[1] + " is not between 0 and " + Vertex.MAX[1]);
        }
        if (vessels[2] < 0 || vessels[2] > Vertex.MAX[2]) {
            throw new IllegalArgumentException("value " + vessels[2] + " is not between 0 and " + Vertex.MAX[2]);
        }
        this.vessels = vessels;
    }

    public Vertex overflow(int from, int to) throws Exception {
        if (this.canOverflow(from, to)) {
            int value = Math.min(this.vessels[from], Vertex.MAX[to] - this.vessels[to]);
            int[] vessels = new int[3];
            System.arraycopy(this.vessels, 0, vessels, 0, this.vessels.length);
            vessels[from] -= value;
            vessels[to] += value;
            return new Vertex(vessels);
        } else {
            throw new Exception("cannot overflow");
        }
    }

    public List<Vertex> overflowAll() throws Exception {
        List<Vertex> vs = new LinkedList();
        for(int from = 0; from < 3; from ++) {
            for (int to = 0; to < 3; to++) {
                if (from != to && this.canOverflow(from, to)) {
                    vs.add(this.overflow(from, to));
                }
            }
        }
        return vs;
    }

    public boolean canOverflow(int from, int to) {
        return this.vessels[from] > 0 && this.vessels[to] < Vertex.MAX[to];
    }

    public boolean isTrue() {
        return this.vessels[1] == 2 || this.vessels[2] == 2;
    }


}
