import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by gogen on 29.03.17.
 */
public class DFS {
    private int[] marked;
    private int[] vertexCounter;
    private List<Integer> ans;
    private int count;
    private boolean isAcyclic;

    public DFS(Graph g) {
        marked = new int[g.V()];
        vertexCounter = new int[g.V()];
        ans = new ArrayList();
        validateVertex(0);
        dfs(g, 0);
        Collections.reverse(ans);
    }

    public void dfs(Graph g, int v) {
        count++;
        marked[v] = 1;
        for (int w: g.adj(v)) {
            if (marked[w] == 1) {
                ans.clear();
                isAcyclic = true;
                break;
            }
            if (marked[w] == 0) {
                dfs(g, w);

            }
            if (vertexCounter[v] == g.degree(v)) {
                break;
            }
        }
        if (isAcyclic) {
            return;
        }
        ans.add(v);
        marked[v] = 2;
        vertexCounter[v] += 1;
    }

    public String sortResult() {
        return ans.toString();
    }

    public int marked(int v) {
        validateVertex(v);
        return marked[v];
    }

    public int count() {
        return count;
    }

    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + V);
    }

}
