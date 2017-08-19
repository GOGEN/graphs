import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by gogen on 01.05.17.
 */
public class Main {

    public static void main(String[] args) {
        Graph g = new Graph(new BufferedReader(new InputStreamReader(System.in)));
        System.out.println(g.toString());
        DFS banket = new DFS(g);
        System.out.print(banket.treeResult());
    }
}
