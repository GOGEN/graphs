import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by gogen on 02.05.17.
 */
public class Main {

    public static void main(String[] args) {
        Graph g = new Graph();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String initial = br.readLine();
            String trueV = br.readLine();
            int initialInt = Integer.parseInt(initial);
            int trueVInt = Integer.parseInt(trueV);
            g.addVertex(new Number(initialInt));
            BFS bfs = new BFS(g, new Number(initialInt), new Number(trueVInt));
            for (Number n : bfs.getResult()) {
                System.out.println(n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
