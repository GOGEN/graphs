import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;

/**
 * Created by gogen on 29.03.17.
 */
public class DFS {
    private boolean[] marked;
    private int[] time_in;
    private int[] time_out;
    private int[] f_up;
    private int timer;
    private boolean[] cutpoints;

    public DFS(Graph g, BufferedReader br) {
        try {
            int len = 0;
            len = Integer.parseInt(br.readLine());
            for(int i = 0; i < len; i++) {
                String[] pair = br.readLine().split(" ");
                int v = Integer.parseInt(pair[0]) - 1;
                int w = Integer.parseInt(pair[1]) - 1;
                marked = new boolean[g.V()];
                cutpoints = new boolean[g.V()];
                f_up = new int[g.V()];
                time_in = new int[g.V()];
                time_out = new int[g.V()];
                timer = 0;
                dfs(g, v, -1);
                checkVertex(v, w);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        for (int i = 0; i < g.V(); i++) {
//            validateVertex(i);
//            if (!marked[i]) {
//                dfs(g, i, -1);
//            }
//        }
    }

    public void dfs(Graph g, int v, int p) {
        marked[v] = true;
        time_in[v] = f_up[v] = timer++;
        int child = 0;
        for (int w: g.adj(v)) {
            if (w == v) {
                continue;
            }
            if (marked[w]) {
                f_up[v] = Math.min(f_up[v], time_in[w]);
            } else {
                dfs(g, w, v);
                f_up[v] = Math.min(f_up[v], f_up[w]);
                if (f_up[w] >= time_in[v] && p != -1) {
                    cutpoints[v] = true;
                }
                child++;
            }
        }
        if (p == -1 && child > 1) {
            cutpoints[v] = true;
        }
        time_out[v] = timer++;
    }

    public boolean marked(int v) {
        validateVertex(v);
        return marked[v];
    }

    public void checkVertex(int v, int w) {
        int count = 0;
        for (int j = 0; j < cutpoints.length; j++) {
            if (cutpoints[j] && marked[v] && marked[w] &&
                    time_in[v] < time_in[j] && time_in[j] < time_in[w] &&
                    time_out[v] > time_out[j] && time_out[j] > time_out[w]) {
                count++;
            }
        }
        System.out.println(count);
    }

    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v > V)
            throw new IllegalArgumentException("vertex " + (v - 1) + " is not between 0 and " + (V-1));
    }
}
