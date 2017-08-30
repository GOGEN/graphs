import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gogen on 02.05.17.
 */
public class BFS {
    HashMap<Number, Boolean> marked;
    HashMap<Number, Number> previous;
    List<Number> result;

    public BFS(Graph g, Number initial, Number trueV) throws Exception {
        this.marked = new HashMap();
        this.previous = new HashMap();
        this.result = new LinkedList();
        for (Number v : g.vertices()) {
            this.marked.put(v, false);
            this.previous.put(v, null);
        }
        this.bfs(g, initial, trueV);
    }

    public void bfs(Graph g, Number initial, Number trueV) throws Exception {
        List queue = new LinkedList();
        queue.add(initial);
        previous.put(initial, null);
        this.bfs(g, queue, trueV, this.result);
    }


    public void bfs(Graph g, List queue, Number trueV, List<Number> result) throws Exception {
        while(!queue.isEmpty()) {
            Number v = (Number)queue.remove(0);
            this.marked.put(v, true);
            if (v.equals(trueV)) {
                queue.clear();
                break;
            }
            for(Number w : v.nextAll()) {
                if (!g.hasVertex(w)) {
                    g.addVertex(w);
                    g.addEdge(v, w);
                    marked.put(w, false);
                }
                if (!marked.get(w)) {
                    queue.add(w);
                }
                if (!this.previous.containsKey(w)) {
                    this.previous.put(w, v);
                }
            }
        }
        Number tail = trueV;
        while(tail != null) {
            result.add(0, tail);
            tail = previous.get(tail);
        }
    }

    public List<Number> getResult() {
        return this.result;
    }

}