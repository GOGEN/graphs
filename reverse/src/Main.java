import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gogen on 01.06.17.
 */
public class Main {

    public static void main(String[] args) {
        Graph g = new Graph(new BufferedReader(new InputStreamReader(System.in)));
        Graph gr = new Graph(g.V());
        for (int w = 0 ; w < g.V(); w++)
            for (int v : g.adj(w))
            {
                System.out.println(v + ", " + w);
                gr.addEdge(v, w);
            }
        System.out.println(g.toString());
        System.out.println(gr.toString());
    }
}
