
/**
 * Created by gogen on 29.03.17.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private int E;
    private List<List<Tuple<Integer, Integer>>> adj;

    /**
     * Initializes an empty graph with {@code V} vertices and 0 edges.
     * param V the number of vertices
     */
    public Graph(int V) {
        this.E = 0;
        adj = new ArrayList(V);
    }

    /**
     * Returns the number of vertices in this graph.
     *
     * @return the number of vertices in this graph
     */
    public int V() {
        return this.adj.size();
    }

    /**
     * Returns the number of edges in this graph.
     *
     * @return the number of edges in this graph
     */
    public int E() {
        return E;
    }

    public boolean hasVertex(Integer v) {
        return adj.size() > v;
    }

    // throw an IllegalArgumentException unless {@code 0 < v <= V}
    private void validateVertex(Integer v) {
        if (!this.hasVertex(v))
            throw new IllegalArgumentException("vertex " + v.toString() + " not exist");
    }

    /**
     * Adds the undirected edge v-w to this graph.
     *
     * @param  v one vertex in the edge
     * @param  w the other vertex in the edge
     * @throws IllegalArgumentException unless both {@code 0 < v <= V} and {@code 0 < w <= V}
     */
    public void addEdge(Integer v, Integer w, Integer weight) {
        validateVertex(v);
        validateVertex(w);
        E++;
        adj.get(v).add(new Tuple(w, weight));
    }

    public void addVertex(Integer v) {
        if (!this.hasVertex(v)) {
            this.adj.add(v, new LinkedList());
        }
    }


    /**
     * Returns the vertices adjacent to vertex {@code v}.
     *
     * @param  v the vertex
     * @return the vertices adjacent to vertex {@code v}, as an iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Tuple<Integer, Integer>> adj(Integer v) {
        validateVertex(v);
        return adj.get(v);
    }

    /**
     * Returns the degree of vertex {@code v}.
     *
     * @param  v the vertex
     * @return the degree of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int degree(Integer v) {
        validateVertex(v);
        return adj.get(v).size();
    }


    /**
     * Returns a string representation of this graph.
     *
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
     *         followed by the <em>V</em> adjacency lists
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(this.adj.size() + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < this.adj.size(); v++) {
            s.append(v + ": ");
            for (Tuple<Integer, Integer> w : adj.get(v)) {
                s.append(w.x + "{" + w.y + "}");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

}