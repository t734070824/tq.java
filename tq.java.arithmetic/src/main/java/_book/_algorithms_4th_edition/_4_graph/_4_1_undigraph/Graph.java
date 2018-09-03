package _book._algorithms_4th_edition._4_graph._4_1_undigraph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * 无向图
 * @author 734070824@qq.com
 * @date 2018/9/2 14:54
 */
public class Graph {

    //顶点数
    private final int V;
    //边数
    private int E;

    //邻接表
    private  Bag<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        adj = new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }

    }

    public Graph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    /**
     * 顶点树
     * @return
     */
    public  int V(){
        return V;
    }

    /**
     * 边数
     * @return
     */
    public int E(){
        return E;
    }

    /**
     * 向图中添加一条边 v-w
     * @param v
     * @param w
     */
    void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    /**
     * 和v相邻的多个顶点
     * @param v
     * @return
     */
    Iterable<Integer> adj(int v){
        return adj[v];
    }

    public int adjSize(int v){
        return adj[v].size();
    }

    /**
     * 对象的字符串表示
     * @return
     */
    @Override
    public String toString() {
        String s = V + " ver, " + E + " edges\n";
        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for(int w : this.adj(v)){
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }


    /**
     * v 的度数
     * @param G
     * @param v
     * @return
     */
    public static int degree(Graph G, int v){
        int degree = 0;
        for(int w : G.adj(v)){
            degree++;
        }
        return degree;
    }

    /**
     * 所有顶点的最大度数
     * @param G
     * @return
     */
    public static int maxDegree(Graph G){
        int max = 0;
        for (int v = 0; v < G.V(); v++) {
            if(degree(G, v) > max){
                max = degree(G, v);
            }
        }
        return max;
    }

    /**
     * 所有顶点的平均度数
     * @param G
     * @return
     */
    public static double avgDegree(Graph G){
        return 2 * G.E() / G.V();
    }

    /**
     * 自环的个数
     * @param G
     * @return
     */
    public  static int numberOfSelfLoops(Graph G){
        int count = 0;
        for (int v = 0; v < G.V(); v++) {
            for(int w : G.adj(v)){
                if(v == w){
                    count++;
                }
            }
        }
        //????
        return count / 2;
    }


}
