import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gogen on 02.05.17.
 */
public class DFS {
    HashMap<Vertex, Boolean> marked;
    List<Vertex> result;

    public DFS(Graph g) throws Exception {
        this.marked = new HashMap();
        this.result = new LinkedList();
        for (Vertex v : g.vertices()) {
            this.marked.put(v, false);
        }
        for (Vertex v : g.vertices()) {
            this.dfs(g, v);
        }
    }

    public void dfs(Graph g, Vertex v) throws Exception {
        this.dfs(g, v, this.result);
    }


    public boolean dfs(Graph g, Vertex v, List<Vertex> result) throws Exception {
        this.marked.put(v, true);
        if (v.isTrue()) {
            result.add(v);
            return true;
        }
        boolean isTrue = false;
        for (Vertex w: v.overflowAll()) {
            if (!g.hasVertex(w)) {
                g.addVertex(w);
                this.marked.put(w, false);
            }
            if (!this.marked.get(w)) {
                isTrue = dfs(g, w, result);
                if (isTrue) {
                    result.add(v);
                    break;
                }
            }
        }
        return isTrue;
    }

    public List<Vertex> getResult() {
        return this.result;
    }

}
