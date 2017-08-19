import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by gogen on 01.06.17.
 */
public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Graph g = new Graph(br);
        DFS dfs = new DFS(g, br);
    }
}