/**
 * Created by gogen on 29.03.17.
 */
public class DFSBanket {
    private int[] marked;
    private int count;
    private boolean existSeating;

    public DFSBanket(Graph g, int s) {
        existSeating = true;
        marked = new int[g.V()];
        for (int i = 0; i < g.V(); i++) {
            validateVertex(s);
            if (marked[i] == 0) {
                dfs(g, i + 1, 1);
            }
        }
    }

    public void dfs(Graph g, int v, int color) {
        count++;
        marked[v - 1] = color;
        for (int w: g.adj(v)) {
            if (marked[w - 1] == 0) {
                dfs(g, w, -color);
            } else if (marked[w - 1] == color) {
                existSeating = false;
                break;
            }
        }
    }

    public String seatingResult() {
        if (existSeating) {
            String first = "";
            for (int i = 0; i < marked.length; i++) {
                if (marked[i] == 1) {
                    first += (i + 1) + " ";
                }
            }
            return "YES\n" + first;
        } else {
            return "NO";
        }
    }

    public boolean marked(int v) {
        validateVertex(v);
        return marked[v] == 0;
    }


    public int count() {
        return count;
    }


    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v > V)
            throw new IllegalArgumentException("vertex " + (v - 1) + " is not between 0 and " + (V-1));
    }

}
