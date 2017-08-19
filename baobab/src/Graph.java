import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by gogen on 29.03.17.
 */

public class Graph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int[][] adj;

    /**
     * Initializes an empty graph with {@code V} vertices and 0 edges.
     * param V the number of vertices
     *
     * @param  V number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
    public Graph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        adj = new int[V][V];
    }

    public Graph(BufferedReader br) {
        try {
            this.V = Integer.parseInt(br.readLine());
            if (V < 0) throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
            adj = new int[V][V];
            for (int i = 0; i < V; i++) {
                String[] row = br.readLine().split(" ");
                for (int j = 0; j < row.length; j++) {
                    if (Integer.parseInt(row[j]) == 1) {
                        addEdge(i, j);
                    }
                }
            }
        }
        catch (IOException e) {
            throw new IllegalArgumentException("invalid input format in Graph constructor", e);
        }
    }
//
    /**
     * Returns the number of vertices in this graph.
     *
     * @return the number of vertices in this graph
     */
    public int V() {
        return V;
    }

    // throw an IllegalArgumentException unless {@code 0 < v <= V}
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 1 and " + V);
    }

    /**
     * Adds the undirected edge v-w to this graph.
     *
     * @param  v one vertex in the edge
     * @param  w the other vertex in the edge
     * @throws IllegalArgumentException unless both {@code 0 < v <= V} and {@code 0 < w <= V}
     */
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        adj[v][w] = 1;
    }


    /**
     * Returns the vertices adjacent to vertex {@code v}.
     *
     * @param  v the vertex
     * @return the vertices adjacent to vertex {@code v}, as an iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int[] adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    /**
     * Returns the degree of vertex {@code v}.
     *
     * @param  v the vertex
     * @return the degree of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int degree(int v) {
        validateVertex(v);
        int deg = 0;
        for (int i = 0; i < adj[v].length; i++) {
            deg += adj[v][i];
        }
        return deg;
    }


    /**
     * Returns a string representation of this graph.
     *
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
     *         followed by the <em>V</em> adjacency lists
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

}