/**
 * Created by gogen on 02.05.17.
 */
public class Main {

    public static void main(String[] args) {
        Graph g = new Graph();
        try {
            DFS dfs = new DFS(g);
            System.out.println(dfs.getResult());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
