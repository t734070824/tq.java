package _book._algorithms_4th_edition._4_graph._4_1_undigraph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 连通分量
 * @author 734070824@qq.com
 * @date 2018/9/4 16:19
 */
public class CC {

    private boolean[] marked;

    private int[] id;
    private int count;


    //预处理构造函数
    public CC(Graph G) {

        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if(!marked[s]){
                dfs(G, s);
                count++;
            }
        }

    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        for(int w : G.adj(v)){
            if(!marked[w]){
                dfs(G, w);
            }
        }
    }

    /**
     * v 和 w 是否连通
     * @param v
     * @param w
     * @return
     */
    boolean connected(int v, int w){
        return id[v] == id[w];
    }

    /**
     * 连通分量数
     * @return
     */
    int count(){
        return count;
    }

    /**
     * v 所在的连通分量的标识符 (0 -- count()-1)
     * @param v
     * @return
     */
    int id(int v){
        return id[v];
    }


    public static void main(String[] args) {
        String file = "src/main/java/_book/_algorithms_4th_edition/_4_graph/_4_1_undigraph/tinyG.txt";
        Graph G = new Graph(new In(file));
        CC cc = new CC(G);
        int M = cc.count();
        StdOut.println(M + " components");
        Bag<Integer>[] components = new Bag[M];
        for (int i = 0; i < M; i++) {
            components[i] = new Bag<Integer>();
        }
        for (int v = 0; v < G.V(); v++) {
            components[cc.id(v)].add(v);
        }
        for (int i = 0; i < M; i++) {
            for(int v : components[i]){
                StdOut.print(v + " ");
            }
            StdOut.println();
        }



    }
}
