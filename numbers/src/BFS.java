import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gogen on 02.05.17.
 */
public class BFS {
    HashMap<Number, Boolean> marked;
    List<Number> result;

    public BFS(Graph g, Number trueV) throws Exception {
        this.marked = new HashMap();
        this.result = new LinkedList();
        for (Number v : g.vertices()) {
            this.marked.put(v, false);
        }
        for (Number v : g.vertices()) {
            this.bfs(g, v, trueV);
        }
    }

    public void bfs(Graph g, Number v, Number trueV) throws Exception {
        this.bfs(g, v, trueV, this.result);
    }


    public boolean bfs(Graph g, Number initial, Number trueV, List<Number> result) throws Exception {
        List queue = new LinkedList();
        queue.add(initial);
        boolean isTrue = false;
        while(!queue.isEmpty()) {
            Number v = (Number)queue.remove(0);
            this.marked.put(v, true);
            for(Number w : v.nextAll()) {
                queue.add(w);
                if (initial.equals(trueV)) {
                    result.add(initial);
                    return true;
                }
            }
        }
        return isTrue;
    }

    public List<Number> getResult() {
        return this.result;
    }

}