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

    //预处理构造函数
    public CC(Graph G) {
    }

    /**
     * v 和 w 是否连通
     * @param v
     * @param w
     * @return
     */
    boolean connected(int v, int w){

        return false;
    }

    /**
     * 连通分量数
     * @return
     */
    int count(){

        return 0;
    }

    /**
     * v 所在的连通分量的标识符 (0 -- count()-1)
     * @param v
     * @return
     */
    int id(int v){

        return v;
    }


    public static void main(String[] args) {
        Graph G = new Graph(new In(""));
        CC cc = new CC(G);
        int M = cc.count();
        StdOut.print(M + " components");
        Bag<Integer>[] components = new Bag[M];
        for (int i = 0; i < M; i++) {
            components[i] = new Bag<Integer>();
        }



    }
}
