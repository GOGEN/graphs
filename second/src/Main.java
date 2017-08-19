import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by gogen on 29.03.17.
 */
public class Main {

    public static void main(String[] args) {
        Graph g = new Graph(new BufferedReader(new InputStreamReader(System.in)));
        DFSBanket banket = new DFSBanket(g, 1);
        System.out.print(banket.seatingResult());
    }

}
