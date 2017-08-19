/**
 * Created by gogen on 29.03.17.
 */
public class DFS {
    private boolean[] marked;
    private int count;
    private boolean isTree;

    public DFS(Graph g) {
        int edges = 0;
        for (int i = 0; i < g.V(); ++i) {
            for (int j = i + 1; j < g.V(); ++j) {
                if (g.adj(i)[j] == 1) {
                    edges++;
                }
            }
        }
        if (edges != g.V() - 1) {
            isTree = false;
        } else {
            isTree = true;
            marked = new boolean[g.V()];
            validateVertex(0);
            dfs(g, 0);
            for (int i = 0; i < marked.length; i++) {
                if (marked(i) == false) {
                    isTree = false;
                    break;
                }
            }
        }
//        if (isTree == true) {
//            for (int i = 0; i < marked.length; i++) {
//                if (marked(i) == false) {
//                    isTree = false;
//                    break;
//                }
//            }
//        }
    }

    public void dfs(Graph g, int v) {
        count++;
        marked[v] = true;
        int[] row = g.adj(v);
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 1 && !marked[i]) {
                dfs(g, i);
//            } else if(row[i] == 1 && marked[i]) {
//                isTree = false;
//                break;
            } else {
                continue;
            }
        }
    }

    public String treeResult() {
        if (isTree) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public boolean marked(int v) {
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
