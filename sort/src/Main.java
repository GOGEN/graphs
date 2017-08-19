import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by gogen on 09.05.17.
 */
public class Main {

    public static void main(String[] args) {
        Graph g = new Graph(new BufferedReader(new InputStreamReader(System.in)));
        System.out.println(g.toString());
        DFS sort = new DFS(g);
        System.out.print(sort.sortResult());
    }
}
